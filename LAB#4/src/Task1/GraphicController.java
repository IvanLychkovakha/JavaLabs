package Task1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import java.lang.reflect.Method;

public class GraphicController {
    @FXML
    private TextField TextFieldA;
    @FXML
    private TextField TextFieldB;
    @FXML
    private TextField TextFieldFx;
    @FXML
    private TextField TextFieldGx;
    @FXML
    private LineChart<Number, Number> chart;
    @FXML
    private NumberAxis x;
    @FXML
    private NumberAxis y;
    private XYChart.Series<Number, Number> series1;
    private int number;
    private Function one;

    @FXML void initialize(){
        one = new Function();
        number = 1;
    }

    @FXML
    private void doBuild(ActionEvent actionEvent) {
        try {
            series1 = new XYChart.Series<>();
            chart.setCreateSymbols(false);

            String expression1 = TextFieldFx.getText().replaceAll("\"", "\\\"");
            String expression2 = TextFieldGx.getText().replaceAll("\"", "\\\"");
            one.genSourceF(expression1, number);
            one.genSourceG(expression2, number);
            series1.setName("h"+number+"(x)");

            try {
                if(one.compileF(number) && one.compileG(number)) {
                    one.setA(Double.parseDouble(TextFieldA.getText()));
                    one.setB(Double.parseDouble(TextFieldB.getText()));
                    double h = (one.getB()-one.getA())/100;

                    Class<?> cls1 = Class.forName("Task1.FX" + number);
                    Method m1 = cls1.getMethod("transform", double.class);

                    Class<?> cls2 = Class.forName("Task1.GX" + number);
                    Method m2 = cls2.getMethod("transform", double.class);

                    for(double x = one.getA(); x<=one.getB(); x += h) {
                        series1.getData().add(new XYChart.Data<>(x, ((double)m1.invoke(null, one.getA()-x) * (double)m2.invoke(null, one.getB()+x))));
                        System.out.println(x + " : " + ((double)m1.invoke(null, one.getA()-x) * (double)m2.invoke(null, x+one.getB())));
                    }
                    chart.getData().add(series1);
                }
            }
            catch(Exception e) {
                System.out.println("Неверніе данніе");
            }

            finally {
                number = number + 1;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong data!");
            alert.showAndWait();

        }
    }

    @FXML
    private void doClear() {
        TextFieldA.clear();
        TextFieldB.clear();
        TextFieldFx.clear();
        TextFieldGx.clear();
        chart.getData().clear();
    }

}
