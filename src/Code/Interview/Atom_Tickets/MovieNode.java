package Code.Interview.Atom_Tickets;

public class MovieNode {


    private String data;
    private MovieNode left;
    private MovieNode right;

    /**
     * Constructor
     **/
    public MovieNode(String data) {
        this.data = data;
    }

    public static void getDescription() {
        System.out.println("""
                MovieNode:
                 Title: String
                 Left: MovieNode
                 Right: MovieNode""".indent(2));
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
