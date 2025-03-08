public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");  // 修改 StringBuilder 内部的字符串
        System.out.println(sb);  // 输出: Hello World
    }
}
