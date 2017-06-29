package shootinggame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javafx.scene.media.AudioClip;

/**
 *
 * @author Elena Ngo
 * This class shows the main Game Frame
 */
public class PlayFrame extends JPanel implements ActionListener {
    private final int FRAME_HEIGHT = 700;
    private final int FRAME_WIDTH = 700;
    
    //Add Tokyo Machine FIGHT music
    AudioClip music;
    
    public Shooter _ninja;
    
    //background
    private JLabel _background;
    
    //Positioning
    private Insets _insets;
    private Dimension _size;
    
    //adding score
    JLabel _scoreDisplay;
    public int score = 0;
    public boolean hitParticle = false;
    
    //Timer in here that goes up to 30 seconds
    private Timer _time;
    private JLabel _displayTime;
    private int SECONDS_LEFT = 30;
    private boolean _timeRanOut = false;
    
    private BlueSquare square;
    private RedCircle circle;
    private GreenRoundSquare roundRect;
    private BlueSquare square2;
    private RedCircle circle2;
    private GreenRoundSquare roundRect2;
    private BlueSquare square3;
    private RedCircle circle3;
    private GreenRoundSquare roundRect3;
    
    private int squareCount = 0;
    private int circleCount = 0;
    private int roundRectCount = 0;
    private String shape1;
    private String shape2;
    private String shape3;
    
    String[] _shapes = {"Square", "Circle", "RoundRect"};
    Random _rand;
    
    private JOptionPane _timesUp;
    
    JFrame gameFrame;
    
