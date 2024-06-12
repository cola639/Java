package p8_interface;

// 文件名: Hockey.java
public interface P2_HockeyInterface extends P2_ExtendInterface {
    public void homeGoalScored();

    public void visitingGoalScored();

    public void endOfPeriod(int period);

    public void overtimePeriod(int ot);
}
