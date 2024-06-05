public class P2Math {
    public static void main(String[] args) {
        // 1 ceil() 方法可对一个数进行上舍入，返回值大于或等于给定的参数，类型为双精度浮点型。
        double d = 100.675;
        float f = -90;

        System.out.println(Math.ceil(d)); // 101.0
        System.out.println(Math.ceil(f)); // -90.0

        // 2 floor() 方法可对一个数进行下舍入，返回给定参数最大的整数，该整数小于或等给定的参数。
        System.out.println(Math.floor(d));  // 100.0
        System.out.println(Math.floor(f));  //  -90.0

        // 3 rint() 方法返回最接近参数的整数值。
        System.out.println(Math.rint(d));  // 101.0
        System.out.println(Math.rint(f));   // -90.0

        // 4 min() 方法用于返回两个参数中的最小值。
        System.out.println(Math.min(d, f));  // -90.0
        System.out.println(Math.min(12.123, 12.456));   // 12.123
        System.out.println(Math.min(23.12, 23.0)); // 23.0

        // 5 max() 方法用于返回两个参数中的最大值。
        System.out.println(Math.max(d, f));  // 100.675
        System.out.println(Math.max(12.123, 12.456));   // 12.456
        System.out.println(Math.max(23.12, 23.0));   // 23.12

        // 6 log() 方法用于返回参数的自然数底数（以 e 为底）的对数值
        double x = 11.635;
        double y = 2.76;
        System.out.printf("e 的值为 %.4f%n", Math.E); // e 的值为 2.7182
        System.out.printf("log(%.3f) 为 %.3f%n", x, Math.log(x)); // log(11.635) 为 1.963

        // 7 pow() 方法用于返回第一个参数的第二个参数次方。
        System.out.printf("e 的值为 %.4f%n", Math.E);  // e 的值为 2.7182
        System.out.printf("pow(%.3f, %.3f) 为 %.3f%n", x, y, Math.pow(x, y)); // pow(11.635, 2.76) 为 46.955

        // 8 sqrt() 方法用于返回参数的算术平方根。
        System.out.printf("e 的值为 %.4f%n", Math.E); // e 的值为 2.7182
        System.out.printf("sqrt(%.3f) 为 %.3f%n", x, Math.sqrt(x)); // sqrt(11.635) 为 3.742
    }
}
