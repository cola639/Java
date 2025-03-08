public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");  // 修改 StringBuffer 内部的字符串
        System.out.println(sb);  // 输出: Hello World
    }
}
