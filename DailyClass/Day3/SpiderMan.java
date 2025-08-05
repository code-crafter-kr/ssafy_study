public class SpiderMan extends Person {
    boolean isSpider;
    Spider spider = new Spider();


    //원래 public SpiderMan() { super();} 가 있는데 Person에 파라미터 생성자를 추가해버리자 맛이 가버림.
    // 즉 파라미터 생성자를 만들면 디폴트인 생성자가 사라짐)



    void fireWeb() {
        // System.out.println("어떻게 쏘더라");
        if (isSpider) {
            spider.fireWeb();
        } else {
            System.out.println("사람이 안되지");
        }
    }

    void jump1() { // 메서드 재정의
        if (isSpider) {
            spider.jump();
        } else {
            super.jump();
        }
    }
}
