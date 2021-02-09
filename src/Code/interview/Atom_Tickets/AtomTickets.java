package Code.interview.Atom_Tickets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AtomTickets {
    /*
     * Print a tree of Movies in level order:
     *
     * Print a tree of Movies in level order:
     *
     *              La La Land                (level: 0)
     *               /       \
     *     Hidden Figures   Resident Evil     (level: 1)
     *         /              /      \
     *    Arrival           Lion    Split     (level: 2)
     *
     * MovieNode: Title: String Left: MovieNode Right: MovieNode
     *
     *
     * Write a method that takes in the root node, and print out the movies in
     * level order.
     *
     * Sample Output: La La Land, Hidden Figures, Resident Evil, Arrival, Lion,
     * Split
     *
     */

    private static Tree movies;

    public static void main(String[] args) {
        populateData();
        printMovies();
    }

    // Data to reflect challenge
    private static void populateData() {
        MovieNode arrival = new MovieNode("Arrival");
        MovieNode hiddenFigures = new MovieNode("Hidden Figures");
        hiddenFigures.setLeft(arrival);
        MovieNode lion = new MovieNode("Lion");
        MovieNode split = new MovieNode("Split");
        MovieNode residentEvil = new MovieNode("Resident Evil");
        residentEvil.setLeft(lion);
        residentEvil.setRight(split);
        MovieNode laLaLand = new MovieNode("La La Land");
        laLaLand.setLeft(hiddenFigures);
        laLaLand.setRight(residentEvil);
        movies = new Tree(laLaLand);
    }

    private static void printMovies() {
        List<String> movieTitle = printHelper();
        StringBuilder printMe = new StringBuilder();

        if (!movieTitle.isEmpty()) {
            printMe.append(movieTitle.get(0));
            for (int i = 1; i < movieTitle.size(); i++) {
                printMe.append(", ").append(movieTitle.get(i));

            }
        }

        System.out.println(printMe.toString());
    }

    private static List<String> printHelper() {
        Queue<MovieNode> movieList = new LinkedList<>();
        List<String> returnList = new ArrayList<>();
        if (movies.isEmpty()) {
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

    static class MovieNode {

        // MovieNode:
        // Title: String
        // Left: MovieNode
        // Right: MovieNode
        private String data;
        private MovieNode left;
        private MovieNode right;

        /**
         * Constructor
         **/
        public MovieNode(String data) {
            this.data = data;
        }

        public String getData() {
            return this.data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public MovieNode getLeft() {
            return this.left;
        }

        public void setLeft(MovieNode left) {
            this.left = left;
        }

        public MovieNode getRight() {
            return this.right;
        }

        public void setRight(MovieNode right) {
            this.right = right;
        }

    }

    // No insert or remove node due to being out of the scope of the challenge
    static class Tree {
        private MovieNode root;

        /**
         * Constructor
         **/
        public Tree(MovieNode root) {
            this.root = root;
        }

        public MovieNode getRoot() {
            return this.root;
        }

        public void setRoot(MovieNode root) {
            this.root = root;
        }

        public boolean isEmpty() {
            return this.root == null;
        }
    }
}
