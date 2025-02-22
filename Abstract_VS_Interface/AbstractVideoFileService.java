import java.io.File;

// 实现类：专门处理视频文件
public class AbstractVideoFileService extends AbstractFileService {

    @Override
    public void processFile(File file) {
        // 处理视频文件的具体业务逻辑
        System.out.println("Processing video file: " + file.getName());
    }
}
