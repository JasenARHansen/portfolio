package Code.Interview.Atom_Tickets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AtomTickets {
    /*
      Print a tree of Movies in level order:
     
      Print a tree of Movies in level order:
     
                   La La Land                (level: 0)
                    /       \
          Hidden Figures   Resident Evil     (level: 1)
              /              /      \
         Arrival           Lion    Split     (level: 2)
     
      MovieNode: Title: String Left: MovieNode Right: MovieNode
     
     
      Write a method that takes in the root node, and print out the movies in
      level order.
     
      Sample Output: La La Land, Hidden Figures, Resident Evil, Arrival, Lion,
      Split
     
     */

    private MovieTree movies;

    public static void getDescription() {
        System.out.println("""
                Print a tree of Movies in level order:
                Print a tree of Movies in level order:
                             La La Land                (level: 0)
                              /       \\
                    Hidden Figures   Resident Evil     (level: 1)
                        /              /      \\
                   Arrival           Lion    Split     (level: 2)
                MovieNode: Title: String Left: MovieNode Right: MovieNode
                Write a method that takes in the root node, and print out the movies in
                level order.
                Sample Output: La La Land, Hidden Figures, Resident Evil, Arrival, Lion,
                Split""".indent(2));
    }

    public void main(String[] args) {
        // Data to reflect challenge
        addMovie("La La Land");
        addMovie("Hidden Figures", "La La Land", "Left");
        addMovie("Arrival", "Hidden Figures", "Left");
        addMovie("Resident Evil", "La La Land", "Right");
        addMovie("Lion", "Resident Evil", "Left");
        addMovie("Split", "Resident Evil", "Right");
        printMovies();
    }

    public void addMovie(String title) {
        MovieNode root = new MovieNode(title);
        this.movies = new MovieTree(root);
    }

    public void addMovie(String title, String parent_title, String side) {
        MovieNode movie = new MovieNode(title);
        MovieNode parent = this.movies.findMovie(parent_title);
        if (parent == null) {
            System.out.format("No movie named: '%s'\n", parent_title);
            return;
        }

        if (side.equals("Left")) {
            parent.setLeft(movie);
        } else if (side.equals("Right")) {

            parent.setRight(movie);
        } else {
            System.out.format("Invalid selection '%s', valid options are 'Left' and 'Right'.\n", side);
        }

    }

    public void printMovies() {
        List<String> movieTitles = getLevelOrderMovies();
        StringBuilder print_string = new StringBuilder();
        if (!movieTitles.isEmpty()) {
            print_string.append(movieTitles.get(0));
            for (int i = 1; i < movieTitles.size(); i++) {
                print_string.append(", ").append(movieTitles.get(i));

            }
        }
        System.out.println(print_string);
    }

    private List<String> getLevelOrderMovies() {
        Queue<MovieNode> movieList = new LinkedList<>();
        List<String> returnList = new ArrayList<>();
        if (this.movies.isEmpty()) {
            return returnList;
        }
        movieList.add(movies.getRoot());
        while (!movieList.isEmpty()) {
            MovieNode temp = movieList.remove();
            if (temp != null) {
                returnList.add(temp.getData());
                movieList.add(temp.getLeft());
                movieList.add(temp.getRight());
            }
        }
        return returnList;
    }
}
