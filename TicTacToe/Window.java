package TicTacToe;
import javax.swing.*;
import java.awt.*;
public class Window extends JPanel {
    private int[][]  myGrid; 
    private int centerX;
    private int centerY;
    private int gridSize;
    public Window(int[][] myGrid,int centerX, int centerY,int gridSize){
        this.centerX = centerX;
        this.centerY = centerY;
        this.gridSize = gridSize;
        this.myGrid = myGrid;
    };
    public void updateGrid(int[][] newGrid){
        myGrid = newGrid;
    };
    public void drawCircle(int x, int y, Graphics g){
        g.drawOval(x-(gridSize/4), y-(gridSize/4), (gridSize/2), gridSize/2);
    };
    public void drawCross(int x, int y, Graphics g){
        g.drawLine(x-(gridSize/4), y-(gridSize/4), x+(gridSize/4), y+(gridSize/4));
        g.drawLine(x-(gridSize/4), y+(gridSize/4), x+(gridSize/4), y-(gridSize/4));
    };
    public void drawBoard(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0; i < 2; i++)
        {
            int X1 = centerX-(gridSize/2) + (i * gridSize);
            int Y11 = (int) (centerY - (gridSize * 1.5));
            int Y22 = (int) (centerY + (gridSize * 1.5));
            int X21 = (int) (centerX - (gridSize * 1.5));
            int X22 = (int) (centerX + (gridSize * 1.5));
            int Y2 = centerY-(gridSize/2) + (i * gridSize);
            g.drawLine(X1,Y11,X1,Y22);
            g.drawLine(X21,Y2,X22,Y2);
        }
    };

    public void checkBoard(Graphics g){
        for(int i = 0; i <=2; i ++)
        {
            for(int j = 0; j<= 2; j++){
                int x = (-gridSize) + (gridSize * j);
                int y = (-gridSize) + (gridSize * i);
                {
                    if(myGrid[i][j] == -1){
                        g.setColor(Color.CYAN);
                        drawCross(x+centerX, y+centerY, g);
                    }
                    else{
                        if(myGrid[i][j] == 1)
                        {
                        g.setColor(Color.ORANGE);
                        drawCircle(x+centerX, y+centerY, g);
                        }
                    };
                }
 
            };
        };
    };
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        drawBoard(g2);
        checkBoard(g2);
        g.setColor(Color.red);
        g.setColor(Color.CYAN);
    };
    
}
