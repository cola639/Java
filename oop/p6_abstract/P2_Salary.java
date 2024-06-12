package p6_abstract;

/* 文件名 : Salary.java */
/*
 * 声明抽象方法会造成以下两个结果：
 * 如果一个类包含抽象方法，那么该类必须是抽象类。
 * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
 * 继承抽象方法的子类必须重写该方法。否则，该子类也必须声明为抽象类。
 * 最终，必须有子类实现该抽象方法，否则，从最初的父类到最终的子类都不能用来实例化对象。
 * 如果Salary类继承了Employee类，那么它必须实现computePay()方法：
 */
public class P2_Salary extends P2_Employee {
    private double salary; // Annual salary

    /* Salary类继承了P2_Employee类，那么它必须实现computePay()方法 */
    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }

}
