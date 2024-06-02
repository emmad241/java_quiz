import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    public static Question[] getQuestions() {
        String sql = "SELECT * FROM Questions";

        String url = "jdbc:mysql://localhost:3306/questions";
        String user = "root";
        String password = "sexualmotion1";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            List<Question> questionList = new ArrayList<>();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("question_id");
                String questionText = resultSet.getString("question_text");
                String correctAnswer = resultSet.getString("correct_answer");
                String incorrectAnswer1 = resultSet.getString("incorrect_answer1");
                String incorrectAnswer2 = resultSet.getString("incorrect_answer2");

                Question question = new Question(questionId, questionText, correctAnswer, incorrectAnswer1, incorrectAnswer2);
                questionList.add(question);
            }

            // Convert List to array
            return questionList.toArray(new Question[0]);

        } catch (SQLException e) {
            System.out.println("An error occurred while fetching questions from the database:");
            e.printStackTrace();
            return null; // or throw custom exception
        }
    }
}
