package controllers;

import engine.ArtificialIntelligence;
import engine.TicTacToe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // Scene Elements

    private final TicTacToe tictactoe = new TicTacToe();
    private final Alert alertPop = new Alert(Alert.AlertType.INFORMATION);
    private final ArrayList<Button> listButton = new ArrayList<>();
    @FXML
    private Button buttonPlay;
    @FXML
    private Pane paneEntrance;
    @FXML
    private RadioButton radioEasy, radioHard;

    // End of Scene Elements

    // Game Start!
    @FXML
    private GridPane gridBoard;
    @FXML
    private TextField textUsername;
    @FXML
    private Label labelUsername, labelPlayerScore, labelComputerScore;
    private AnimationController animControl;
    private GridPaneController gridControl;
    private ArtificialIntelligence AI;

    // Listeners for those elements that are impossible to change using Action event methods
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        animControl = new AnimationController(paneEntrance, gridBoard, buttonPlay);
        gridControl = new GridPaneController(gridBoard, listButton);
        AI = new ArtificialIntelligence(listButton);

        gridControl.buttonInitialize(this::gridButtonAction);

        alertPop.setTitle("End game!");
        alertPop.setHeaderText(null);
        alertPop.getDialogPane().setMaxHeight(100);
        alertPop.getDialogPane().setMaxWidth(200);

        textUsername.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((textUsername.getText()).length() > 8) {
                labelUsername.setText("TOO LONG");
            } else {
                labelUsername.setText(textUsername.getText().toUpperCase());
            }
        });
    }

    // Scene Actions

    public void radioPick(ActionEvent actionEvent) {
        RadioButton radioSelected = (RadioButton)actionEvent.getSource();
        radioSelected.setSelected(true);

        if (radioSelected == radioEasy) {
            radioHard.setSelected(false);
        } else {
            radioEasy.setSelected(false);
        }
    }

    public void buttonPlayAction() {
        if (buttonPlay.getText().equals("PLAY")) {
            animControl.entranceAction(1.0, 0.0, "QUIT", gridBoard, paneEntrance);
            tictactoe.setBoard();
            tictactoe.resetScore();
            resetLabelScore();
        } else {
            animControl.entranceAction(0.0, 1.0, "PLAY", paneEntrance, gridBoard);
            gridControl.buttonClear();
        }
    }

    private void resetLabelScore() {
        labelPlayerScore.setText("0");
        labelComputerScore.setText("0");
    }

    private void gridButtonAction(ActionEvent actionEvent) {
        Button buttonClicked = (Button)actionEvent.getSource();
        int intRow = GridPane.getRowIndex(buttonClicked), intCol = GridPane.getColumnIndex(buttonClicked);
        int intPos;

        buttonClicked.setText("0");
        tictactoe.pick(intRow, intCol, 1);
        repeatedChoice(buttonClicked, intRow, intCol);

        if (radioEasy.isSelected()) {
            intPos = AI.randomEngine();
        } else {
            intPos = AI.randomEngine();
        }

        intRow = intPos / 3;
        intCol = intPos % 3;
        tictactoe.pick(intRow, intCol, 10);

        buttonClicked = listButton.get(intPos);
        buttonClicked.setText("X");
        repeatedChoice(buttonClicked, intRow, intCol);
    }

    private void repeatedChoice(Button buttonChoice, int intRow, int intCol) {
        buttonChoice.setDisable(true);
        tictactoe.checkBoard(intRow, intCol);
        checkWinner();
    }

    private void checkWinner() {
        boolean boolEnd = false;

        switch (tictactoe.checkWin()) {
            case 1:
                alertPop.setContentText("\n    " + labelUsername.getText() + " won!");
                labelPlayerScore.setText(String.valueOf(tictactoe.getPlayerScore()));
                boolEnd = true;
                break;
            case 10:
                alertPop.setContentText("\n    Computer won!");
                labelComputerScore.setText(String.valueOf(tictactoe.getComputerScore()));
                boolEnd = true;
                break;
            case 100:
                alertPop.setContentText("\n       Draw!");
                boolEnd = true;
                break;
        }

        if (boolEnd) {
            if (tictactoe.getPlayerScore() == 10 || tictactoe.getComputerScore() == 10) {
                if (tictactoe.getPlayerScore() == 10) {
                    alertPop.setContentText("\n   You're so Strong!");
                } else {
                    alertPop.setContentText("\n   You're so Basic!");
                }
                resetLabelScore();
                tictactoe.resetScore();
            }
            alertPop.showAndWait();
            gridControl.buttonClear();
            tictactoe.setBoard();
        }
    }
    // End of Scene Actions
}
