package part5.debug;

public class DebugDemo {
  public static void main(String[] args) {
    System.out.println("Start");
    // point
    printNumbers(4);
    System.out.println("Finsh");
  }

  public static void printNumbers(int limit) {
    for (int i = 0; i < limit; i += 2) {
      System.out.println(i);
    }
  }
}
