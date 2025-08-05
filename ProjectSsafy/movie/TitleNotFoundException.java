public class TitleNotFoundException extends Exception {
    private String title;

    public TitleNotFoundException(String title) {
        super(title + " 제목의 영화를 찾을 수 없습니다.");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}