import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainSceneController implements Initializable{

    @FXML
    private TextField answer;

    @FXML
    private Button answerBtn;

    @FXML
    private Text question;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
        question.setText("What is the capital of France?");
    }

    @FXML
    void btnOkClicked(ActionEvent event) {
        String ans = answer.getText();
    }

}
