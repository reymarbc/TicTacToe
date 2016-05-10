package engine;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class ArtificialIntelligence {
    private ArrayList<Button> buttonList;

    public ArtificialIntelligence(ArrayList<Button> listButton) {
        buttonList = listButton;
    }

    // Random Engine
    public int randomEngine() {
        boolean boolRepeat = true;
        int intRand = 0;

        while (boolRepeat) {
            intRand = (int) (Math.random() * 9);
            if (buttonList.get(intRand).isDisabled()) {
                boolRepeat = true;
            } else {
                boolRepeat = false;
            }
        }

        return intRand;
    }

/*
    public int trueEngine() {
        int intRand = 0;

        return intRand;
    }
*/

}
