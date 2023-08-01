package part2.type;

import java.text.NumberFormat;

public class FormatClass {
  public static void main(String[] args) {
    formmatNumber();
  }

  public static void formmatNumber() {
    // chain method
    String result = NumberFormat.getPercentInstance().format(0.1);
    System.out.println(result);
  }
}
