package Task3;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ConsolApp extends Application {
    private TextField from;
    private TextField until;
    private TextArea result;
    private BorderPane root;
    private Button clear;
    private Button stop;
    private Button pause;
    private Button resume;
    private SimpleThread thread;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initFields();
        setFieldsListeners();
        setButtonsListeners();

        thread = new SimpleThread();
        thread.setDaemon(true);

        Label l = new Label("Интервал ");
        Label fromm = new Label("от ");
        Label to = new Label(" до ");
        Label l1 = new Label("     ");
        Label l2 = new Label("     ");
        Label l3 = new Label("     ");
        HBox box = new HBox(l, fromm, from, to, until);
        HBox box2 = new HBox(clear, l1, stop, l2, pause, l3, resume);
        HBox box3 = new HBox(result);
        box.setPadding(new Insets(7, 7, 7, 7));
        box2.setPadding(new Insets(7, 7, 7, 7));
        box2.setPadding(new Insets(10, 10, 10, 10));
        root.setCenter(box2);
        root.setTop(box);
        root.setBottom(box3);
        Scene scene = new Scene(root, 450, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setFieldsListeners() {

        class Listen implements ChangeListener<String> {
            private TextField field;

            public Listen(TextField field) {
                this.field = field;
            }

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                thread.interrupt();
                if (!isNumber(newValue) || newValue.isEmpty() || newValue.contains(",") || newValue.contains(".")) {
                    field.setText(newValue.length() > 1 ? newValue.substring(0, newValue.length() - 1) : "");
                } else {
                    if (checkInterval()) {
                        thread = new SimpleThread();
                        thread.setDaemon(true);
                        thread.setF(Integer.parseInt(from.getText()));
                        thread.setU(Integer.parseInt(until.getText()));
                        thread.start();
                    } else {
                        result.setText("invalid interval");
                    }
                }
            }

        }

        from.textProperty().addListener(new Listen(from));

        until.textProperty().addListener(new Listen(until));
    }

    private void setButtonsListeners() {
        pause.setOnAction(t -> thread.pauseT());
        stop.setOnAction(t -> thread.interrupt());
        resume.setOnAction(t -> thread.resumeT());
        clear.setOnAction(t -> {
            from.clear();
            until.clear();
            result.clear();
            thread.interrupt();
        });
    }

    private boolean checkInterval() {
        if (from.getText().length() == 0 || until.getText().length() == 0) {
            return false;
        }
        Integer i1 = Integer.parseInt(from.getText());
        if (i1 == 0) {
            return false;
        }
        Integer i2 = Integer.parseInt(until.getText());
        switch (i1.compareTo(i2)) {
            case 1:
            case 0:
                return false;
            case -1:
                return true;
        }
        return false;
    }

    private void initFields() {
        root = new BorderPane();
        from = new TextField();
        until = new TextField();
        result = new TextArea();
        clear = new Button("Очистить");
        stop = new Button("Остановить");
        resume = new Button("Возобновить");
        pause = new Button("Пауза");
    }

    private boolean isNumber(String str) {
        if (str == null || str.isEmpty())
            return false;
        if (str.charAt(0) == ',' || str.charAt(0) == '.' || str.contains("-") || str.contains(".") || str.contains(","))
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) & str.charAt(i) != '.' & str.charAt(i) != '-' & str.charAt(i) != ',')
                return false;
        }
        return true;
    }

    class SimpleThread extends Thread {

        private int f;
        private int u;
        private StringBuffer sBuffer;
        private Boolean controller = false;

        public SimpleThread() {
            sBuffer = new StringBuffer();
        }

        public SimpleThread(int f, int u) {
            this.f = f;
            this.u = u;
            sBuffer = new StringBuffer();
        }

        public void setF(int f) {
            this.f = f;
            clearSbuffer();
        }

        public void setU(int u) {
            this.u = u;
            clearSbuffer();
        }

        private void clearSbuffer() {
            if (sBuffer.toString().length() > 0) {
                sBuffer.delete(0, sBuffer.length() - 1);
            }
        }

        public synchronized void resumeT() {
            controller = false;
            notify();
        }

        public void pauseT() {
            controller = true;
        }

        @Override
        public void run() {
            int value = 0;
            int temp = 0;
            for (; f <= u; f++) {
                temp = f;
                String string = "";
                while (temp != 1 || string.isEmpty()) {

                    synchronized (this) {
                        while (controller) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    if (temp % 2 == 0 && temp / 2 != 1) {
                        value = 2;
                    } else if (temp % 3 == 0 && temp / 3 != 1) {
                        value = 3;
                    } else {
                        if (!string.isEmpty()) {
                            string += temp + "  ";
                        } else
                            string += "Простой множитель  ";
                        break;
                    }

                    temp /= value;
                    string += value + " * ";
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    f = u + 1;
                    break;
                }
                string = string.substring(0, string.length() - 2);
                sBuffer.append(f + " = " + string + "\n");
                result.setText(sBuffer.toString());
                result.setScrollTop(Double.MAX_VALUE);
            }
        }

    }

}


