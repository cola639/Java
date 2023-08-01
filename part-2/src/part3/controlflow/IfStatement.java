package part3.controlflow;

public class IfStatement {
  public static void main(String[] args) {
    // 1 simplify if statement
    int temp = 32;
    if (temp > 30) {
      System.out.println("Hot day");
      System.out.println("Drink water");
    } else if (temp > 20) {
      System.out.println("Beatiful day");
    } else {
      System.out.println("Cold day");
    }

    // 2 ternary operator
    int income = 120_000;
    String className = income > 100_000 ? "HighIncome" : "Economy";
  }
}
