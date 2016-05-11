package engine;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class ArtificialIntelligence {
    private final ArrayList<Button> buttonList;

    public ArtificialIntelligence(ArrayList<Button> listButton) {
        buttonList = listButton;
    }

    // Random Engine
    public int randomEngine() {
        boolean boolRepeat = true;
        int intRand = 0;

        while (boolRepeat) {
            intRand = (int) (Math.random() * 9);
            boolRepeat = buttonList.get(intRand).isDisabled();
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
