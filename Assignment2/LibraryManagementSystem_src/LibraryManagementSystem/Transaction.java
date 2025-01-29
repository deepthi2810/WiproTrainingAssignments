package lms;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private String memberId;
    private String bookTitle;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction() {}

    public Transaction(String transactionId, String memberId, String bookTitle, LocalDate issueDate, LocalDate returnDate) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", memberId=" + memberId + ", bookTitle=" + bookTitle 
                + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
    }
}
