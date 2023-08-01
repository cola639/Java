package p2.classes;

public class P1_RunTextBox {
  public static void main(String[] args) {
    // heap || stack
    P1_TextBox p1TextBox1 = new P1_TextBox();
    p1TextBox1.setText("Box 1");
    System.out.println(p1TextBox1.text.toUpperCase());

    P1_TextBox p1TextBox2 = new P1_TextBox();
    p1TextBox2.setText("Box 2");
    System.out.println(p1TextBox2.text);
  }
}
