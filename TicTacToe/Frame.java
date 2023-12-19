package TicTacToe;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import first.AI;
public class Frame extends JFrame {
    private Window myWindow;
    private int[][] myGrid;
    private GameBoard myBoard;
    private int size;
    // change ai color  to indicate if ai is on
    public void changeMenuColor(boolean color)
    {
        Color myColor = Color.RED;
        if(color == true)
        {
            myColor = Color.GREEN;
        }
        this.getJMenuBar().getMenu(0).setBackground(myColor);
    }
    public Frame(int[][] myGrid,GameBoard myBoard){
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("AI");
        menu.setBackground(Color.GREEN);
        menu.setOpaque(true); // allow ai colors to be visible
        mb.setOpaque(true);
        mb.add(menu);
        this.myBoard = myBoard;
        this.myGrid = myGrid;
        this.setJMenuBar(mb);
        size = 300;
        this.myWindow = new Window(myGrid, size/2, size/2, size/3);
        myWindow.setPreferredSize(new Dimension(size,size));
        this.setSize(size,size);
        this.add(myWindow);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        myWindow.addMouseListener(new FrameListener(this));
        menu.addMenuListener(new MenuBarListener(myBoard,this));
    };
    public void displayWinner(String winner)
    {
        JOptionPane.showMessageDialog(this, winner,"Result", JOptionPane.PLAIN_MESSAGE);
    };
    public void updateGrid(int[][] newGrid){
        myGrid = newGrid;
        myWindow.updateGrid(myGrid);
    };
    public void addMove(int x, int y)
    {
        myBoard.insertMove(y,x,size/3);
    }
}
