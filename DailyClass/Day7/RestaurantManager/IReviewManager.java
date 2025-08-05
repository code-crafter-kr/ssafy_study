import java.util.*;

public interface IReviewManager {
    void addReview(Review review);

    void removeReview(int reviewId);

    List<Review> getReviewList();

    Review searchByreviewId(int reviewId);

    List<Review> getRestaurantReview(int resId);
}
