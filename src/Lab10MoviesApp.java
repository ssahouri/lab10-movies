import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Lab10MoviesApp {

	public static void main(String[] args) {

		Movie m1 = new Movie("The Hangover", "Comedy");
		Movie m2 = new Movie("ET", "Scifi");
		m2.setCategory("Scifi");
		Movie m3= new Movie("Black Panther", "Action");
		Movie m4 = new Movie("Dumb and Dumber", "Comedy");
		Movie m5 = new Movie("Titanic", "Drama");
		m5.setCategory("Drama");
		Movie m6 = new Movie("Venom", "Scifi");
		Movie m7 = new Movie("Star Trek", "Scifi");
		m7.setCategory("Action");
		Movie m8 = new Movie("Million Dollar Baby", "Drama");
		Movie m9 = new Movie("Star Wars", "Scifi");
		Movie m10 = new Movie("Girls Trip", "Comedy");
		m10.setCategory("Comedy");
		
		Movie[] movies = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10};
		List<Movie> moviesList = new ArrayList<>();
		for (int i = 0; i < movies.length; i++) {
			moviesList.add(movies[i]);
		}
		getCategories(moviesList);
	}
	private static void chooseCategory(Scanner sc, List<Movie> moviesList, HashSet<String> categories) {
		System.out.println("Which movie category are you interested in? (Scifi, Action, Drama, Comedy): ");
		String answer = sc.nextLine();
		displayMovies(sc, moviesList, categories, answer);
		System.out.println("Would you like to continue? (yes/no): ");
		String userContinue = sc.nextLine();
		if (userContinue.equals("yes")) {
			chooseCategory(sc, moviesList, categories);
		}else {
			System.out.println("Bye!");
		}
	}

	private static void getCategories(List<Movie> moviesList) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> categories = new HashSet<>();
		for (int i = 0; i < moviesList.size(); i++) {
			List<String> temp = moviesList.get(i).getCategory();
			for (int j = 0; j < temp.size(); j++) {
				categories.add(temp.get(j));
			}
		}
		chooseCategory(sc, moviesList, categories);
	}



	private static void displayMovies(Scanner sc, List<Movie> moviesList, HashSet<String> categories, String userResponse) {
		HashSet<String> moviesByCategory = new HashSet<>();
		for (int i = 0; i < moviesList.size(); i++) {
			List<String> temp = moviesList.get(i).getCategory();
			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).matches(userResponse)) {
					moviesByCategory.add(moviesList.get(i).getTitle());
				}
			}
		}
		System.out.println(userResponse + " movies: ");
		for (String movie : moviesByCategory) {
		System.out.println(movie);
		}
	
	}	
	
}
