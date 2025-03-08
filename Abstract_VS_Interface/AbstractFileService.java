import java.io.File;

// 定义一个抽象类，提供通用的文件操作逻辑
public abstract class AbstractFileService {

    static String fileName = "AbstractFileService";

    // 共享的文件上传逻辑
    public void uploadFile(File file) {
        if (file != null) {
            // 处理文件上传
            System.out.println("Uploading file: " + file.getName());
        } else {
            System.out.println("File is null!");
        }
    }

    // 每个子类必须实现的抽象方法
    public abstract void processFile(File file);
}
