package model;

import java.time.LocalDate;

public class Transaction {
    private int bookId;
    private int userId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = LocalDate.now();
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public long calculateFine() {
        long days = java.time.temporal.ChronoUnit.DAYS.between(issueDate, returnDate);
        return days > 7 ? (days - 7) * 10 : 0;
    }

    public int getBookId() { return bookId; }
}