
import java.io.Serializable;


/**
 * 도서 정보를 나타내는 클래스
 */
public class Book implements Serializable {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String desc;
    private int quantity;


    Book() {
    } // default constructor

    Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
        this.quantity = quantity;
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

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
            return String.format("%-10s | %-15s | %-10s | %-10s | %6d | %-20s | %3d",
                isbn, title, author, publisher, price, desc, quantity);
    }
}