package Java.code.interview.Atom_Tickets;

import java.util.LinkedList;
import java.util.Queue;

public record MovieTree(MovieNode root) {

    public static void getDescription() {
        System.out.println("""
                A binary tree of MovieNodes""".indent(2));
    }

    public MovieNode findMovie(String title) {
        Queue<MovieNode> movieList = new LinkedList<>();
        movieList.add(this.root);
        while (!movieList.isEmpty()) {
            MovieNode temp = movieList.remove();
            if (temp == null) {
                continue;
            }
            if (temp.getData().equals(title)) {
                return temp;
            } else {
                movieList.add(temp.getLeft());
                movieList.add(temp.getRight());
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public MovieNode root() {
        return this.root;
    }
}
