import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    private Question[] questions;

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
        Question question = getRandomQuestion();
        setQuestion(question);
    }

    @FXML
    void nextQuestion(ActionEvent event) {
        setup();
        Question question = getRandomQuestion();
        setQuestion(question);
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
        this.questions = qr.getQuestions();
    }

    public void setQuestion(Question question) {
        this.question.setText(question.getQuestionText());
        this.correctAnswer = question.getCorrectAnswer();
        this.incorrectAnswer1 = question.getIncorrectAnswer1();
        this.incorrectAnswer2 = question.getIncorrectAnswer2();

        String[] answers = {correctAnswer, incorrectAnswer1, incorrectAnswer2};
        List<String> answerList = Arrays.asList(answers);
        Collections.shuffle(answerList);

        answer1.setText(answerList.get(0));
        answer2.setText(answerList.get(1));
        answer3.setText(answerList.get(2));
    }

    public Question getRandomQuestion() {
        int randomIndex = (int) (Math.random() * questions.length);
        return questions[randomIndex];
    }
}
