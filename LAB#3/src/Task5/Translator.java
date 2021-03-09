package Task5;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
public class Translator extends Application {
    private Button button1, button2;
    private TextField field1, field2;
    Map<String, String> users = new HashMap<String, String>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        users.put("Hello", "Привіт");
        users.put("Sunday", "Неділя");

        stage.setTitle("Перекладач");
        FlowPane rootNode = new FlowPane(10, 10);// визначаємо розміри горизонтального і
        // вертикального зазорів між елементами
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 200, 200); // розміри вікна
        stage.setScene(scene);
        button1 = new Button("Перекласти");   // визначаємо напис на кнопці
        button1.setOnAction(this::buttonClick1);// визначаємо функцію, яка обробляє подію
        button2 = new Button("Додати");
        button2.setOnAction(this::buttonClick2);
        field1 = new TextField();
        field2 = new TextField();
        rootNode.getChildren().addAll(field1, field2, button1,button2);
        stage.show();

    }

    private void buttonClick1(Event event) {
        try {

            for (Map.Entry<String, String> entry : users.entrySet()) {
                if (entry.getKey().contains(field1.getText()))
                    field2.setText(entry.getValue());
                if(entry.getValue().contains(field1.getText()))
                    field2.setText(entry.getKey());

            }
        } catch (NumberFormatException e1) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Хибні дані!");
            alert.showAndWait();
        }
    }
    private void buttonClick2(Event event) {
        try {
            String s1 = field1.getText();
            String s2 = field2.getText();
            boolean found =false;
            for (Map.Entry<String, String> entry : users.entrySet()) {
                if (users.keySet().contains(field1.getText()))
                    found=false;
                else
                    found=true;
            }
            if(found==true) {
                users.put(field1.getText(), field2.getText());
                field1.clear();
                field2.clear();
            }else {
                field2.clear();
                field2.setText("Це слово уже додано");
            }

        } catch (NumberFormatException e1) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Хибні дані!");
            alert.showAndWait();

        }
    }
}
