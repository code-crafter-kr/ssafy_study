
public class Person {


    private String name;
    private int age;
    private double height;
    private String hobby;
	
	

	Person() {
		
	}
	
	
	// 객체를 생성할때 호출할 생성자, 외부에서 이름, 나이, 키, 취미 정보를 받아와서 사용합니다.
	Person(String name, int age, double height, String hobby) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.hobby = hobby;
	}
	
	/* 멤버 메소드 생성하기 */
	
	// Q. 객체에 저장된 멤버 변수를 출력하기 위한 코드를 작성해 봅시다.
	void showInformation() {
		System.out.println("저의 이름은 " + name + "입니다.");
		System.out.println("저의 나이는 " + age + "입니다.");
		System.out.println("저의 키는 " + height + "입니다.");
		System.out.println("저의 취미 " + hobby + "입니다.");
	}
}
