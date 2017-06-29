package shootinggame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

/**
 * @author Elena Ngo
 * This class produces the slow/easy Blue Squares for the game
 */
public class BlueSquare extends Particles{
    
    private double x; //x position will be randomized
    private double y = 20; //they always start from the top
    private double veloX;
    private double veloY;
    private final double SPEED = 0.5;
    Random _rand = new Random();
    Timer _time = new Timer(5, this);
    
    public BlueSquare(JFrame frame, PlayFrame panel) {
        super(frame, panel);
        x = _rand.nextInt(660);
        veloX = SPEED;
        veloY = SPEED;
    }
    
    @Override
    public void paint(Graphics2D g) 
    {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, 30, 30); //cast double to int
        _time.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
       if(y > 700)
       {
           veloY = 0;
       }
        
       y = y + veloY;
       super._frame.repaint();
    }
    
    /**
     * Causes the Blue Square to disappear when collision is true and adds 5 to 
     * the score because
     * Slow Blue Square = 5 points
     */
    @Override
    public void disappear() //disappears in collision
    {
        if (collision())
        {
            x = 1000;
            y = 1000;
            //Blue square is 5 points
            _panel.score = _panel.score + 5;
            _panel.hitParticle = true;
        }
    }
    
    /**
     * When ninja's weapon touches the blue square, this is triggered
     * @return true if weapon touches blue square and false if otherwise
     */
    @Override
    public boolean collision()
    {
        return _panel._ninja.getBounds().intersects(getBounds());
    }
    
    /**
     * Gets the position of the BlueSquare
     * @return the current position of the Blue Square
     */
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, 30, 30);
    }
    
    /**
     * @return true if the Blue Square hits the bottom of the frame. False if otherwise
     */
    @Override
    public boolean hitTheBottom()
    {
        boolean hitBottom = y >= 700;
        return hitBottom;
    }
}
