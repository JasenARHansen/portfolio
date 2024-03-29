package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_05_Online_Book_Reader;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Library {
    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details) {
        if (books.containsKey(id)) {
            return null;
        }
        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public Book find(int id) {
        return books.get(id);
    }

    public boolean remove(Book b) {
        return remove(b.getID());
    }

    public boolean remove(int id) {
        if (!books.containsKey(id)) {
            return false;
        }
        books.remove(id);
        return true;
    }
}
