import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class QuestionRepository {

    public static Question getRandomQuestion() {
        String sql = "SELECT * FROM Questions ORDER BY RAND() LIMIT 1";
        
        String url = "jdbc:mysql://localhost:3306/questions";
        String user = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int questionId = resultSet.getInt("question_id");
                    String questionText = resultSet.getString("question_text");
                    String correctAnswer = resultSet.getString("correct_answer");
                    String incorrectAnswer1 = resultSet.getString("incorrect_answer1");
                    String incorrectAnswer2 = resultSet.getString("incorrect_answer2");
                    return new Question(questionId, questionText, correctAnswer, incorrectAnswer1, incorrectAnswer2);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred. Maybe user/password is invalid.");
            e.printStackTrace();
            return null;
        }
    }
}
