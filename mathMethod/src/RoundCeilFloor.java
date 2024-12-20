public class RoundCeilFloor {

    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));  // 输出 -1
        System.out.println(Math.round(-1.6));  // 输出 -2
        System.out.println(Math.round(1.5));   // 输出 2

        // Example 1
        double value1 = 3.14;
        System.out.println("Math.ceil(3.14): " + Math.ceil(value1));  // Output: 4.0

        // Example 2
        double value2 = -3.14;
        System.out.println("Math.ceil(-3.14): " + Math.ceil(value2));  // Output: -3.0


        double value3 = 3.14;
        System.out.println("Math.floor(3.14): " + Math.floor(value3));  // Output: 3.0

        // Example 2
        double value4 = -3.14;
        System.out.println("Math.floor(-3.14): " + Math.floor(value4));  // Output: -4.0

     }
}
