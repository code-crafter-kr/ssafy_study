public interface IMovieManager {
    void add(Movie m);

    public Movie[] getList();

    public Movie[] searchByTitle(String title) throws TitleNotFoundException;

    public Movie[] getMovies();

    public SeriesMovie[] getSeriesMovies();

    public double getRunningTimeAvg();

    public void saveData();
}
