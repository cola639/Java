package p2.classes;

public class P4_Employee {
  private int baseSalary;
  private int hourlyRate;

  public static int numberOfEmployees;

  public P4_Employee(int baseSalary) {
    this(baseSalary, 0);
    // setBaseSalary(baseSalary); // validate
    // setHourlyRate(0);
    System.out.println("Run overloading Constructor");
  }

  public P4_Employee(int baseSalary, int hourlyRate) {
    System.out.println("Run No overloading Constructor");
    setBaseSalary(baseSalary); // validate
    setHourlyRate(hourlyRate);
    numberOfEmployees++;
  }

  public static void printNumberOfEmployees() {
    // static method
    System.out.println("printNumberOfEmployees " + numberOfEmployees);
  }

  public int calculateWage(int extraHours) {
    System.out.println("Run No overloading method");
    return baseSalary + (hourlyRate * extraHours);
  }

  public int calculateWage() {
    System.out.println("Run overloading method");
    return calculateWage(0);
  }

  public void setBaseSalary(int baseSalary) {
    if (baseSalary <= 0) throw new IllegalArgumentException("Salary cannot be 0 or less");
    this.baseSalary = baseSalary;
  }

  public void setHourlyRate(int hourlyRate) {
    if (hourlyRate < 0) throw new IllegalArgumentException("HourlyRate cannot be 0 or less");
    this.hourlyRate = hourlyRate;
  }

  private int getBaseSalary() {
    return baseSalary;
  }

  private int getHourlyRate() {
    return hourlyRate;
  }
}
