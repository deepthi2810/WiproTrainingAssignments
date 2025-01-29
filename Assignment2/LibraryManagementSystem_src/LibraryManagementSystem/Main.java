package lms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Add Member");
            System.out.println("5. Update Member");
            System.out.println("6. Delete Member");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book category: ");
                    String bookCategory = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    library.addBook(new Book(bookTitle, bookCategory, author, price));
                    break;

                case 2: // Update Book
                    System.out.print("Enter book title to update: ");
                    String oldBookTitle = scanner.nextLine();
                    System.out.print("Enter new book title: ");
                    String newBookTitle = scanner.nextLine();
                    System.out.print("Enter new book category: ");
                    String newBookCategory = scanner.nextLine();
                    System.out.print("Enter new author name: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new book price: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    library.updateBook(oldBookTitle, new Book(newBookTitle, newBookCategory, newAuthor, newPrice));
                    break;

                case 3: // Delete Book
                    System.out.print("Enter book title to delete: ");
                    String bookTitleToDelete = scanner.nextLine();
                    library.deleteBook(bookTitleToDelete);
                    break;

                case 4: // Add Member
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    library.addMember(new Member(memberId, name, contactNumber, email));
                    break;

                case 5: // Update Member
                    System.out.print("Enter member ID to update: ");
                    String memberIdToUpdate = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new contact number: ");
                    String newContactNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    library.updateMember(memberIdToUpdate, new Member(memberIdToUpdate, newName, newContactNumber, newEmail));
                    break;

                case 6: // Delete Member
                    System.out.print("Enter member ID to delete: ");
                    String memberIdToDelete = scanner.nextLine();
                    library.deleteMember(memberIdToDelete);
                    break;

                case 7: // Issue Book
                    System.out.print("Enter member ID: ");
                    String memberIdForIssue = scanner.nextLine();
                    System.out.print("Enter book title to issue: ");
                    String bookTitleForIssue = scanner.nextLine();
                    library.issueBook(memberIdForIssue, bookTitleForIssue);
                    break;

                case 8: // Return Book
                    System.out.print("Enter member ID: ");
                    String memberIdForReturn = scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    String bookTitleForReturn = scanner.nextLine();
                    library.returnBook(memberIdForReturn, bookTitleForReturn);
                    break;

                case 9: // Exit
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
