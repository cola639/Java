package p2.classes;

public class P2_Employee {
  private int baseSalary;
  private int hourlyRate;

  public int calculateWage(int extraHours) {
    return baseSalary + (hourlyRate * extraHours);
  }

  public void setBaseSalary(int baseSalary) {
    if (baseSalary <= 0) throw new IllegalArgumentException("Salary cannot be 0 or less");
    this.baseSalary = baseSalary;
  }

  public void setHourlyRate(int hourlyRate) {
    if (hourlyRate <= 0) throw new IllegalArgumentException("HourlyRate cannot be 0 or less");
    this.hourlyRate = hourlyRate;
  }

  private int getBaseSalary() {
    return baseSalary;
  }

  private int getHourlyRate() {
    return hourlyRate;
  }
}
