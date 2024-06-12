package p8_interface;

/**
 * 接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
 * 接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字。
 * 接口中的方法都是公有的。
 */

/** 文件名 : Animal.java */
interface P1_AnimalInterface {
    public void eat();

    public void travel();
}
