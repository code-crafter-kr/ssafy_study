import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {
    private static final int MAX_SIZE = 100;
    private List<Movie> movieList = new ArrayList<>(); // 여기서 바로 생성
    private static final IMovieManager instance = new MovieManagerImpl();

    private MovieManagerImpl() {
        loadData();
    };

    public static IMovieManager getInstance() {
        return instance;
    }

    @Override
    public void add(Movie movie) {
        if (movieList.size() >= MAX_SIZE) {
            System.out.println("더 이상 추가할 수 없습니다.");
            return;
        }
        movieList.add(movie);
    }

    @Override
    public Movie[] getList() {
        return movieList.toArray(Movie[]::new);
    }

    // public Movie[] searchByTitle(String title) {
    // Movie[] tmp = new Movie[size];
    // int count = 0;

    // for (int i = 0; i < size; i++) {
    // Movie m = movieList[i];
    // if (m.getTitle().contains(title)) {
    // tmp[count++] = m;
    // }
    // }

    // return Arrays.copyOf(tmp, count);
    // }

    @Override
    public Movie[] searchByTitle(String title) throws TitleNotFoundException {
        List<Movie> list = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            Movie m = movieList.get(i);
            if (m.getTitle().contains(title)) {
                list.add(m);
            }
        }

        // 검색 결과가 없으면 예외 발생
        if (list.isEmpty()) {
            throw new TitleNotFoundException(title);
        }

        return list.toArray(Movie[]::new);
    }

    @Override
    public SeriesMovie[] getSeriesMovies() {
        List<SeriesMovie> list = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i) instanceof SeriesMovie seriesMovie) {
                list.add(seriesMovie);
            }
        }
        return list.toArray(SeriesMovie[]::new);
    }

    @Override
    public double getRunningTimeAvg() {
        if (movieList.isEmpty())
            return 0.0;

        double result = 0;
        for (int i = 0; i < movieList.size(); i++) {
            result += movieList.get(i).getRunningTime();
        }
        return result / movieList.size();
    }

    @Override
    public Movie[] getMovies() {
        List<Movie> list = new ArrayList<>();
        for (Movie m : movieList) {
            if (!(m instanceof SeriesMovie)) {
                list.add(m);
            }
        }
        return list.toArray(Movie[]::new);
    }

    @SuppressWarnings("unchecked")
    private void loadData(){
        File file = new File("movie.dat");
        if (file.exists()) { // 파일이 존재하면 파일에서 데이터 읽기
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                movieList = (List<Movie>) ois.readObject();
            } catch (Exception e) {
                System.out.println("파일 불러오기 실패");
                e.printStackTrace();
            }
        } else {
            movieList = new ArrayList<>(); // 파일이 없으면 빈 리스트
        }
    }

    @Override
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"))) {
            oos.writeObject(movieList);
        } catch (Exception e) {
            System.out.println("파일 저장 실패");
            e.printStackTrace();
        }
    }

}
