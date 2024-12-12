package SerializationId;

import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) {
        // 反序列化旧的 User 对象
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User user = (User) in.readObject();
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
            System.out.println("Email: " + user.getEmail());  // 新字段
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
