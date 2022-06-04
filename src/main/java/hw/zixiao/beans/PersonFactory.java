package hw.zixiao.beans;

public class PersonFactory {
    public Person createPersonFactoryMethod() {
        Child child = new Child();
        child.setName("儿子");
        return child;
    }
}
