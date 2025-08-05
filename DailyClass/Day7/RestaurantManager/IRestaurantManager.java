import java.util.*;

public interface IRestaurantManager {
    void addRestaurant(Restaurant restaurant);

    void removeRestaurant(int resId);

    List<Restaurant> getRestaurantList();

    Restaurant searchByresId(int resId);

    List<KoreanRestaurant> getKoreanRestaurants();

    List<Restaurant> getNonKoreanRestaurants();

    IReviewManager getReviewManager(int resId);
}