package p5_polymorphic;

/* 重写 */
/* 文件名 : Salary.java */
public class P2_Salary extends P2_Employee {
    // 全年工资
    private double salary;

    // 构造函数
    public P2_Salary(String name, String address, int number, double salary) {
        //  默认情况：如果父类有无参构造函数且子类没有显式调用父类构造函数，编译器会自动插入对父类无参构造函数的调用。
        //  没有无参构造函数：如果父类没有无参构造函数，子类必须显式调用父类的构造函数。
        //  需要初始化父类成员：如果需要通过构造函数初始化父类成员，子类必须显式调用父类的构造函数。
        //  调用父类的构造函数，初始化父类的成员变量
        super(name, address, number);

        // 初始化子类特有的成员变量salary
        setSalary(salary);
    }

    // 子类重写的 mailCheck 方法
    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法 ");
        System.out.println("邮寄支票给：" + getName() + " ，工资为：" + salary);
    }

    // 获取工资
    public double getSalary() {
        return salary;
    }

    // 设置工资
    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    // 计算工资
    public double computePay() {
        System.out.println("计算工资，付给：" + getName());
        return salary / 52;
    }
}

