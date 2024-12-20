import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.net.InetSocketAddress;
import java.nio.channels.CompletionHandler;
import java.io.IOException;

public class AIOClient {

    public static void main(String[] args) throws IOException {
        AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open();
        clientChannel.connect(new InetSocketAddress("localhost", 8080), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                System.out.println("Connected to server!");
                // 发送消息给服务器
                String message = "Hello, AIO Server!";
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                clientChannel.write(buffer, null, new CompletionHandler<Integer, Void>() {
                    @Override
                    public void completed(Integer result, Void attachment) {
                        System.out.println("Message sent to server.");
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        exc.printStackTrace();
                    }
                });

                // 读取服务器响应
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                clientChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        attachment.flip();
                        String response = new String(attachment.array(), 0, result);
                        System.out.println("Received from server: " + response);
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });

        // 为了保持客户端运行
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
