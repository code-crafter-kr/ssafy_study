import java.util.*;

public class ListTest {
    LinkedList<String> friends = new LinkedList<>();

    public static void main(String[] args) {
        
        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    public void createTest(){
        friends.add("A");
        friends.add(0, "B");
        friends.add(0, "C");
        friends.add("D");
        friends.add("E");
    
        System.out.println(friends);
    }

    public void retrieveTest(){
        System.out.println(friends.isEmpty() + " : " + friends.size());

        for(String str : friends){
            System.out.println(str);
        }

        int idx = friends.indexOf("A");
        int idx2 = friends.indexOf("C");

        System.out.println(idx + " : " + idx2);
        
        List<String> sub = friends.subList(0, 3);
        System.out.println(sub);
    }  

    public void updateTest(){
        int idx = friends.indexOf("A");

        if (idx >= 0){
            friends.set(idx, "X");
        }
    }

    public void deleteTest(){
        friends.remove(0);
        friends.remove("X");
    }
}
