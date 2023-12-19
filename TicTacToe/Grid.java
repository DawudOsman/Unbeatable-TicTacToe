package TicTacToe;
public class Grid {
    private int [][] myGrid;
    private boolean gameOver;
    private boolean gameStarted;
    private int winner;
    private int playerTurn;
    public boolean getGameStarted(){
        return gameStarted;
    }
    public int[][] getGrid(){
        return myGrid;
    }
    public void resetGrid(){
        myGrid = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
        winner = 0;
        gameOver = false;
        gameStarted = false;
        playerTurn = 1;
    };
    public Grid(){
        this.winner = 0;
        this.gameOver = false;
        this.gameStarted = false;
        this.myGrid = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
        this.playerTurn = 1;
    };
    public boolean getGameOver(){
        return gameOver;
    };
    public void addMove(int x, int y)
    {
        if(myGrid[y][x] == 0)
        {
            if(gameStarted == false)
            {
                gameStarted = true;
            }
            myGrid[y][x] = playerTurn;
            playerTurn = playerTurn * -1;
            gameState();
        };
    };
    public void checkWin(int input)
    {
        for(int i = 0; i<=2; i++)
        {
            if(myGrid[1][i] == input && myGrid[2][i] == input && myGrid[0][i] == input)
            {
                winner = input;
                gameOver = true;
                return ;
            }
            if(myGrid[i][1] == input && myGrid[i][2] == input && myGrid[i][0] == input)
            {
                winner = input;
                gameOver = true;
                return;
            }
        }
        if(myGrid[0][0] == input && myGrid[1][1] == input && myGrid[2][2] == input)
        {
            winner = input;
            gameOver = true;
            return;
        };
        if(myGrid[0][2] == input && myGrid[1][1] == input && myGrid[2][0] == input)
        {
            winner = input;
            gameOver = true;
            return;
        };
        return;
    }

    public void checkDraw()
    {
        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 3; x++)
            {
                if(myGrid[y][x] == 0){
                    return;
                }
            };
        };
        winner = 0;
        gameOver = true;
    };
    public void gameState()
    {
        checkWin(1);
        checkWin(-1);
        checkDraw();
    }
    public String endGameString(){
        if(winner == 1){
            return "Player 1 wins";
        }
        if(winner == -1){
            return "Player 2 wins";
        }
        return "Draw";
    }
}
