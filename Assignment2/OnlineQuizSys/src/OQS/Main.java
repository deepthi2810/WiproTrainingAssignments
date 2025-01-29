package OQS;


import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        User user = null;
        int choice;

        do {
            System.out.println("\nOnline Quiz System");
            System.out.println("1. Register User");
            System.out.println("2. Add Question");
            System.out.println("3. Take Quiz");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Register User
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    user = new User(username);
                    System.out.println("User registered successfully: " + user);
                    break;

                case 2: // Add Question
                    if (user == null) {
                        System.out.println("Please register a user first.");
                        break;
                    }
                    System.out.print("Enter the question text: ");
                    String questionText = scanner.nextLine();
                    System.out.print("Enter the number of options: ");
                    int numOptions = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    String[] options = new String[numOptions];
                    for (int i = 0; i < numOptions; i++) {
                        System.out.print("Enter option " + (i + 1) + ": ");
                        options[i] = scanner.nextLine();
                    }

                    System.out.print("Enter the correct answer (1-" + numOptions + "): ");
                    int correctAnswer = scanner.nextInt() - 1; // Convert to 0-based index
                    scanner.nextLine(); // Consume newline

                    Question question = new Question(questionText, options, correctAnswer);
                    quiz.addQuestion(question);
                    break;

                case 3: // Take Quiz
                    if (user == null) {
                        System.out.println("Please register a user first.");
                        break;
                    }
                    quiz.conductQuiz();
                    break;

                case 4: // Exit
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
