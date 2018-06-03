package sample;

import javafx.scene.control.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {

    @FXML
    private AnchorPane button;

    @FXML
    private TextArea textout;

    @FXML
    private Label labelout;

    @FXML
    private ComboBox<String> comboBoxLabs;

    @FXML
    private GridPane gridpane;

    @FXML
    private Button OKButton;

    void startLab(int argsNumber, ArrayList<TextField> TextFieldArray, int labNumber){
        String[] args = new String[argsNumber];
        OKButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < argsNumber; i++) {
                    args[i] = TextFieldArray.get(i).getText();
                }
                switch (labNumber){
                    case 1:
                        //lab1.Main.main(args);
                        view.getOutput("C:/Users/valer/IdeaProjects/lab1/out/artifacts/lab1_jar/lab1.jar", args, textout, 1);
                        break;
                    case 2:
                        view.getOutput("C:/Users/valer/IdeaProjects/lab2/out/artifacts/lab2_jar/lab2.jar", args, textout, 2);
                        break;
                    case 3:
                        view.getOutput("C:/Users/valer/IdeaProjects/lab3/out/artifacts/lab3_jar/lab3.jar", args, textout, 3);
                        break;
                    case 4:
                        view.getOutput("C:/Users/valer/IdeaProjects/lab4/out/artifacts/lab4_jar/lab4.jar", args, textout, 4);
                        break;
                }

            }
        });
    }

        @FXML
        public void initialize() {

            textout.setWrapText(true);

            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            "Lab 1",
                            "Lab 2",
                            "Lab 3",
                            "Lab 4"
                    );
            comboBoxLabs.setItems(options);
            view.initializeGridList();

            comboBoxLabs.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(!gridpane.getChildren().isEmpty()){
                        gridpane.getChildren().remove(0);
                    }
                    switch (comboBoxLabs.getValue()){
                        case "Lab 1" :
                            gridpane.getChildren().add(0,view.gridList.get(0));
                            textout.setText(view.OverViewList.get(0));
                            startLab(3, view.labList.get(0), 1);
                            break;
                        case "Lab 2" :
                            gridpane.getChildren().add(0, view.gridList.get(1));
                            textout.setText(view.OverViewList.get(1));
                            startLab(1, view.labList.get(1),2);
                            break;
                        case "Lab 3" :
                            gridpane.getChildren().add(0, view.gridList.get(2));
                            textout.setText(view.OverViewList.get(2));
                            startLab(1, view.labList.get(2),3);
                            break;
                        case "Lab 4" :
                            gridpane.getChildren().add(0, view.gridList.get(3));
                            textout.setText(view.OverViewList.get(3));
                            startLab(2, view.labList.get(3),4);
                            break;
                    }
                }
            });
        }
}


