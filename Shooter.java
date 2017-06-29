package shootinggame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Elena Ngo
 * This class represents the playable ninja and his weapon
 */
public class Shooter implements ActionListener, KeyListener {
    
    //ninja movements
    private int x = 30;
    private int y = 530;
    private int veloX = 0; //Only can move by the x-axis
    
    //bullet movements
    private int wepX = 55;
    private int wepY = 620;
    private int wepVeloX = 0;
    private int wepVeloY = 0; //it moves really fast upwards
    private final int WEP_SPEED = -15;
    
    private final int SPEED = 20;
    private ImageIcon shooter;
    private ImageIcon bullet; //shuriken
    
    Timer wepTime = new Timer(5, this);
    
    JFrame _frame;
   
    public Shooter(JFrame frame)
    {
        _frame = frame;
        veloX = SPEED;
        _frame.addKeyListener(this); //change later
    }
    
    public void paint(Graphics2D g)
    {   
        //the ninja
        shooter = new ImageIcon(new ImageIcon("Hikaru.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        shooter.paintIcon(_frame, g, x, y);
        
        //his shooting weapon
        bullet = new ImageIcon("shuriken.png");
        bullet.paintIcon(_frame, g, wepX, wepY);
    }
    
    /**
     * Represents the movements and actions of the ninja by the keys
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT)
        {
            if (x < -10)
            {
                veloX = 0;
                wepVeloX = 0;
            }
            else
            {
                veloX = -SPEED;
                wepVeloX = -SPEED;
            }
            x = x + veloX;
            wepX = wepX + wepVeloX;
        }
        else if (keyCode == KeyEvent.VK_RIGHT)
        {
            if (x > 600)
            {
                veloX = 0;
                wepVeloX = 0;
            }
            else
            {
                veloX = SPEED;
                wepVeloX = SPEED;
            }
            x = x + veloX;
            wepX = wepX + wepVeloX;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_S) //the 'S' key
        {
            //weapon is used
            wepTime.start();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //weapon is used
        if(wepY < 0)
        {
            wepVeloY = 0;
            wepY = 620;
            wepTime.stop();
        }
        else
        {
            wepVeloY = WEP_SPEED;
            wepY = wepY + wepVeloY;
        }
    }
    
    //get bounds for the shuriken
    public Rectangle getBounds()
    {
        return new Rectangle(wepX, wepY, 30, 30);
    }
}
