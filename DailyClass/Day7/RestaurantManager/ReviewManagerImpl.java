import java.util.*;

public class ReviewManagerImpl implements IReviewManager{
    private final List<Review> reviews = new ArrayList<>();

    public ReviewManagerImpl(){};


    @Override
    public void addReview(Review review){
        reviews.add(review);
    };

    @Override
    public void removeReview(int reviewId){
        Iterator<Review> iterator = reviews.iterator();
        while (iterator.hasNext()){
            Review r = iterator.next();
            if (r.getReviewId() == reviewId){
                iterator.remove();
            }
        }
        // Or you can
        // reviews.removeIf(r -> r.getReviewId() == reviewId);
    };


    @Override
    public List<Review> getReviewList(){
        return List.copyOf(reviews);  // 뷰 전용
        // return new ArrayList<>(reviews); // 수정 전용
    }

    @Override
    public Review searchByreviewId(int reviewId){
        for (Review r : reviews){
            if (r.getReviewId() == reviewId){
                return r;
            }
        }
        return null;
    };

    @Override
    public List<Review> getRestaurantReview(int resId){
        return List.copyOf(reviews);  // 뷰 전용
    };
}
