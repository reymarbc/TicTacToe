package controllers;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class AnimationController {
    private Pane paneEntrance;
    private GridPane gridBoard;
    private Button buttonPlay;

    public AnimationController (Pane pane, GridPane gridPane, Button button) {
        paneEntrance = pane;
        gridBoard = gridPane;
        buttonPlay = button;
    }

    public void entranceAction(double dblFrom, double dblTo, String strButton, Pane paneEnable, Pane paneDisable) throws InterruptedException {
        FadeTransition fadeEntranceControl = new FadeTransition(Duration.millis(500), paneEntrance);
        FadeTransition fadeBoardControl = new FadeTransition(Duration.millis(500), gridBoard);
        fadeEntranceControl.setFromValue(dblFrom);
        fadeEntranceControl.setToValue(dblTo);
        fadeBoardControl.setFromValue(dblTo);
        fadeBoardControl.setToValue(dblFrom);
        fadeBoardControl.setAutoReverse(false);
        fadeEntranceControl.setAutoReverse(false);

        if (strButton.equals("QUIT")) {
            fadeBoardControl.setDelay(Duration.millis(500));
        } else {
            fadeEntranceControl.setDelay(Duration.millis(500));
        }

        fadeEntranceControl.play();
        fadeBoardControl.play();
        paneEnable.setDisable(false);
        paneDisable.setDisable(true);
        buttonPlay.setText(strButton);
    }
}
