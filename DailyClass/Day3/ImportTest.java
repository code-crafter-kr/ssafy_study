
import java.io.File;
import static java.lang.Math.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List; 

// TODO: import 되는 패키지들을 살펴보자.

// END

public class ImportTest {
    // TODO: 다음의 요청 사항들을 처리하시오.
    //  1. Object 타입의 객체를 선언해보자. import 되는 내용은?
    Object obj;
    //  2. code assist를 통해 DateFormat 타입의 객체를 선언해보자.
    DateFormat ds;
    //  3. 아래 주석을 해지하고 오류를 수정해보자. (ctrl shift O)
    File file;
    Date date;
    java.sql.Date date2;

    //  4. java.awt 패키지의 List 타입 변수를 선언해보자.
    java.awt.List awtList;
    //  5. java.util 패키지의 List 타입 변수를 선언해보자.
    List<String> utilList; 

    // END

    public static void main(String[] args) {
        // 1. Math 클래스의 PI 출력
        System.out.println("PI: " + PI);  // static import 덕분에 Math.PI가 아니라 PI로 가능

        // 2. static import로 최대값 출력
        System.out.println("Max: " + max(10, 20));

        // 3. Code assist로 최소값 출력 (IDE에서 min 자동완성 사용)
        System.out.println("Min: " + min(10, 20));
    }

}
