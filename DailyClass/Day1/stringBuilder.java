package Day1;
public class stringBuilder {
    public static void main(String[] args) {
        // String 조작 클래스
        // StringBuilder sb = new StringBuilder();
        // sb.append("Hello ");
        // sb.append("SSAFY").append("!!");
        // System.out.println(sb.toString());

        // sb.setLength(sb.length()-2);
        // System.out.println(sb.toString());
        
        String s = "mylimeorange";
        String t = new String("mylimeorange");
        String m = "mylimeorange";

        if(s == t) System.out.println("s == t");
        if(s.equals(t)) System.out.println("s.equals(t)");
        if(s == m) System.out.println("s == m");

        System.out.println(s);
        s.concat("hello");
        System.out.println(s);

        s = s + "gogogo";
        System.out.println(s);

        System.out.println();
    }
}
