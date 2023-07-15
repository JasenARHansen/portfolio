package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_05_Online_Book_Reader;

@SuppressWarnings("unused")
public class Book {
    private int bookId;
    private String details;

    public Book(int id, String det) {
        bookId = id;
        details = det;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getID() {
        return bookId;
    }

    public void setID(int id) {
        bookId = id;
    }
}
