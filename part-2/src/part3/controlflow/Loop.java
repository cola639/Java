package part3.controlflow;

import java.util.Scanner;

public class Loop {
  public static void main(String[] args) {
    //    forLoop();
    //    whileLoop();
    //    doWhileLoop();
    forEachLoop();
  }

  public static void forLoop() {
    // for array length
    int[] numbersArr = {0, 4, 2, 1, 5, 6};
    for (int i = 0; i < numbersArr.length; i++) System.out.println("Hello World" + i);
  }

  public static void whileLoop() {
    // scnner input/output
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (true) {
      System.out.print("Input: ");
      input = scanner.next().toLowerCase();
      if (input.equals("pass")) continue;
      if (input.equals("quit")) break;
      System.out.println(input);
    }
  }

  public static void doWhileLoop() {
    // scnner at least once
    Scanner scanner = new Scanner(System.in);
    String input = "";
    do {
      System.out.print("Input: ");
      input = scanner.next().toLowerCase();
      System.out.println(input);
    } while (!input.equals("quit"));
  }

  public static void forEachLoop() {
    String[] fruits = {"Apple", "Mango", "Orange"};

    for (String fruit : fruits) {
      System.out.println(fruit);
    }
  }
}
