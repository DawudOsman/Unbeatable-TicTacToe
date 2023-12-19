package TicTacToe;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class FrameListener  implements MouseListener{
    private Frame myFrame;
    public FrameListener(Frame myFrame)
    {
        this.myFrame = myFrame;
    }
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        myFrame.addMove(e.getX(),e.getY());
    }
            @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        //myFrame.playerChoice(e.getX(),e.getY());
    }
     @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //myFrame.playerChoice(e.getX(),e.getY());
    }
     @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //myFrame.playerChoice(e.getX(),e.getY());
    }
     @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //myFrame.playerChoice(e.getX(),e.getY());
    }
}
