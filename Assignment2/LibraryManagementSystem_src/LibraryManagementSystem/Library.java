package lms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Update a book
    public void updateBook(String bookTitle, Book updatedBook) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(bookTitle)) {
                book.setBookTitle(updatedBook.getBookTitle());
                book.setBookCategory(updatedBook.getBookCategory());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                System.out.println("Book updated: " + book);
                return;
            }
        }
        System.out.println("Book not found: " + bookTitle);
    }

    // Delete a book
    public void deleteBook(String bookTitle) {
        books.removeIf(book -> book.getBookTitle().equalsIgnoreCase(bookTitle));
        System.out.println("Book deleted: " + bookTitle);
    }

    // Add a member
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member);
    }

    // Update a member
    public void updateMember(String memberId, Member updatedMember) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                member.setName(updatedMember.getName());
                member.setContactNumber(updatedMember.getContactNumber());
                member.setEmail(updatedMember.getEmail());
                System.out.println("Member updated: " + member);
                return;
            }
        }
        System.out.println("Member not found: " + memberId);
    }

    // Delete a member
    public void deleteMember(String memberId) {
        members.removeIf(member -> member.getMemberId().equals(memberId));
        System.out.println("Member deleted: " + memberId);
    }

    // Issue a book
    public void issueBook(String memberId, String bookTitle) {
        Book bookToIssue = null;
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(bookTitle)) {
                bookToIssue = book;
                break;
            }
        }
        if (bookToIssue == null) {
            System.out.println("Book not available: " + bookTitle);
            return;
        }

        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                Transaction transaction = new Transaction(
                        "T" + (transactions.size() + 1), memberId, bookTitle, LocalDate.now(), null);
                transactions.add(transaction);
                System.out.println("Book issued: " + transaction);
                return;
            }
        }
        System.out.println("Member not found: " + memberId);
    }

  
    public void returnBook(String memberId, String bookTitle) {
        for (Transaction transaction : transactions) {
            if (transaction.getMemberId().equals(memberId) && 
                transaction.getBookTitle().equalsIgnoreCase(bookTitle) && 
                transaction.getReturnDate() == null) {
                transaction.setReturnDate(LocalDate.now());
                System.out.println("Book returned: " + transaction);
                return;
            }
        }
        System.out.println("Transaction not found for member: " + memberId + " and book: " + bookTitle);
    }
}
