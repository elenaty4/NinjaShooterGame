package shootinggame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Elena Ngo
 * This class produces the Round Green Squares for the game
 */
public class GreenRoundSquare extends Particles{
 
    private int x; //x position will be randomized
    private int y = 20; //they always start from the top
    private int veloX;
    private int veloY;
    private final int SPEED = 1;
    Random _rand = new Random();
    Timer _time = new Timer(5, this);
    
    public GreenRoundSquare(JFrame frame, PlayFrame panel) {
        super(frame, panel);
        x = _rand.nextInt(660);
        veloX = SPEED;
        veloY = SPEED;
    }
    
    @Override
    public void paint(Graphics2D g) 
    {
        g.setColor(Color.GREEN);
        g.fillRoundRect(x, y, 30, 30, 10, 10);
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
     * Causes the Green Round Square to disappear when collision is true and adds 
     * 10 to the score because
     * Green Round Square = 10 points
     */
    @Override
    public void disappear() //disappears in collision
    {
        if (collision())
        {
            x = 1000;
            y = 1000;
            
            //Green Round Square is 10 points
            _panel.score = _panel.score + 10;
            _panel.hitParticle = true;
        }
    }
    
    /**
     * When ninja's weapon touches the green round square, this is triggered
     * @return true if weapon touches green round square and false if otherwise
     */
    @Override
    public boolean collision()
    {
        return super._panel._ninja.getBounds().intersects(getBounds());
    }
    
    /**
     * Gets the position of the GreenRoundSquare
     * @return the current position of the Green Round Square
     */
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 30, 30);
    }
    
    /**
     * @return true if the Green Round Square hits the bottom of the frame. False if otherwise
     */
    @Override
    public boolean hitTheBottom()
    {
        boolean hitBottom = y >= 700;
        return hitBottom;
    }
}
