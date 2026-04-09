package service;

import model.*;
import java.util.*;

public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // View Books
    public void viewBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Register User
    public void addUser(User user) {
        users.add(user);
    }

    // Issue Book
    public void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.setIssued(true);
                transactions.add(new Transaction(bookId, userId));
                System.out.println("Book issued successfully");
                return;
            }
        }
        System.out.println("Book not available");
    }

    // Return Book
    public void returnBook(int bookId) {
        for (Transaction t : transactions) {
            if (t.getBookId() == bookId) {
                t.returnBook();
                long fine = t.calculateFine();
                System.out.println("Returned. Fine: ₹" + fine);

                for (Book b : books) {
                    if (b.getId() == bookId) {
                        b.setIssued(false);
                    }
                }
                return;
            }
        }
        System.out.println("Transaction not found");
    }

    // Search
    public void searchBook(String keyword) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
            }
        }
    }
}