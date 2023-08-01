package p2.classes;

public class P2_RunEmployee {
  public static void main(String[] args) {
    P2_Employee p2Employee = new P2_Employee();
    p2Employee.setBaseSalary(50_000);
    p2Employee.setHourlyRate(20);

    int wage = p2Employee.calculateWage(20);
    System.out.println(wage);
  }
}
