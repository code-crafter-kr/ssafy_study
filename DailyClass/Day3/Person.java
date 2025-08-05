public class Person {
    String name;

    public Person() {};
    public Person(String name){
        this.name = name;
    }

    @Deprecated // 다른 코드에서 이 eat() 메서드를 호출하면 컴파일 시 경고가 뜸. // 완전히 제거된 것은 아니지만, 곧 사라질 수 있거나 다른 방식이 권장됨을 나타냄.
    void eat(){
        System.out.println("냠냠");
    }

    //@Override // 조상 계열에 꼭 있어야함.. 즉 Object에 있어야하는데 없음
    void jump(){
        System.out.println("폴짝");
    }
}
