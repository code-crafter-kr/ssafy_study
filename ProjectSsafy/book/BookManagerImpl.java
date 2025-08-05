import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
    private static final int MAX_SIZE = 100;
    private List<Book> books = new ArrayList<>(); // 여기서 바로 생성
    private static final IBookManager instance = new BookManagerImpl();

    private BookManagerImpl() {
        loadData();
    };

    public static IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) {
        if (books.size() == (MAX_SIZE)) {
            System.out.println("더 이상 추가할 수 없음");
        } else {
            books.add(book);
        }
    }

    @Override
    public Book[] getList() {
        return books.toArray(Book[]::new);
    }

    @Override
    public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                return books.get(i);
            }
        }
        throw new ISBNNotFoundException(isbn);
    }

    @Override
    public void remove(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                break;
            }
        }
    }

    @Override
    public Book[] searchByTitle(String title) {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if ((b.getTitle()).contains(title)) {
                list.add(b);
            }
        }
        return list.toArray(Book[]::new);
    }

    @Override
    public Book[] getBooks() {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (!(b instanceof Magazine)) {
                list.add(b);
            }
        }
        return list.toArray(Book[]::new);

    }

    @Override
    public Magazine[] getMagazines() {
        List<Magazine> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b instanceof Magazine) {
                list.add((Magazine) b);
            }
        }
        return list.toArray(Magazine[]::new);

    }

    @Override
    public int getTotalPrice() {
        int result = 0;
        for (int i = 0; i < books.size(); i++) {
            result += books.get(i).getPrice();
        }
        return result;
    }

    @Override
    public double getPriceAvg() {
        if (books.isEmpty()) {
            return 0;
        }
        int result = getTotalPrice();
        return (double) result / books.size();
    }

    @Override
    public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
        Book book = searchByIsbn(isbn); // 자동 exception
        if (book.getQuantity() < quantity)
            throw new QuantityException();

        book.setQuantity(book.getQuantity() - quantity);
    }

    @Override
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        Book book = searchByIsbn(isbn);
        book.setQuantity(book.getQuantity() + quantity);
    }

    private void loadData() {
        File file = new File("book.dat");
        if (file.exists()) { // 파일이 존재하면 파일에서 데이터 읽기
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                books = (List<Book>) ois.readObject();
            } catch (Exception e) {
                System.out.println("파일 불러오기 실패");
                e.printStackTrace();
            }
        } else {
            books = new ArrayList<>(); // 파일이 없으면 빈 리스트
        }
    }

    @Override
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"))) {
            oos.writeObject(books);
        } catch (Exception e) {
            System.out.println("파일 저장 실패");
            e.printStackTrace();
        }
    }

}
