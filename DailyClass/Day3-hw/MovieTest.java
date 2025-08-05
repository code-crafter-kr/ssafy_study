public class MovieTest {
	public static void main(String[] args) {
		Movie m = new Movie();
		Movie m2 = new Movie(10, "Hello", "me", "romance", 120);

        MovieManager manager = new MovieManager();
        manager.add(m);
        manager.add(m2);

        for (Movie x : manager.getList()) {
            if (x == null) break;
            System.out.println(x.toString());
        }

        Movie searched_m = manager.searchByTitle("Hello");
        System.out.println(searched_m.toString());
    }

}
