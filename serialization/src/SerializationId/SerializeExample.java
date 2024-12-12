package SerializationId;

import java.io.*;

public class SerializeExample {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("John");
        user.setAge(25);

        // 序列化 User 对象
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(user);
        }
    }
}
