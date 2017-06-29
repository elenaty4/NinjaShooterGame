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
 * This class produces the Red Circle for the game
 */
public class RedCircle extends Particles{
    
    private int x; //x position will be randomized
    private int y = 20; //they always start from the top
    private int veloX;
    private int veloY;
    private final int SPEED = 3;
    Random _rand = new Random();
    Timer _time = new Timer(5, this);
    
    public RedCircle(JFrame frame, PlayFrame panel) {
        super(frame, panel);
        x = _rand.nextInt(660);
        veloX = SPEED;
        veloY = SPEED;
    }
    
    @Override
    public void paint(Graphics2D g) 
    {
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);
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
     * Causes the Red Circle to disappear when collision is true and adds 20 to 
     * the score because
     * Fast Red Circle = 20 points
     */
    @Override
    public void disappear() //disappears in collision
    {
        if (collision())
        {
            x = 1000;
            y = 1000;
            
            //Red Circle is 20 points
            _panel.score = _panel.score + 20;
            _panel.hitParticle = true;
        }
    }
    
    /**
     * When ninja's weapon touches the red circle, this is triggered
     * @return true if weapon touches red circle and false if otherwise
     */
    @Override
    public boolean collision()
    {
        return super._panel._ninja.getBounds().intersects(getBounds());
    }
    
    /**
     * Gets the position of the RedCircle
     * @return the current position of the Red Circle
     */
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 30, 30);
    }
    
    /**
     * @return true if the Red Circle hits the bottom of the frame. False if otherwise
     */
    @Override
    public boolean hitTheBottom()
    {
        boolean hitBottom = y >= 700;
        return hitBottom;
    }
}
