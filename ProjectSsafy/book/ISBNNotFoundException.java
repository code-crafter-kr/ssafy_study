public class ISBNNotFoundException extends Exception {
    private String isbn;

    public ISBNNotFoundException(String isbn) {
        super("해당 ISBN을 찾을 수 없습니다: " + isbn);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
