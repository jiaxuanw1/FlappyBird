package flappybird;

/**
 * Class ArcadeRunner
 * Runs and animates subclasses of MotionPanel
 * 
 * @author Travis Rother 
 * @version 2-25-2008
 */
import java.awt.event.*;
import javax.swing.JFrame;

import arcade.AnimationPanel;

public class FlappyBirdRunner 
{

    int FPS = 60;   //Frames per second (animation speed)
    AnimationPanel world = new FlappyBirdGame();
    
    
    
    //==============================================================================
    //--- Typically you will never need to edit any of the code below this line. ---
    //==============================================================================
    
    JFrame myFrame;

    public FlappyBirdRunner() 
    {
        myFrame = new JFrame();
        myFrame.addWindowListener(new Closer());
        addFrameComponents();
        startAnimation();
        myFrame.setSize(world.getPreferredSize());
        myFrame.setVisible(true);
    }

    public void addFrameComponents() 
    {
        myFrame.setTitle(world.getMyName() + " - " + world.getPreferredSize().width+"x"+world.getPreferredSize().height);
        myFrame.add(world);
    }
    
    public void startAnimation() 
    {
        javax.swing.Timer t = new javax.swing.Timer(1000/FPS, new ActionListener() 
        {   //This is something you may not have seen before...
            //We are coding a method within the ActionListener object during it's construction!
            public void actionPerformed(ActionEvent e) 
            {
                myFrame.getComponent(0).repaint();
                myFrame.setSize(myFrame.getComponent(0).getPreferredSize());
            }
        }); //--end of construction of Timer--
        t.start();
    }
    
    public static void main(String[] args) 
    {
        FlappyBirdRunner runner = new FlappyBirdRunner();
    }    
    
    private static class Closer extends java.awt.event.WindowAdapter 
    {   
        public void windowClosing (java.awt.event.WindowEvent e) 
        {   System.exit (0);
        }   //======================
    }      
    
    
}
