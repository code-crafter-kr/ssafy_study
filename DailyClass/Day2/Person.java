public class Person {
    String name;
    int age;
    boolean isHungry;

    void eat(){
        System.out.println("냠냠");
        isHungry = false;
    }

    void work(){
        System.out.println("열씸");
        isHungry = true;
    }
}
