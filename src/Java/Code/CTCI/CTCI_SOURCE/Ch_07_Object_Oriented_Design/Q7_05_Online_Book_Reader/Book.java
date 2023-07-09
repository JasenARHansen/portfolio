package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

@SuppressWarnings("unused")
public class Book {
  private int bookId;
  private String details;

  public Book(int id, String det) {
    bookId = id;
    details = det;
  }

  public void update() {}

  public int getID() {
    return bookId;
  }

  public void setID(int id) {
    bookId = id;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
