package shootinggame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Elena Ngo
 * This class creates a small window that represents the game's instructions
 */
public class InstructionFrame extends JFrame {

    private final int FRAME_HEIGHT = 350;
    private final int FRAME_WIDTH = 600;
    
    private final String _INSTRUCTIONS1 = "Move the ninja around with left and right arrow keys. \n";
    private final String _INSTRUCTIONS2 = "Tap the 'S' key to throw shurikens. \n";
    private final String _INSTRUCTIONS3 = "Shoot at the falling shapes to earn points. \n";
    private final String _INSTRUCTIONS4 = "Slow Blue Square = 5 points \n";
    private final String _INSTRUCTIONS5 = "Green Round Square = 10 points \n";
    private final String _INSTRUCTIONS6 = "Fast Red Circle = 20 points \n";
    private final String _INSTRUCTIONS7 = "You have 30 seconds to get the highest score.";
    
    private JPanel _panel;
    private JButton _start;
    private JLabel _title;
    private JLabel _picture;
    private ImageIcon _sprite;
    
    private Insets _insets;
    private Dimension _size;
    
    private ButtonListener _listener;
    
    public InstructionFrame()
    {
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        instructionComponents();
    }
    
    /**
     * Adds the frame's components
     */
    private void instructionComponents()
    {
        _panel = new JPanel();
        _panel.setLayout(null);
        _insets = _panel.getInsets();
        
        _listener = new ButtonListener();
        
        //Add Title 
        _title = new JLabel("HOW TO PLAY");
        _title.setFont(new Font("Arial", Font.BOLD, 20));
        _panel.add(_title);
        _size = _title.getPreferredSize();
        _title.setBounds(220 + _insets.left, 10 + _insets.top, _size.width,
                _size.height);
        
        //Add Instructions
        JLabel instructions  = new JLabel(_INSTRUCTIONS1);
        JLabel instructions2 = new JLabel(_INSTRUCTIONS2);
        JLabel instructions3 = new JLabel(_INSTRUCTIONS3);
        JLabel instructions4 = new JLabel(_INSTRUCTIONS4);
        JLabel instructions5  = new JLabel(_INSTRUCTIONS5);
        JLabel instructions6 = new JLabel(_INSTRUCTIONS6);
        JLabel instructions7 = new JLabel(_INSTRUCTIONS7);
        
        _panel.add(instructions);
        _panel.add(instructions2);
        _panel.add(instructions3);
        _panel.add(instructions4);
        _panel.add(instructions5);
        _panel.add(instructions6);
        _panel.add(instructions7);
        
        _size = instructions.getPreferredSize();
        instructions.setBounds(150 + _insets.left, 60 + _insets.top, _size.width,
                _size.height);
        _size = instructions2.getPreferredSize();
        instructions2.setBounds(150 + _insets.left, 80 + _insets.top, _size.width,
                _size.height);
        _size = instructions3.getPreferredSize();
        instructions3.setBounds(150 + _insets.left, 100 + _insets.top, _size.width,
                _size.height);
        _size = instructions4.getPreferredSize();
        instructions4.setBounds(150 + _insets.left, 140 + _insets.top, _size.width,
                _size.height);
        _size = instructions5.getPreferredSize();
        instructions5.setBounds(150 + _insets.left, 160 + _insets.top, _size.width,
                _size.height);
        _size = instructions6.getPreferredSize();
        instructions6.setBounds(150 + _insets.left, 180 + _insets.top, _size.width,
                _size.height);
        _size = instructions7.getPreferredSize();
        instructions7.setBounds(150 + _insets.left, 220 + _insets.top, _size.width,
                _size.height);
        
        //Add Start Button
        _start = new JButton("BEGIN");
        _start.addActionListener(_listener);
        _panel.add(_start);
        _size = _start.getPreferredSize();
        _start.setBounds(250 + _insets.left, 270 + _insets.top, _size.width,
                _size.height);
        //Add sprite picture
        _sprite = new ImageIcon(new ImageIcon("Hikaru.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        _picture = new JLabel(_sprite);
        _panel.add(_picture);
        _size = _picture.getPreferredSize();
        _picture.setBounds(20 + _insets.left, 60 + _insets.top, _size.width,
                _size.height);
        //resize it   
        add(_panel);
        
    }
    
    public class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            if(event.getSource() == _start)
            {
                //instantiates Game Frame
                //closes this frame
                dispose();
                JPanel gamePanel = new PlayFrame();
            }
        }
    }
}
