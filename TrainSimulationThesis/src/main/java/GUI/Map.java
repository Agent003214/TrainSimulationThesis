package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map extends JPanel implements Runnable
{
    private Thread gameThread;
    private int FPS=10;
    public Map()
    {
        JPanel statPanel =new JPanel();

        JPanel mapPanel=new JPanel();

        JPanel stopsPanel=new JPanel();
    }

    protected void startGameThread()
    {
        gameThread=new Thread(this);
        gameThread.start();
    }

    /*@Override
    public void run()
    {
        double waitTimer=1000/FPS;//0.1 sec
        double nextDrawTime=System.currentTimeMillis()+waitTimer;

        while(gameThread!=null)
        {

            update();

            repaint();

            try
            {
                double remainingTime=nextDrawTime-System.currentTimeMillis();
                if (remainingTime<0)
                {
                    remainingTime=0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime+=waitTimer;
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }*/

    @Override
    public void run()
    {
        double drawInterval=1000/FPS;
        double delta=0;
        long lastTime=System.currentTimeMillis();
        long currentTime;
        long timer=0;
        int drawCount=0;

        while(gameThread!=null)
        {
            currentTime=System.currentTimeMillis();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=(currentTime-lastTime);
            lastTime=currentTime;
            if (delta>=1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer>=1000)
            {
                System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }

        }
    }

    private void loadMap()
    {
        try
        {
            InputStream in=getClass().getResourceAsStream("map.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
        }
        catch (Exception e)
        {

        }
    }

    private void update()
    {

    }

    public void repaint(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D=(Graphics2D) g;
    }
}
