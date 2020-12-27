package CTCI_SOURCE.unprocessed.unprocessed_Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

import CTCI_SOURCE.unprocessed.unprocessed_Ch_07_Object_Oriented_Design.Q7_07_Chat_Server.UserManager;

public class OnlineReaderSystem {
    private final Library library;
    private final CTCI_SOURCE.unprocessed.unprocessed_Ch_07_Object_Oriented_Design.Q7_07_Chat_Server.UserManager userManager;
    private final Display display;

    private Book activeBook;
    private User activeUser;

    public OnlineReaderSystem() {
        userManager = new CTCI_SOURCE.unprocessed.unprocessed_Ch_07_Object_Oriented_Design.Q7_07_Chat_Server.UserManager();
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
