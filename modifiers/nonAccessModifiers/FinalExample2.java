package nonAccessModifiers;

public class FinalExample2 {
    public static void main(String[] args) {
        FinalExample1 finalClass = new FinalExample1();
        finalClass.finalMethod();
        // 下面的代码会导致编译错误，因为 finalVar 是不可修改的
        // finalClass.finalVar = 20;
    }
}
