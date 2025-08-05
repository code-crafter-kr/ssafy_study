import java.util.Arrays;

public class BookManager {
    private static final int MAX_SIZE = 100;
    private final Book[] books = new Book[MAX_SIZE]; // 여기서 바로 생성
    private int size = 0;

    public void add(Book book) {
        if (size == (MAX_SIZE)) {
            System.out.println("더 이상 추가할 수 없음");
        } else {
            books[size++] = book;
        }
    }

    public Book[] getList() {
        return Arrays.copyOf(books, size);
    }

    public Book searchByIsbn(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    public void remove(String isbn) {
        int searched_idx = -1;
        for (int i = 0; i < size; i++) {
            if ((books[i].getIsbn()).equals(isbn)) {
                searched_idx = i;
                break;
            }
        }

        if (searched_idx == -1) {
            System.out.println("해당 책은 존재하지 않습니다.");
        } else {
            for (int i = searched_idx; i < size - 1; i++) {
                books[i] = books[i+1]; // 한칸씩 당김
            }
            books[size - 1] = null; // 마지막 자리 null로 정리
            size--;
        }
    }
}
