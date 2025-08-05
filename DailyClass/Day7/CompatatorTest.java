import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Person {
	String name;
	int height;
	
	public Person(String name, int height){
        this.name = name;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return name + " (" + height + "cm)";
    }
}

public class CompatatorTest {
	
	public static void main(String[] args) {
		
		List<Person> personList = new ArrayList<>();

		personList.add(new Person("마누엘 노이어", 193));
		personList.add(new Person("해리 케인", 188));
		personList.add(new Person("우파메카노", 186));
		personList.add(new Person("김민재", 190));
		
		
		System.out.println(personList.toString());
		

		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person person1, Person person2) {
				
				int result = person1.height - person2.height;
				

				if(result > 0) {
					return 1;
				}

				else if(result < 0) {
					return -1;
				}
				
				return 0;
			}
		});
		
		//람다식
        Collections.sort(personList, (p1, p2) -> p1.height - p2.height);

		System.out.println(personList.toString());
	}
}
