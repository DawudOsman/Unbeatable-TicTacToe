package TicTacToe;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.*;
import java.awt.*;
public class MenuBarListener implements MenuListener {
   private GameBoard myBoard;
   private Frame myFrame;
    public MenuBarListener(GameBoard myBoard,Frame myFrame){
        this.myBoard = myBoard;
        this.myFrame = myFrame;
    }
    @Override
    public void menuSelected(MenuEvent e) {
        // TODO Auto-generated method stub
        myBoard.toggleAi();                  
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        // TODO Auto-generated method stub
    }
}
