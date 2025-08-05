import java.util.*;

public class B_Sorting{
    private String[] langs = {"Java", "C", "JavaScript", "Python"};

    public void sortByAnonymous() {
        Arrays.sort(langs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2) * -1;  // 역순 정렬
            }
        });
    }

    public void sortByLambda(){
        Arrays.sort(langs, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println("길이 오름차순:" + Arrays.toString(langs));
    }
}