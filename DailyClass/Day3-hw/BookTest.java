public class BookTest {
    public static void main(String[] args){
        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
        Book b3 = new Book("35355", "Analysis", "소나무", "jaen.kr", 30000, "SW 모델링");

        BookManager manager = new BookManager();

        manager.add(b1);
        manager.add(b2);
        manager.add(b3);

        System.out.println("******************************도서목록******************************");
        Book[] book_lst = manager.getList();

        for (Book b : book_lst){
            System.out.println(b.toString());
        }

        System.out.println("******************************도서조회21424******************************");
        Book searched_book = manager.searchByIsbn("21424");
        System.out.println(searched_book.toString());

        System.out.println("******************************도서삭제21424******************************");
        manager.remove("21424");

        System.out.println("******************************도서목록******************************");
        book_lst = manager.getList();
        for (Book b : book_lst){
            System.out.println(b.toString());
        }

    }
}
