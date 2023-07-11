package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_05_Online_Book_Reader;

@SuppressWarnings("unused")
public class OnlineReaderSystem {
  private final Library library;
  private final UserManager userManager;
  private final Display display;
  private Book activeBook;
  private User activeUser;

  public OnlineReaderSystem() {
    userManager = new UserManager();
    library = new Library();
    display = new Display();
  }

  public Library getLibrary() {
    return library;
  }

  public UserManager getUserManager() {
    return userManager;
  }

  public Display getDisplay() {
    return display;
  }

  public Book getActiveBook() {
    return activeBook;
  }

  public void setActiveBook(Book book) {
    display.displayBook(book);
    activeBook = book;
  }

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User user) {
    activeUser = user;
    display.displayUser(user);
  }
}
