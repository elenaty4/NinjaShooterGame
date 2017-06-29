package shootinggame;

import javax.swing.JFrame;


/**
 *
 * @author Elena Ngo
 * @date 6/29/2017 ver 1.2 
 * This program creates a game out of Java GUI
 */
public class NinjaShootingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new InstructionFrame();
        frame.setTitle("Ninja Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //visibility of the frame. True makes it visible
    }
    
}
