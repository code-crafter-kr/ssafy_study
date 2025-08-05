import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class D_FunctionalApiTest {
    private List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private Map<String, Integer> map = new HashMap<>(Map.of("hong", 100, "jang", 80, "lim", 95, "kim", 4));

    public static void main(String[] args) {
        D_FunctionalApiTest fpt = new D_FunctionalApiTest();
        // fpt.consumerTest("hong");
        fpt.supplierTest("hong");
        // fpt.functionTest();
        // fpt.operationTest();
        // fpt.predicateTest();
    }



    public void consumerTest(String name) {
        list.forEach(item -> System.out.println(item)); // consumer
        map.forEach((key, value) -> System.out.println(key + " " + value)); // biconsumer

        Optional<Integer> optional = Optional.ofNullable(map.get(name));
        // TODO:map에서 name의 점수를 조회해서 값이 있을 80이상이면 우수, 미만이면 노력필요, 값 없으면 대상없음이라고
        optional.ifPresentOrElse(score -> {
            if (score >= 80){
                System.out.println("우수");
            } else{
                System.out.println("노력필요");
            }
        }, () -> System.out.println("해당 없음"));
        // END
    }

    public void supplierTest(String name) {
        Optional<Integer> optional = Optional.ofNullable(map.get(name));
        int score = optional.orElseGet(() -> new Random().nextInt(101));
        System.out.println(score);
    }

    public void functionTest() {
        String name = "hong";
        // TODO: map에 name이 없었다면 score를 1로 추가하고 있었다면 +1 해주세요.(merge)
        int score = map.merge(name, 1, (ov ,nv) -> ov + nv);
        // END

        // TODO: map에 jang이 있다면 기존 점수에 100점을 더해서 값을 출력해주세요.
        map.computeIfPresent(name, (k ,v) -> v + 100);
        // END
        System.out.println(map);
    }

    public void operationTest() {
        // TODO: 위 배열의 요소를 2배씩으로 대체 하세요.
        list.replaceAll(num -> num*2);

        System.out.println(list);
    }

    public void predicateTest() {
        // TODO: map의 Entry 중 name이 3자 넘고 score가 90점 이상인 것들을 삭제 후 출력해보자.
        map.entrySet().removeIf(entry -> entry.getKey().length() > 3 && entry.getValue() >= 90);
        // END
        System.out.println(map);
    }

}
