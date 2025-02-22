import java.io.File;

// 实现类：专门处理图片文件
public class AbstractImageFileService extends AbstractFileService {

    @Override
    public void processFile(File file) {
        // 处理图片文件的具体业务逻辑
        System.out.println("Processing image file: " + file.getName());
    }
}

