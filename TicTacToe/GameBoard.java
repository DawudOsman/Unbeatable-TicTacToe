package TicTacToe;

import java.awt.Color;

public class GameBoard {
    // GRID OBJECT
    // FRAME OBJECT
    // 
    private Frame myFrame;
    private Grid myGrid;
    private Ai myAi;
    private boolean ai;
    public void toggleAi()
    {
        if(myGrid.getGameStarted() == false)
        {
            ai = ! ai;
            myFrame.changeMenuColor(ai);
        }

    }
    // checks state and restarts if game is over
    public void checkState()
    {
        if(myGrid.getGameOver() == true)
        {
            String winner = myGrid.endGameString();
            myFrame.displayWinner(winner);
            myGrid.resetGrid();
            updateState();
            
        }
    };
    public GameBoard(){
        this.myGrid = new Grid();
        this.myFrame = new Frame(myGrid.getGrid(),this);
        this.myAi = new Ai(myGrid.getGrid());
        this.ai = true;
    };
    public void updateState(){
        int[][] currGrid =  myGrid.getGrid();
        myFrame.updateGrid(currGrid);
        myFrame.repaint();
    };

    public void aiTurn()   
    {if(myGrid.getGameOver() == false)
        {
            int aiNum = myAi.aiTurn(myGrid.getGrid());
            int jVal = aiNum % 3;
            int iVal = (aiNum - jVal) /3;
            myGrid.addMove(jVal, iVal);
            updateState();
            checkState();
        }
    }
    public void insertMove(int y, int x,int gridSize)
    {

        for (int i = 0; i <= 2; i ++ )
        {
            for(int j = 0; j <= 2 ; j++)
            {
                if( x >= 0 + (gridSize * j) && x <= gridSize + (gridSize * j)){
                    if( y >= 0 +(gridSize * i) && y < gridSize + (gridSize * i))
                    {
                        myGrid.addMove(j, i);
                        updateState();
                        checkState();
                            if(ai == true && myGrid.getGameStarted() == true)
                            {
                                aiTurn();
                            }
                    }
                }
            }
        }
    }

    
}
