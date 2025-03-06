public class RoundCeilFloor {

    public static void main(String[] args) {
        // Math.round()
        System.out.println(Math.round(-1.5));  // 输出 -1
        System.out.println(Math.round(-1.6));  // 输出 -2
        System.out.println(Math.round(1.5));   // 输出 2

        // Math.ceil()
        System.out.println("---ceil---");
        System.out.println(Math.ceil(1.3));  // 输出 2.0
        System.out.println(Math.ceil(-1.6));  // 输出 -1.0

        // Math.floor()
        System.out.println("---floor---");
        System.out.println(Math.floor(1.5));  // 输出 1.0
        System.out.println(Math.floor(-1.6));  // 输出 -2.0
    }
}
