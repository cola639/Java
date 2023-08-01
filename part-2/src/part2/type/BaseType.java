package part2.type;

import java.util.Arrays;
import java.util.Date;

public class BaseType {
  public static void main(String[] args) {
    intType();
    stringType();
    timeType();
    primitiveType();
    arrayType();
  }

  public static void intType() {
    int myAge = 30;
    myAge = 123_456_789;
    System.out.println(myAge);
  }

  public static void stringType() {
    char myAge = '3'; // 单个字符
    System.out.println(myAge);

    String myStr = "Hello Java";
    System.out.println(myStr.replace('H', 'J')); // return new string
    System.out.println(myStr);

    // c:\Windows\...
    String localPath = "c:\\Windows\\...";
    System.out.println(localPath);
  }

  public static void timeType() {
    Date nowStamp = new Date();
    System.out.println(nowStamp);
  }

  public static void primitiveType() {
    int x = 1;
    int y = x;
    x = 2;
    System.out.println(x); // 2
    System.out.println(y); //  1
  }

  public static void arrayType() {
    int[] numbersArr = {0, 4, 2, 1, 5};
    System.out.println(numbersArr.length);
    Arrays.sort(numbersArr);
    System.out.println(Arrays.toString(numbersArr));

    int[][] twodimensionalArr = {{0, 1, 2}, {3, 4, 5}};
    System.out.println(Arrays.toString(twodimensionalArr));
    System.out.println(Arrays.deepToString(twodimensionalArr));
  }
}
