public class Review {
    protected int reviewId;
    protected int resId;
    protected String writer;
    protected String content;

    public Review(){};
    public Review(int reviewId, int resId, String writer, String content){
        this.reviewId = reviewId;
        this.resId = resId;
        this.writer = writer;
        this.content = content;
    }

    public int getReviewId(){
        return this.reviewId;
    }

    public void setReviewId(int reviewId){
        this.reviewId = reviewId;
    }
    public int getResId(){
        return this.resId;
    }

    public void setResId(int resId){
        this.resId = resId;
    }

    public String getWriter(){
        return this.writer;
    }

    public void setWriter(String writer){
        this.writer = writer;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format("%-4d | %-4d | %10s | %-20s", reviewId, resId, writer, content);
    }

}
