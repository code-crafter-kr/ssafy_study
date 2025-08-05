import java.util.Optional;

public class C_Optional {
    public void useString1(String str) {
        if (str != null) {
            System.out.println(str + " : " + str.length()); // 만약 str이 null이라면?
        } else {
            System.out.println("str is null");
        }
    }

    public void useString2(Optional<String> str) {
        if (str.isPresent()) {
            System.out.println(str.get() + " : " + str.get().length());
        } else {
            System.out.println("str is empty");
        }
    }

    public static void main(String[] args) {
        C_Optional opt = new C_Optional();
        opt.useString1(null);
        opt.useString2(Optional.of("Hello"));
        opt.useString2(Optional.empty());
    }

}
