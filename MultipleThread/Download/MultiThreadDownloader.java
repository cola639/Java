package Download;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadDownloader {

    // 下载地址 & 保存路径
    private static final String DOWNLOAD_URL = "https://dldir1.qq.com/qqfile/qq/QQNT/Windows/QQ_9.9.18_250401_x64_01.exe";
    private static final String SAVE_PATH = "QQ_9.9.18_250401_x64_01.exe";
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) throws Exception {
        // 获取文件大小
        HttpURLConnection connection = (HttpURLConnection) new URL(DOWNLOAD_URL).openConnection();
        connection.setRequestMethod("HEAD");
        int fileSize = connection.getContentLength();
        System.out.println("下载文件大小: " + (fileSize / 1024 / 1024.0) + " MB");

        // 每段下载区间
        int partSize = fileSize / THREAD_COUNT;

        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        // 线程安全计数器
        AtomicLong downloadedBytes = new AtomicLong(0);

        // 下载开始时间
        long startTime = System.currentTimeMillis();

        // 启动下载任务
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startByte = i * partSize;
            int endByte = (i == THREAD_COUNT - 1) ? fileSize - 1 : (startByte + partSize - 1);
            executor.submit(new DownloadTask(DOWNLOAD_URL, SAVE_PATH, startByte, endByte, downloadedBytes));
        }

        // 启动进度显示线程
        ScheduledExecutorService progressPrinter = Executors.newSingleThreadScheduledExecutor();
        progressPrinter.scheduleAtFixedRate(() -> {
            long downloaded = downloadedBytes.get();
            double percent = downloaded * 100.0 / fileSize;
            double seconds = (System.currentTimeMillis() - startTime) / 1000.0;
            double speed = downloaded / 1024.0 / seconds; // KB/s
            System.out.printf("\r进度：%.2f%%，已下载：%.2f MB，速度：%.2f KB/s",
                    percent, downloaded / 1024.0 / 1024, speed);
        }, 0, 100, TimeUnit.MILLISECONDS); // 每 200ms 更新一次

        // 等待所有线程完成
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        // 停止进度输出
        progressPrinter.shutdownNow();

        // 最终输出
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.printf("\n✅ 下载完成，用时 %.2f 秒\n", timeTaken / 1000.0);
        System.out.println("文件保存位置：" + new File(SAVE_PATH).getAbsolutePath());
    }

    // 下载任务类
    static class DownloadTask implements Runnable {
        private final String url;
        private final String savePath;
        private final int startByte;
        private final int endByte;
        private final AtomicLong downloadedBytes;

        public DownloadTask(String url, String savePath, int startByte, int endByte, AtomicLong downloadedBytes) {
            this.url = url;
            this.savePath = savePath;
            this.startByte = startByte;
            this.endByte = endByte;
            this.downloadedBytes = downloadedBytes;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestProperty("Range", "bytes=" + startByte + "-" + endByte);

                try (InputStream in = conn.getInputStream();
                     RandomAccessFile out = new RandomAccessFile(savePath, "rw")) {
                    out.seek(startByte);
                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                        downloadedBytes.addAndGet(len);
                    }
                }

            } catch (IOException e) {
                System.err.println("线程下载失败：" + e.getMessage());
            }
        }
    }
}
