/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String desc;

    Book() {
    } // default constructor

    Book(String isbn, String title, String author, String publisher, int price, String desc) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
            return String.format("%-10s | %-15s | %-10s | %-10s | %6d | %-20s",
                isbn, title, author, publisher, price, desc);
    }
}