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
    private TileManager tileManager = new TileManager(this,true);
    private TileManager overlay=new TileManager(this,false);
    private final int mapTileColumn = 40;
    private final int mapTileRow = 31;
    private MethodClass GUIMethods=new MethodClass();
    private int glowPlatform=-1;
    private TrainDispatcher dispatcher=new TrainDispatcher();


    public MapPanel()
    {
        startGameThread();
        setBackground(Color.red);
        setDoubleBuffered(true);

        setPreferredSize(new Dimension(mapTileColumn*scaledTileSize,mapTileRow*scaledTileSize));
    }

    protected void send(Routes route,int i,Thread thread)
    {
        //try
        //{
        //MapPanel mp=this;
        thread=new Thread(() ->
        {
            try
            {
                if (GUIMethods.getTrain().get(i).checkElectrified() == route.isElectrified())
                {
                    dispatcher.sendTrain(this, route, GUIMethods.getTrain().get(i));
                } else if (!GUIMethods.getTrain().get(i).checkElectrified())
                {
                    dispatcher.sendTrain(this, route, GUIMethods.getTrain().get(i));
                }
                else if (GUIMethods.getTrain().get(i).checkElectrified() == !route.isElectrified())
                {
                    JOptionPane.showMessageDialog(this,"Electrified train on a non electrified railway track!");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                JOptionPane.showMessageDialog(this,"Please select train");
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
                updateStation();
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

    private void updateStation()
    {
        try
        {
            GUIMethods.getStations().get(8).update();
        }
        catch (IndexOutOfBoundsException e)
        {

        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        tileManager.draw(g2D);
        dispatcher.draw(g2D);
        try
        {
            overlay.draw(g2D);
        }
        catch (NullPointerException e)
        {

        }
        g2D.setFont(GUIMethods.getFont());
        for (int i = 0; i < GUIMethods.getStations().size(); i++)
        {
            //g2D.setColor(Color.WHITE);
            //g2D.fillRect(GUIMethods.getStations().get(i).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(i).getLocation()[1]*scaledTileSize+(scaledTileSize*1),30,30);
            g2D.setColor(Color.BLACK);
            g2D.drawString(GUIMethods.getStations().get(i).getName(),GUIMethods.getStations().get(i).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(i).getLocation()[1]*scaledTileSize+(scaledTileSize*1)+15);
            g2D.drawString(GUIMethods.getStations().get(i).getCurrentLoad()+"",GUIMethods.getStations().get(i).getLocation()[0]*scaledTileSize,GUIMethods.getStations().get(i).getLocation()[1]*scaledTileSize+(scaledTileSize*2)+3);
        }

        g2D.setColor(Color.RED);
        g2D.fillRect(31*scaledTileSize,2*scaledTileSize,scaledTileSize,scaledTileSize);
        g2D.setColor(Color.WHITE);
        g2D.fillRect(32*scaledTileSize,2*scaledTileSize,scaledTileSize+20,20);
        g2D.setColor(Color.BLACK);
        g2D.drawString("Start",32*scaledTileSize,3*scaledTileSize-15);

        g2D.setColor(Color.ORANGE);
        g2D.fillRect(31*scaledTileSize,4*scaledTileSize,scaledTileSize,scaledTileSize);
        g2D.setColor(Color.WHITE);
        g2D.fillRect(32*scaledTileSize,4*scaledTileSize,scaledTileSize+20,20);
        g2D.setColor(Color.BLACK);
        g2D.drawString("Stop",32*scaledTileSize,5*scaledTileSize-15);

        g2D.drawString("Exported steel:",16*scaledTileSize,28*scaledTileSize);
        g2D.drawString(GUIMethods.getStations().get(9).getCurrentLoad()+"",16*scaledTileSize,29*scaledTileSize);

        float thickness=2;
        //Stroke oldStroke=g2D.getStroke();
        g2D.setStroke(new BasicStroke(thickness));

        switch (glowPlatform)
        {
            case 0 ->
            {
                drawGlowStations(GUIMethods.getStations().get(0),GUIMethods.getStations().get(1),g2D);
            }
            case 1 ->
            {
                drawGlowStations(GUIMethods.getStations().get(1),GUIMethods.getStations().get(0),g2D);
            }
            case 2 ->
            {
                drawGlowStations(GUIMethods.getStations().get(0),GUIMethods.getStations().get(2),g2D);
            }
            case 3 ->
            {
                drawGlowStations(GUIMethods.getStations().get(2),GUIMethods.getStations().get(0),g2D);
            }
            case 4 ->
            {
                drawGlowStations(GUIMethods.getStations().get(0),GUIMethods.getStations().get(3),g2D);
            }
            case 5 ->
            {
                drawGlowStations(GUIMethods.getStations().get(3),GUIMethods.getStations().get(0),g2D);
            }
            case 6,8 ->
            {
                drawGlowStations(GUIMethods.getStations().get(1),GUIMethods.getStations().get(2),g2D);
            }
            case 7,9 ->
            {
                drawGlowStations(GUIMethods.getStations().get(2),GUIMethods.getStations().get(1),g2D);
            }
            case 10,12 ->
            {
                drawGlowStations(GUIMethods.getStations().get(1),GUIMethods.getStations().get(3),g2D);
            }
            case 11,13 ->
            {
                drawGlowStations(GUIMethods.getStations().get(3),GUIMethods.getStations().get(1),g2D);
            }
            case 14 ->
            {
                drawGlowStations(GUIMethods.getStations().get(2),GUIMethods.getStations().get(3),g2D);
            }
            case 15 ->
            {
                drawGlowStations(GUIMethods.getStations().get(3),GUIMethods.getStations().get(2),g2D);
            }
            case 16 ->
            {
                drawGlowStations(GUIMethods.getStations().get(4),GUIMethods.getStations().get(5),g2D);
            }
            case 17 ->
            {
                drawGlowStations(GUIMethods.getStations().get(6),GUIMethods.getStations().get(7),g2D);
            }
            case 18 ->
            {
                drawGlowStations(GUIMethods.getStations().get(8),GUIMethods.getStations().get(9),g2D);
            }

        }

        g2D.dispose();
    }

    private void drawGlowStations(Station start, Station end, Graphics2D g2D)
    {
        g2D.setColor(Color.RED);
        g2D.drawRect(start.getLocation()[0]*scaledTileSize,start.getLocation()[1]*scaledTileSize,scaledTileSize,scaledTileSize);
        g2D.setColor(Color.ORANGE);
        g2D.drawRect(end.getLocation()[0]*scaledTileSize,end.getLocation()[1]*scaledTileSize,scaledTileSize,scaledTileSize);
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
