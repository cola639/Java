package part2.type;

public class ArithmeticExpressions {
  public static void main(String[] args) {
    operation();
    casting();
  }

  public static void operation() {
    int result = 10 / 3;
    System.out.println(result); // 3

    double result_2 = (double) 10 / (double) 3; // 3.3333333

    int a = 1;
    int b = 1;
    int x = a++;
    int y = ++b;
    System.out.println(a); // 2
    System.out.println(x); // 1
    System.out.println(b); // 2
    System.out.println(y); // 2
  }

  public static void casting() {
    // byte -> short -> int  -> long  -> float  -> double
    byte x = 3;
    int y = x + 2;
    System.out.println(y);

    // parse type
    String a = "1";
    int b = Integer.parseInt(a) + 2;
    System.out.println(b);
  }
}
