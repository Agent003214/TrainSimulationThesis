package GUI;

import Drawables.TrainDrawable;
import Tiles.TileManager;
import Routes.Routes;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MapPanel extends JPanel implements Runnable
{
    private Thread gameThread;
    private int FPS = 30; //refresh rate
    private final int originalTileSize = 11; //11x11 pixel
    private final int scale = 3;
    private final int scaledTileSize = originalTileSize * scale; //33x33 pixel
    private TileManager tileManager = new TileManager(this);
    private final int mapTileColumn = 10;
    private final int mapTileRow = 10;
    private MethodClass GUIMethods=new MethodClass();
    private int glowPlatform=0;
    private TrainDispatcher dispatcher=new TrainDispatcher();


    public MapPanel()
    {
        startGameThread();
        setBackground(Color.red);
        setDoubleBuffered(true);


    }

    protected void send(Routes route,int i,Thread thread)
    {
        //try
        //{
        //MapPanel mp=this;
        thread=new Thread(() ->
        {
            if (GUIMethods.getTrain().get(i).checkElectrified()==route.isElectrified())
            {
                dispatcher.sendTrain(this,route,GUIMethods.getTrain().get(i));
            } else if (!GUIMethods.getTrain().get(i).checkElectrified())
            {
                dispatcher.sendTrain(this,route,GUIMethods.getTrain().get(i));
            }
        });
        thread.start();


        /*}
        catch (IndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(this,"Please select train","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }*/
    }

    protected void startGameThread()
    {
        gameThread = new Thread(this);
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

    /**
     * Game loop
     */
    @Override
    public void run()
    {
        double drawInterval = 1000 / FPS;
        double delta = 0;
        long lastTime = System.currentTimeMillis();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null)
        {
            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000)
            {
                //System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }



    /*private void loadMap()
    {
        try
        {
            InputStream in=getClass().getResourceAsStream("./src/main/java/GUI/map.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(in));

            int col=0;
            int row=0;
            while((col< mapTileColumn)&&(row< mapTileRow))
            {
                String line= br.readLine();
                while (col<mapTileColumn)
                {
                    String[] tileNum=line.split(" ");
                    int num=Integer.parseInt(tileNum[col]);
                    mapTiles[col][row]=num;
                    col++;
                }
                if (col==mapTileColumn)
                {
                    col=0;
                    row++;
                }
                br.close();
            }
            for (int i = 0; i < mapTiles.length; i++)
            {
                for (int j = 0; j < mapTiles[0].length; j++)
                {
                    System.out.println(mapTiles[i][j]);
                }
            }
        }
        catch (Exception e)
        {

        }
    }*/

    private void update()
    {
        dispatcher.update();
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        tileManager.draw(g2D);
        dispatcher.draw(g2D);

        g2D.setColor(Color.WHITE);
        g2D.fillRect(1*scaledTileSize,6*scaledTileSize,30,10);
        g2D.setColor(Color.BLACK);
        g2D.setFont(GUIMethods.getFont());
        g2D.drawString(GUIMethods.getStations().get(0).getName(),1*scaledTileSize,6*scaledTileSize+9);
        g2D.drawString(GUIMethods.getStations().get(0).getCurrentLoad()+"",scaledTileSize,7*scaledTileSize);

        g2D.setColor(Color.WHITE);
        g2D.fillRect(5*scaledTileSize,6*scaledTileSize,30,10);
        g2D.setColor(Color.BLACK);
        g2D.drawString(GUIMethods.getStations().get(1).getName(),5*scaledTileSize,6*scaledTileSize+9);
        g2D.drawString(GUIMethods.getStations().get(1).getCurrentLoad()+"",5*scaledTileSize,7*scaledTileSize);

        g2D.setColor(Color.WHITE);
        g2D.fillRect(5*scaledTileSize,4*scaledTileSize,30,10);
        g2D.setColor(Color.BLACK);
        g2D.drawString(GUIMethods.getStations().get(2).getName(),5*scaledTileSize,4*scaledTileSize+9);
        g2D.drawString(GUIMethods.getStations().get(2).getCurrentLoad()+"",5*scaledTileSize,5*scaledTileSize);

        float thickness=2;
        Stroke oldStroke=g2D.getStroke();
        g2D.setStroke(new BasicStroke(thickness));

        switch (glowPlatform)
        {
            case 0 ->
            {
                g2D.drawRect(GUIMethods.getStations().get(0).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(0).getLocation()[1]*scaledTileSize,scaledTileSize,scaledTileSize);
                g2D.drawRect(GUIMethods.getStations().get(1).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(1).getLocation()[1]*scaledTileSize,scaledTileSize,scaledTileSize);
                /*g2D.drawRect(1*scaledTileSize,5*scaledTileSize,scaledTileSize,scaledTileSize);
                g2D.drawRect(5*scaledTileSize,5*scaledTileSize,scaledTileSize,scaledTileSize);*/
            }
            case 1 ->
            {
                g2D.drawRect(GUIMethods.getStations().get(0).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(0).getLocation()[1]*scaledTileSize,scaledTileSize,scaledTileSize);
                g2D.drawRect(GUIMethods.getStations().get(2).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(2).getLocation()[1]*scaledTileSize,scaledTileSize,scaledTileSize);
                /*g2D.drawRect(1*scaledTileSize,5*scaledTileSize,scaledTileSize,scaledTileSize);
                g2D.drawRect(5*scaledTileSize,3*scaledTileSize,scaledTileSize,scaledTileSize);*/
            }
        }

        g2D.dispose();
    }

    public void setGlowPlatform(int glowPlatform)
    {
        this.glowPlatform = glowPlatform;
    }

    public int getMapTileColumn()
    {
        return mapTileColumn;
    }

    public int getMapTileRow()
    {
        return mapTileRow;
    }

    public int getScaledTileSize()
    {
        return scaledTileSize;
    }
}
