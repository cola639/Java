package p2.classes;

public class P4_RunEmployee {
  // Constructors
  public static void main(String[] args) {
    P4_Employee p4Employee = new P4_Employee(50_000, 0);
    P4_Employee.printNumberOfEmployees();
    System.out.println("p4Employee numberOfEmployees " + p4Employee.numberOfEmployees);
    System.out.println("static P4_Employee " + P4_Employee.numberOfEmployees);
    int wage = p4Employee.calculateWage(5000); // params VS no params
    System.out.println("wage " + wage);
  }
}
