package part3.controlflow;

public class SwitchStatement {
  public static void main(String[] args) {
    //  1 switch role
    String role = "admin";
    switch (role) {
      case "admin":
        System.out.println("You are admin");
        break; //  no break ↓ execute

      case "moderator ":
        System.out.println("You are moderator");
        break;

      default:
        System.out.println("You are guest");
        break;
    }
  }
}