    public PlayFrame()
    {
        gameFrame = new JFrame();
        gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Ninja Shooting Game");
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true); //visibility of the frame. True makes it visible 
        frameComponents();
        playMusic();
        gameFrame.add(this);
    }
    
    /**
     * Plays the game's music
     */
    private void playMusic()
    {
        music = new AudioClip(this.getClass().getResource("fighto.mp3").toString());
        music.setVolume(0.1);
        music.play();
    }
    
    /**
     * Adds the frame's components
     */
    private void frameComponents()
    {
        setLayout(new BorderLayout());
        _ninja = new Shooter(gameFrame);
        _rand = new Random();
        
        //adding background
        _background = new JLabel(new ImageIcon("Background.png"));
        add(_background);
        _background.setLayout(null); //background is the new JPanelish JLabel
        _insets = _background.getInsets();
        
        //Display time
        _displayTime = new JLabel("Time left: " + String.valueOf(SECONDS_LEFT));
        _displayTime.setOpaque(true);
        _displayTime.setFont(new Font("Arial", Font.BOLD, 30));
        _background.add(_displayTime);
        _size = _displayTime.getPreferredSize();
        _displayTime.setBounds(500 + _insets.left, 20 + _insets.top, _size.width,
                _size.height);
        
        //Display ScoreBoard
        _scoreDisplay = new JLabel("Score: " + "0" + String.valueOf(score));
        _scoreDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        _scoreDisplay.setOpaque(true);
        _background.add(_scoreDisplay);
        _size = _scoreDisplay.getPreferredSize();
        _scoreDisplay.setBounds(20 + _insets.left, 20 + _insets.top, 180,
                _size.height);
        
        _time = new Timer(1000, this);
        _time.start();
    }
    
    /**
     * Creates the shapes randomly that will fall 3 at a time
     * @param g 
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        //How to get graphics from object oriented classes
        Graphics2D g2d = (Graphics2D) g;
        //shooter
        _ninja.paint(g2d);
        
        //start if time does NOT run out
        if(!_timeRanOut)
        {
            if(squareCount == 0 && circleCount == 0 && roundRectCount == 0)
            {
                int randNum = _rand.nextInt(_shapes.length);
                shape1 = _shapes[randNum];
                randNum = _rand.nextInt(_shapes.length);
                shape2 = _shapes[randNum];
                randNum = _rand.nextInt(_shapes.length);
                shape3 = _shapes[randNum];
            
                square = new BlueSquare(gameFrame, this);
                circle = new RedCircle(gameFrame, this);
                roundRect = new GreenRoundSquare(gameFrame, this);
                square2 = new BlueSquare(gameFrame, this);
                circle2 = new RedCircle(gameFrame, this);
                roundRect2 = new GreenRoundSquare(gameFrame, this);
                square3 = new BlueSquare(gameFrame, this);
                circle3 = new RedCircle(gameFrame, this);
                roundRect3 = new GreenRoundSquare(gameFrame, this);
            
                squareCount++;
                circleCount++;
                roundRectCount++;
            }
        
            //for shape 1
            if(shape1.equals("Square"))
            {
                square.paint(g2d);
                square.disappear();
            
            }
            else if (shape1.equals("Circle"))
            {
                circle.paint(g2d);
                circle.disappear();
            
            }
            else if (shape1.equals("RoundRect"))
            {
                roundRect.paint(g2d);
                roundRect.disappear();
            }
        
            //for shape 2
            if(shape2.equals("Square"))
            {
                square2.paint(g2d);
                square2.disappear();
            
            }
            else if (shape2.equals("Circle"))
            {
                circle2.paint(g2d);
                circle2.disappear();
            }
            else if (shape2.equals("RoundRect"))
            {
                roundRect2.paint(g2d);
                roundRect2.disappear();
            }
        
            //for shape 3
            if(shape3.equals("Square"))
            {
                square3.paint(g2d);
                square3.disappear();
            }
            else if (shape3.equals("Circle"))
            {
                circle3.paint(g2d);
                circle3.disappear();
            }
            else if (shape3.equals("RoundRect"))
            {
                roundRect3.paint(g2d);
                roundRect3.disappear();
            }
        
            //make a boolean about IF the shape disappears by going to the bottom OR
            //disappeared by getting hit by a shuriken
            boolean shapeDisappears = square.hitTheBottom() || circle.hitTheBottom() 
                    || roundRect.hitTheBottom() || square.collision() || 
                    circle.collision() || roundRect.collision();
            boolean shape2Disappears = square2.hitTheBottom() || circle2.hitTheBottom() 
                    || roundRect2.hitTheBottom() || square2.collision() || 
                    circle2.collision() || roundRect2.collision();;
            boolean shape3Disappears = square3.hitTheBottom() || circle3.hitTheBottom() 
                    || roundRect3.hitTheBottom() || square3.collision() || 
                    circle3.collision() || roundRect3.collision();
        
            //make other shape appear from the top
            if(shapeDisappears)
            {
                int randNum = _rand.nextInt(_shapes.length);
                shape1 = _shapes[randNum];
                square = new BlueSquare(gameFrame, this);
                circle = new RedCircle(gameFrame, this);
                roundRect = new GreenRoundSquare(gameFrame, this);
            }
            else if(shape2Disappears)
            {
                int randNum = _rand.nextInt(_shapes.length);
                shape2 = _shapes[randNum];
                square2 = new BlueSquare(gameFrame, this);
                circle2 = new RedCircle(gameFrame, this);
                roundRect2 = new GreenRoundSquare(gameFrame, this);
            }
            else if(shape3Disappears)
            {
                int randNum = _rand.nextInt(_shapes.length);
                shape3 = _shapes[randNum];
                square3 = new BlueSquare(gameFrame, this);
                circle3 = new RedCircle(gameFrame, this);
                roundRect3 = new GreenRoundSquare(gameFrame, this);
            }
        }
    }
    
    /**
     * Shows a window of the game's results when the time countdown reaches 0
     */
    private void timesUp()
    {
        //brings up the JOptionPane
        //And shows score
        Object[] options = {"Close"};
        ImageIcon end = new ImageIcon("shuriken.png");
        JOptionPane.showOptionDialog(null, "Time's Up! \nYour Score: " + score, 
                "Ninja Shooting Game", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
                end ,options, options[0]);
        System.exit(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (SECONDS_LEFT-- > 0) 
        {
            _displayTime.setText("Time left: " + String.valueOf(SECONDS_LEFT));
        } 
        else 
        {
            _displayTime.setText("Time's up!");
            _timeRanOut = true;
            _time.stop();
            music.stop();
            //open JOptionPane to exit the program
            timesUp();
        }
        //for changing the scoreboard
        if(hitParticle)
        {
            if(score == 5)
            {
                _scoreDisplay.setText("Score: " + "0" + String.valueOf(score));
            }
            else
            {
                _scoreDisplay.setText("Score: " + String.valueOf(score));
            }
        }
        repaint();
    }
    
    public class Keyboard implements KeyListener
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            _ninja.keyPressed(e);
            repaint();
        }
    
        @Override
        public void keyTyped(KeyEvent e)
        {
        
        }
    
        @Override
        public void keyReleased(KeyEvent e)
        {
        
        }
    }
    
}
