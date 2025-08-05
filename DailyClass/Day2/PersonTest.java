

public class PersonTest {
    public static void main(String[] args) {
        int a = 10;
        Person p1 = new Person();
        p1.name = "홍길동";
        p1.isHungry = true;
        System.out.println(p1.name + " : " + p1.isHungry);
        p1.eat();
        System.out.println(p1.name + " : " + p1.isHungry);

        Person p2 = new Person();
        p2.name = "김경호";
        p2.age = 10;
        p2.isHungry = true;
        System.out.println(p2.name + " : " + p2.isHungry);
        System.out.println(p1.name + " : " + p1.isHungry);
    }
}
