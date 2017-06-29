package shootinggame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Elena ngo
 * This class is an abstract superclass for the shapes
 */
public abstract class Particles implements ActionListener {
    //Make Arrays for randomizer
    
    Color[] _colors = {Color.BLUE, Color.BLACK, Color.CYAN, Color.GREEN, Color.MAGENTA, 
                       Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
    
    
    protected JFrame _frame;
    protected PlayFrame _panel;
    
            
    public Particles(JFrame frame, PlayFrame panel)
    {
        _frame = frame;
        _panel = panel;
    }
    
    public abstract void paint(Graphics2D g);
    
    @Override
    public abstract void actionPerformed(ActionEvent e);
    
    public abstract void disappear(); //disappears in collision
    
    public abstract boolean collision();
    
    public abstract Rectangle getBounds();
    
    public abstract boolean hitTheBottom();
}
