public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;

    public Movie() {
    }

    public Movie(int id, String title, String director, String genre, int runningTime) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector(){
        return this.director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public int getRunningTime(){
        return this.runningTime;
    }

    public void setRunningTime(int runningTime){
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
            return String.format("%-10s | %-15s | %-10s | %-10s | %6d",
                id, title, director, genre, runningTime);
    }

}