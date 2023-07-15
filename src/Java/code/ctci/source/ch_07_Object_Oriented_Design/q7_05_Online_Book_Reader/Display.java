package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_05_Online_Book_Reader;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;
        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void refreshTitle() {
        /* updates title display. */
    }

    public void refreshDetails() {
        /* updates details display. */
    }

    public void refreshPage() {
        /* updated page display. */
    }

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void refreshUsername() {
        /* updates username display. */
    }

    public void turnPageBackward() {
        pageNumber--;
        refreshPage();
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }
}
