import java.util.*;
import java.util.stream.*;

public class FromCollectionTest {
    public static void main(String[] args) {
        String[] heroes = {"아이언맨", "스파이더맨", "헐크", "토르", "홍길동", "이몽룡", "성춘향"};
        Stream<String> fromArray = Arrays.stream(heroes);

        List<String> heroList = fromArray.collect(Collectors.toList());

        heroList.stream().forEach(item -> System.out.println(item + " : " + Thread.currentThread().getName()));
        System.out.println();
        heroList.parallelStream().forEach(item -> System.out.println(item + " : " + Thread.currentThread().getName()));

    }    
}
