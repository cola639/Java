package part2.type;

import java.util.Scanner;

public class ReadingInput {
  public static void main(String[] args) {
    reading();
  }

  public static void reading() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Name: ");
    String name = scanner.nextLine().trim();
    System.out.println("You are " + name);
  }
}
