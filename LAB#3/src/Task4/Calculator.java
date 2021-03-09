package Task4;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
public class Calculator extends Application {
    private TextField field1, field2, field3;
    public static void main(String[] args) {
        launch(args);
    }
    private Label label = new Label(" ");
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        FlowPane rootNode = new FlowPane(10, 10);//размер зазоров между єлементами
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 400, 400);
        stage.setScene(scene);
        RadioButton radioButtonFirst = new RadioButton("Додавання");
        radioButtonFirst.setOnAction(this::showButtonText);
        radioButtonFirst.setOnAction(this::button1Click);
        RadioButton radioButtonSecond = new RadioButton("Віднімання");
        radioButtonSecond.setOnAction(this::showButtonText);
        radioButtonSecond.setOnAction(this::button2Click);
        RadioButton radioButtonThird = new RadioButton("Множення");
        radioButtonThird.setOnAction(this::showButtonText);
        radioButtonThird.setOnAction(this::button3Click);
        RadioButton radioButtonFourth = new RadioButton("Ділення");
        radioButtonFourth.setOnAction(this::showButtonText);
        radioButtonFourth.setOnAction(this::button4Click);
        field1 = new TextField();
        field2 = new TextField();
        field3 = new TextField();
        ToggleGroup radioGroup = new ToggleGroup();
        radioButtonFirst.setToggleGroup(radioGroup);
        radioButtonSecond.setToggleGroup(radioGroup);
        radioButtonThird.setToggleGroup(radioGroup);
        radioButtonFourth.setToggleGroup(radioGroup);
        VBox vbox = new VBox(radioButtonFirst, radioButtonSecond, radioButtonThird, radioButtonFourth, label);
        vbox.setSpacing(10);//зазор между кнопками
        vbox.setPadding(new Insets(10, 10, 10, 10));
        rootNode.getChildren().addAll(field1, field2, vbox, field3);
        stage.show();
    }

    private void showButtonText(ActionEvent actionEvent) {
        label.setText(((RadioButton) actionEvent.getSource()).getText());
    }

    private void button1Click(ActionEvent actionevent) {
        try {
            double i = Double.parseDouble(field1.getText());
            double j = Double.parseDouble(field2.getText());
            double k = i + j;
            field3.setText(k + "");
        } catch (NumberFormatException e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Хибні дані!");
            alert.showAndWait();
        }
    }

    private void button2Click(ActionEvent actionevent) {
        try {
            double i = Double.parseDouble(field1.getText());
            double j = Double.parseDouble(field2.getText());
            double k = i - j;
            field3.setText(k + "");
        } catch (NumberFormatException e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Хибні дані!");
            alert.showAndWait();
        }
    }

    private void button3Click(ActionEvent actionevent) {
        try {
            double i = Double.parseDouble(field1.getText());
            double j = Double.parseDouble(field2.getText());
            double k = i * j;
            field3.setText(k + "");
        } catch (NumberFormatException e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Хибні дані!");
            alert.showAndWait();
        }
    }

    private void button4Click(ActionEvent actionevent) {
        try {
            double i = Double.parseDouble(field1.getText());
            double j = Double.parseDouble(field2.getText());
            double k = i / j;
            field3.setText(k + "");
        } catch (NumberFormatException e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Хибні дані!");
            alert.showAndWait();
        }

    }
}