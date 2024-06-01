import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainSceneController implements Initializable{
    private String correctAnswer;
    private String incorrectAnswer1;
    private String incorrectAnswer2;

    @FXML
    private Button answer1;

    @FXML
    private Button answer2;

    @FXML
    private Button answer3;

    @FXML
    private Text question;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setup();
    }

    @FXML
    void onClickAnswer1(ActionEvent event) {
        String selectedAnswer = answer1.getText();
        if (selectedAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }

    @FXML
    void onClickAnswer2(ActionEvent event) {
        String selectedAnswer = answer2.getText();
        if (selectedAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }

    @FXML
    void onClickAnswer3(ActionEvent event) {
        String selectedAnswer = answer3.getText();
        if (selectedAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }

    public void setup() {
        QuestionRepository qr = new QuestionRepository();
        Question q = qr.getRandomQuestion();
        question.setText(q.getQuestionText());
        correctAnswer = q.getCorrectAnswer();
        incorrectAnswer1 = q.getIncorrectAnswer1();
        incorrectAnswer2 = q.getIncorrectAnswer2();
        String[] answers = {correctAnswer, incorrectAnswer1, incorrectAnswer2};
        for (int i = 0; i < answers.length; i++) {
            int randomIndex = (int) (Math.random() * answers.length);
            String temp = answers[i];
            answers[i] = answers[randomIndex];
            answers[randomIndex] = temp;
        }
        answer1.setText(answers[0]);
        answer2.setText(answers[1]);
        answer3.setText(answers[2]);
    }
}
