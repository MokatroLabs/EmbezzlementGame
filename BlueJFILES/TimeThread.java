import java.io.File;
import java.awt.event.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import sun.audio.*;
import java.io.*;
import java.util.ArrayList;
public class TimeThread extends Thread
{
    ActionListener taskPerformer = new ActionListener()
        {
            public synchronized void actionPerformed(ActionEvent evt) {
                System.out.println("2 steps of the work");
                timerDelay.stop();
                notifyAll();
            }
        };
    Timer timerDelay = new Timer(2000, taskPerformer);    
    public TimeThread()
    {
        
    }
    public synchronized void run()
    {
        System.out.println("comp turn");
        System.out.println("1 step of the work");
        //timerDelay.start();
        try {
           Main.class.wait();
           sleep(4000);
        } catch (InterruptedException e){}
        Main.class.notify();
    }
}