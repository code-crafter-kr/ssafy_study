class SingletonClass {
    private static SingletonClass instance = new SingletonClass();
    private SingletonClass() {}
    public static SingletonClass getInstance() {
        return instance;
    }
    public void sayHello() {
        System.out.println("Hello");
    }
}

public class SingletonTest{
    public static void main(String[] args) {
        SingletonClass sc = SingletonClass.getInstance();
        sc.sayHello();
        SingletonClass sc2 = SingletonClass.getInstance();
        System.out.println(sc == sc2);
    }
}

