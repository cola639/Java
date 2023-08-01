package part2.type;

public class MathClass {
  public static void main(String[] args) {
    random();
  }

  public static void random() {
    double result = Math.random();
    System.out.println(result);

    result = Math.round(Math.random() * 100);
    System.out.println(result);
  }
}
