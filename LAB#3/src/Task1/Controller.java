package Task1;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
private XMLDoctor doctor= new XMLDoctor();
    private ObservableList<AbsAppointment> observableList;
    public static void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Помилка");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    /**
     * Створення діалогового вікна вибору файлів
     *
     * @param title - текст заголовку вікна
     */
    public static FileChooser getFileChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        // Починаємо шукати з поточної теки:
        fileChooser.setInitialDirectory(new File("."));
        // Встановлюємо фільтри для пошуку файлів:
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("XML-файли (*.xml)", "*.xml"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Усі файли (*.*)", "*.*"));
        // Вказуємо заголовк вікна:
        fileChooser.setTitle(title);
        return fileChooser;
    }
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldProfession;
    @FXML
    private TextField textFieldText;
    @FXML
    private TextArea textAreaResults;
    @FXML
    private TableView<AbsAppointment> tableViewAppointment;
    @FXML
    private TableColumn<AbsAppointment, Date> tableColumnDate;
    @FXML
    private TableColumn<AbsAppointment, Integer> tableColumnShift;
    @FXML
    private TableColumn<AbsAppointment, Integer> tableColumnNumOfVisitors;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Записуємо порожній рядок замість "No content in table":
        tableViewAppointment.setPlaceholder(new Label(""));
    }
    @FXML
    void doNew() {
        doctor = new XMLDoctor();
        observableList = null;
        textFieldName.setText("");
        textFieldProfession.setText("");
        textFieldText.setText("");
        textAreaResults.setText("");
        tableViewAppointment.setItems(null);
        tableViewAppointment.setPlaceholder(new Label(""));
    }
    @FXML
    void doOpen() {
        FileChooser fileChooser = getFileChooser("Відкрити XML-файл");
        File file;
        if ((file = fileChooser.showOpenDialog(null)) != null) {
            try {
               doctor.readFromFile(file.getCanonicalPath());
                // Заповнюємо текстові поля прочитаними даними:
                textFieldName.setText(doctor.getName());
                textFieldProfession.setText(doctor.getProfession() + "");
                textAreaResults.setText("");
                // Очищаємо та оновлюємо таблицю:
                tableViewAppointment.setItems(null);
                updateTable();
            }
            catch (IOException e) {
                showError("Файл не знайдено");
            }
            catch (JAXBException e) {
                showError("Неправильний формат файлу");
            }
        }
    }
    @FXML
     void doSave() {
        FileChooser fileChooser = getFileChooser("Зберегти XML-файл");
        File file;
        if ((file = fileChooser.showSaveDialog(null)) != null) {
            try {
                updateSourceData(); // оновлюємо дані в моделі
                doctor.writeToFile(file.getCanonicalPath());
                showMessage("Результати успішно збережені");
            }
            catch (Exception e) {
                showError("Помилка запису в файл");
            }
        }
    }

    @FXML
     void doExit() {
        Platform.exit(); // коректне завершення застосунку JavaFX
    }

    @FXML
    void doAdd() {
        SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
        doctor.addAppointment(FORMATTER.parse("0000-00-00",new ParsePosition(0)), 0, 0);
        updateTable(); // створюємо нові дані
    }

    @FXML
    void doRemove() {
        // Не можемо видалити рядок, якщо немає даних:
        if (observableList == null) {
            return;
        }
        // Якщо є рядки, видаляємо останній:
        if (observableList.size() > 0) {
            observableList.remove(observableList.size() - 1);
        }
        // Якщо немає рядків, вказуємо, що дані відсутні:
        if (observableList.size() <= 0) {
            observableList = null;
        }
    }
    @FXML
     void sortByDate() {
        updateSourceData();
        doctor.sortByDate();
        updateTable();
    }

    @FXML
    void sortByVisitors() {
        updateSourceData();
        doctor.sortByVisitors();
        updateTable();
    }
    @FXML
    void doAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Про програму...");
        alert.setHeaderText("Дані про переписи населення");
        alert.setContentText("Версія 1.0");
        alert.showAndWait();
    }

    @FXML
     void nameChanged() {
        // Коли користувач змінив дані в textFieldCountry,
        // автоматично оновлюємо назву:
        doctor.setName(textFieldName.getText());
    }
    @FXML
     void professionChanged() {
        // Коли користувач змінив дані в textFieldArea, автоматично
        // оновлюємо значення території і щільності населення:
        try {
            String profession =textFieldProfession.getText();
            doctor.setProfession(profession);

        }
        catch (NumberFormatException e) {
            // Якщо помилка, повертаємо, як було:
            textFieldProfession.setText(doctor.getProfession() + "");
        }
    }

    @FXML
    void doSearchByWord() {
        // Оновлюємо дані:
        updateSourceData();
        textAreaResults.setText("");
        Integer whoole = 0;
        for (int i = 0; i < doctor.appointmentCount(); i++) {
            whoole+=doctor.getAppointment(i).getNumOfVisitors();

        }
        AbsAppointment app= new Appointment();
        app.setNumOfVisitors(whoole);
        showResults(app);
    }
    @FXML
     void doSearchByMinShift() {
        // Оновлюємо дані:
        updateSourceData();
        textAreaResults.setText("");
        Integer min=doctor.getAppointment(0).getNumOfVisitors();
        for (int i = 0; i < doctor.appointmentCount(); i++) {

            if (min>doctor.getAppointment(i).getNumOfVisitors()) {
                min=doctor.getAppointment(i).getNumOfVisitors();
            }
        }
         Integer minShift=0;
        for (int i = 0; i < doctor.appointmentCount(); i++) {
            if (min==doctor.getAppointment(i).getNumOfVisitors()) {
               minShift=doctor.getAppointment(i).getShift();
                AbsAppointment app= new Appointment();
                app.setShift(minShift);
                showResults(app);
            }
        }
    }
    private void showResults(AbsAppointment app) {
        if(app.getNumOfVisitors()!=null)
            textAreaResults.appendText("Общее кол-во посетителей: " + app.getNumOfVisitors() + " \n");
        else
            textAreaResults.appendText("Смена с наименьшим кол-вом посетителей:" + app.getShift() + "\n");
            textAreaResults.appendText("\n");
    }
    private void updateSourceData() {
        // Переписуємо дані в модель з observableList
        doctor.clearAppointments();
        for (AbsAppointment c : observableList) {
           doctor.addAppointment(c);
        }
    }
    private void updateDate(TableColumn.CellEditEvent<AbsAppointment, Date> t) {
        // Оновлюємо дані про рік:
        AbsAppointment c = t.getTableView().getItems().get(t.getTablePosition().getRow());
        c.setDate(t.getNewValue());
    }
    private void updateShift(TableColumn.CellEditEvent<AbsAppointment, Integer> t) {
        // Оновлюємо дані про рік:
        AbsAppointment c = t.getTableView().getItems().get(t.getTablePosition().getRow());
        c.setShift(t.getNewValue());
    }
    private void updateNumOfVisitors(TableColumn.CellEditEvent<AbsAppointment, Integer> t) {
        // Оновлюємо дані про рік:
        AbsAppointment c = t.getTableView().getItems().get(t.getTablePosition().getRow());
        c.setNumOfVisitors(t.getNewValue());
    }
    private void updateTable() {
        // Заповнюємо observableList:
        List<AbsAppointment> list = new ArrayList<AbsAppointment>();
        observableList = FXCollections.observableList(list);
        for (int i = 0; i < doctor.appointmentCount(); i++) {
            list.add(doctor.getAppointment(i));
        }
        tableViewAppointment.setItems(observableList);

        // Вказуємо для колонок зв'язану з ними властивість і механізм редагування
        // залежно від типу комірок:
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tableColumnDate.setCellFactory(
                TextFieldTableCell.forTableColumn(new DateStringConverter()));
        tableColumnDate.setOnEditCommit(t -> updateDate(t));
        tableColumnShift.setCellValueFactory(new PropertyValueFactory<>("Shift"));
        tableColumnShift.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnShift.setOnEditCommit(t -> updateShift(t));

        tableColumnNumOfVisitors.setCellValueFactory(new PropertyValueFactory<>("NumOfVisitors"));
        tableColumnNumOfVisitors.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnNumOfVisitors.setOnEditCommit(t -> updateNumOfVisitors(t));
    }
}
