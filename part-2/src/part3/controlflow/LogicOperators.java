package part3.controlflow;

public class LogicOperators {
  public static void main(String[] args) {
    int temperature = 12;
    boolean isWarm = temperature > 20 && temperature < 30;
    System.out.println(isWarm);

    boolean hasHighIncome = false;
    boolean hasGoodCredit = true;
    boolean hasCriminalRecord = false;
    boolean isEligible = hasHighIncome || hasGoodCredit;
    boolean isExcellent = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
    System.out.println(isEligible);
    System.out.println(isExcellent);
  }
}
