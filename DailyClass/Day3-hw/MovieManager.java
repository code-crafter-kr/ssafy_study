import java.util.Arrays;

public class MovieManager {
    private static final int MAX_SIZE = 100;
    private final Movie[] movieList = new Movie[MAX_SIZE]; // 여기서 바로 생성
    private int size = 0;

    public void add(Movie movie) {
        if (size == MAX_SIZE) {
            System.out.println("더 이상 추가할 수 없음");
        } else {
            movieList[size++] = movie;
        }
    }

    public Movie[] getList() {
        return Arrays.copyOf(movieList, size);
    }

    public Movie searchByTitle(String title) {
        for (Movie m : movieList) {
            String searched_title = m.getTitle();
            if (title.equals(searched_title)) {
                return m;
            }
        }
        return null;
    }
}
