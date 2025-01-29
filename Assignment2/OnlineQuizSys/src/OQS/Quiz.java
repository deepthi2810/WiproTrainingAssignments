package OQS;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private static final String QuizSystem = null;
	private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        System.out.println("Question added successfully!");
    }

    public void conductQuiz() {
        if (questions.isEmpty()) {
            System.out.println("No questions available. Add questions first!");
            return;
        }

        score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(question);

            System.out.print("Your answer (1-" + question.getOptions().length + "): ");
            int userAnswer = QuizSystem.scanner.nextInt() - 1; // Convert to 0-based index
            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + (question.getCorrectAnswer() + 1) + "\n");
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
    }

    public int getScore() {
        return score;
    }
}
