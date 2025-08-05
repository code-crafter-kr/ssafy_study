import java.util.*;

public class RestaurantManagerImpl implements IRestaurantManager {
    private final List<Restaurant> restaurants = new ArrayList<>(); // 레스토랑이 담길 어레이
    private final Map<Integer, IReviewManager> rvm = new HashMap<>(); // 리뷰 매니저 번호로 식별하고 value는 리뷰매니저를 이어줌
    private static final IRestaurantManager instance = new RestaurantManagerImpl(); //

    private RestaurantManagerImpl() {}; // 컨스트럭터

    public static IRestaurantManager getInstance() {
        return instance;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        rvm.put(restaurant.getResId(), new ReviewManagerImpl());
    }

    @Override
    public void removeRestaurant(int resId) {
        Iterator<Restaurant> iterator = restaurants.iterator();
        while (iterator.hasNext()) {
            Restaurant r = iterator.next();
            if (r.getResId() == resId) {
                iterator.remove();  // 안전하게 제거
            }
        }
        // restaurants.removeIf(r -> r.getResId() == resId);  // 깔끔한 방식
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        return List.copyOf(restaurants); 
        // if you want to list which can be modified =
        // return new ArrayList<>(restaurants);
    }

    @Override
    public Restaurant searchByresId(int resId) {
        for (Restaurant r : restaurants){
            if (r.getResId() == resId){
                return r;
            }
        }
        return null;
    }

    @Override
    public List<KoreanRestaurant> getKoreanRestaurants() {
        List<KoreanRestaurant> result = new ArrayList<>();
        for (Restaurant r : restaurants){
            if (r instanceof KoreanRestaurant kr){
                result.add(kr);
            }
        }
        return result;
    }

    @Override
    public List<Restaurant> getNonKoreanRestaurants() {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant r : restaurants){
            if (!(r instanceof KoreanRestaurant)){
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public IReviewManager getReviewManager(int resId) {
        return rvm.get(resId);
    }
}
