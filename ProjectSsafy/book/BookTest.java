public class BookTest {
    public static void main(String[] args){
        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java Basic", 10);
        Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java Application", 20);
        Book b3 = new Book("35355", "Analysis", "소나무", "jaen.kr", 30000, "SW Modeling" , 30);
        Magazine m1 = new Magazine("45678", "Algorithm", "홍길동", "jaen.kr", 10000, "Jan Algorithm", 40, 2021, 8);
        IBookManager manager = BookManagerImpl.getInstance();

        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(m1);


        manager.saveData();


        // IBookManager manager = BookManagerImpl.getInstance();

        // System.out.println("******************************도서목록******************************");
        // Book[] book_lst = manager.getList();

        // if (book_lst.length == 0){
        //     System.out.println("등록된 도서가 없습니다.");
        //     return; 
        // }

        // for (Book b : book_lst){
        //     System.out.println(b.toString());
        // }
        // System.out.println("******************************일반도서 목록******************************");
        // for (Book b : book_lst){ // Magazine은 사실상 부모꺼의 instance까지 다 가지고 있음
        //     if (!(b instanceof Book)) System.out.println(b.toString());
        // }        

        // System.out.println("******************************잡지 목록******************************");
        // for (Book b : book_lst){
        //     if (b instanceof Magazine) System.out.println(b.toString());
        // }
        // System.out.println("******************************도서 제목 포함검색:Java******************************");
        // for (Book b : manager.searchByTitle("Java")){
        //     System.out.println(b.toString());
        // }
        // System.out.println("******************************도서 판매 21424, 11개******************************");
        // try {
        //     manager.sell("21424", 11);
        // } catch (ISBNNotFoundException | QuantityException e) {
        //     System.out.println(e.getMessage()); // 예외 메시지만 출력
        // }
        // System.out.println("******************************도서 구매 21424, 10개******************************");

        // try {
        //     manager.buy("21424", 10);
        //     System.out.println(manager.searchByIsbn("21424").toString());
        // } catch (ISBNNotFoundException e) {
        //     System.out.println(e.getMessage());
        // }

        // System.out.println("******************************도서 판매 21424, 11개******************************");
        // try {
        //     manager.sell("21424", 11);
        //     System.out.println(manager.searchByIsbn("21424").toString());
        // } catch (ISBNNotFoundException | QuantityException e) {
        //     System.out.println(e.getMessage()); // 예외 메시지만 출력
        // }

        // System.out.printf("도서 가격 총합: %d\n", manager.getTotalPrice());
        // System.out.printf("도서 가격 총합: %.1f", manager.getPriceAvg());
    }
}
