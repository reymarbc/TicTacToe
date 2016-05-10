package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class GridPaneController {
    private GridPane gridBoard;
    private ArrayList<Button> listButton;

    public GridPaneController(GridPane gridPane, ArrayList<Button> buttonList) {
        listButton = buttonList;
        gridBoard = gridPane;
    }

    public void buttonInitialize(EventHandler<ActionEvent> actionEventEventHandler) {
        for (int intCtr = 0; intCtr < 9; intCtr++) {
            Button buttonNew = new Button();
            buttonNew.setOnAction(actionEventEventHandler);
            buttonNew.setFont(new Font("System Bold", 25));
            buttonNew.setMaxWidth(63);
            buttonNew.setMaxHeight(63);
            listButton.add(buttonNew);
            gridBoard.add(buttonNew, intCtr % 3, intCtr / 3);
        }
        gridBoard.setGridLinesVisible(true);
    }

    public void buttonClear() {
        for (Button button : listButton) {
            if (button.isDisabled()) {
                button.setDisable(false);
                button.setText(null);
            }
        }
    }
}
