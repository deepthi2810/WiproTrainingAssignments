package OQS;



public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer; // Index of the correct option (0-based)

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrectAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.length; i++) {
            sb.append((i + 1) + ". " + options[i] + "\n");
        }
        return sb.toString();
    }
}
