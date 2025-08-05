package Day1;
public class TestIntern {
    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = s1.concat("there");      // 힙에만 생성된 "hithere"
        
        // 이 시점에 클래스의 리터럴 풀(Constant Pool)에는
        // "hi"와 "there"만 들어 있고, "hithere"는 없음.
        
        String pooled = s2.intern();         // 풀에 "hithere"가 있으면 기존 풀 객체, 없으면 s2를 풀에 추가
        System.out.println("hello".intern());
        // 1) s2 == pooled?
        System.out.println("s2 == pooled? " + (s2 == pooled));
        // 2) pooled.equals("hithere")?
        System.out.println("pooled.equals(\"hithere\")? " + pooled.equals("hithere"));
    }
}
