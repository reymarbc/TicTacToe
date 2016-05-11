package engine;

public class TicTacToe {
    // Game Variables

    private final int[][] arrBoard = new int[3][3];
    private int intPlayerScore, intComputerScore;
    private boolean boolPlayer, boolComputer, boolDraw;
    private int intDrawCtr;

    // End of Game Variables

    // Methods

    public void setBoard() {
        for (int intRow = 0; intRow < 3; intRow++) {
            for (int intCol = 0; intCol < 3; intCol++) {
                arrBoard[intRow][intCol] = 0;
            }
        }

        intDrawCtr = 0;
        boolPlayer = boolComputer = boolDraw = false;
    }

    public void checkBoard(int intRow, int intCol) {
        int intRowScoreCtr = 0, intColScoreCtr = 0, intDiag1 = 0, intDiag2 = 0, intCtr;

        for (intCtr = 0; intCtr < 3; intCtr++) {
            intRowScoreCtr += arrBoard[intRow][intCtr];
            intColScoreCtr += arrBoard[intCtr][intCol];
            intDiag1 += arrBoard[intCtr][intCtr];
            intDiag2 += arrBoard[intCtr][2 - intCtr];
        }

        if (intRowScoreCtr == 3 || intColScoreCtr == 3 || intDiag1 == 3 || intDiag2 == 3) {
            boolPlayer = true;
            intPlayerScore++;
        } else if (intRowScoreCtr == 30 || intColScoreCtr == 30 || intDiag1 == 30 || intDiag2 == 30) {
            boolComputer = true;
            intComputerScore++;
        } else if (intDrawCtr == 9) {
            boolDraw = true;
        }
    }

    public void pick(int intRow, int intCol, int intCode) {
        arrBoard[intRow][intCol] = intCode;
        intDrawCtr++;
    }

    public int checkWin() {
        if (boolPlayer) {
            return 1;
        } else if (boolComputer) {
            return 10;
        } else if (boolDraw) {
            return 100;
        } else {
            return 0;
        }
    }

    public int getPlayerScore() {
        return intPlayerScore;
    }

    public int getComputerScore() {
        return intComputerScore;
    }

    public void resetScore() {
        intPlayerScore = intComputerScore = 0;
    }
    // End of Methods

}
