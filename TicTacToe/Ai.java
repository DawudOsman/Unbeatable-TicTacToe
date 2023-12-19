package TicTacToe;
import java.util.ArrayList;
public class Ai {
    public Ai(int[][] myGrid){
    };
    public int[][] updateGrid(int[][] myGrid, int x, boolean maxTurn){
        // converts number based on grid into x and y values in order to be  used in nested array
        int jVal = x % 3;
        int iVal = (x - jVal) /3;
        if(maxTurn)
        {
            myGrid[iVal][jVal] = 1;
        }
        else{
            myGrid[iVal][jVal] = -1;
        }
        return myGrid;
    };
    public boolean drawCondition(int[][] grid)
    {
        // checks if there is an empty grid. Returns false if found  (empty grid == no draw)
        for(int i = 0; i <=2; i++)
        {
            for(int j = 0 ; j<=2; j++)
            {
                if(grid[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    // checks if winning combinations have been met 
    public boolean winCondition(int input, int[][] grid)
    {
        for(int i = 0; i<=2; i++)
        {
            if(grid[1][i] == input && grid[2][i] == input && grid[0][i] == input)
            {
                return true;
            }
            if(grid[i][1] == input && grid[i][2] == input && grid[i][0] == input)
            {
                return true;
            }
        }
        if(grid[0][0] == input && grid[1][1] == input && grid[2][2] == input)
        {
            return true;
        }
        if(grid[0][2] == input && grid[1][1] == input && grid[2][0] == input)
        {
            return true;
        }
        return false;        
    }
    // 1 = player 1
    // -1 = player 2
    public int getGameScore(int[][] grid)
    {
        if((winCondition(1,grid) == true))
        {
            return 1;
        }
        else if((winCondition(-1,grid) == true))
        {
            return -1;
        }
        else{
            return 0;
        }        
    }
    // returns score to be used in minimax algo
    public int getScore(int depth,int[][] grid)
    {
        int value = getGameScore(grid);
        if(value == 1)
        {
            return 10 - depth;
        }
        else if(value  == -1)
        {
            return -10 + depth;
        }
        else{
            return 0;
        }
    };
    public boolean checkIsOver(int[][] grid)
    {
        if((winCondition(-1,grid) == true) || (winCondition(1,grid) == true) || (drawCondition(grid) == true)){
            return true;
        }
        else{
            return false;
        }      
    }
    // copies array to be used in minimax algo
    public int[][] copyArray(int[][] myGrid)
    {
        int[][] newArray = new int[3][];
        for(int i = 0; i <myGrid.length;i++)
        {
            newArray[i] = new int[3];
            for(int j = 0; j < myGrid.length;j++)
            {
                newArray[i][j] = myGrid[i][j];
            }
        }
        return newArray;        
    }
    public ArrayList<Integer> countEmpty(int[][] myGrid)
    {
        ArrayList<Integer> emptyNum = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
            {
                if(myGrid[i][j] == 0)
                {
                    emptyNum.add(Integer.valueOf((3*i + j)));
                }

            }
        }
        return emptyNum;
    }
    // calculates the optimal move for ai 
    public int aiTurn(int[][] myGrid)
    {
        int minValue = 10;
        int minNum = 0;
        ArrayList<Integer> emptyNum = countEmpty(myGrid);
        // calculate the best move to make from the number of empty grids
        for(int i = 0; i<emptyNum.size(); i++)
        {
            int[][] gridCopy = copyArray(myGrid);
            int[][] newGrid = updateGrid(gridCopy, emptyNum.get(i), false);
            int curVal = miniMaxAlgo(1, true, newGrid);
            if(curVal < minValue)
            {
                minValue = curVal;
                minNum = emptyNum.get(i);
            }
        }
        return minNum;
    }
    public int miniMaxAlgo(int depth, boolean maxTurn, int[][] myGrid){
        ArrayList<Integer> emptyNum = countEmpty(myGrid);
        if (checkIsOver(myGrid) == true)
        {
           return getScore(depth,myGrid);
        }
        else{
            // get max score 
            if(maxTurn == true){
                int minValue = -10;
                for(int i = 0; i < emptyNum.size(); i++)
                {
                    int[][] copyArray = copyArray(myGrid);
                    int[][] newGrid = updateGrid(copyArray, emptyNum.get(i),true);
                    int curVal = miniMaxAlgo(depth+1, false, newGrid);
                    if(curVal > minValue)
                    {
                        minValue = curVal;
                    }


                }
                return minValue;
                
            }
            // get min score
            else{
                int maxVal = 10;
                for(int i = 0; i < emptyNum.size(); i++)
                {
                    int[][] copyArray = copyArray(myGrid);
                    int[][] newGrid = updateGrid(copyArray, emptyNum.get(i),false);
                    int curVal = miniMaxAlgo(depth+1, true, newGrid);
                    if(maxVal > curVal){
                        maxVal = curVal;
                    }
                }
                return maxVal;

            }
        }
    }
    
}
