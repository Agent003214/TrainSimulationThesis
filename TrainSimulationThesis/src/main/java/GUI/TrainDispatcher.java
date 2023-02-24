package GUI;

import Drawables.TrainDrawable;
import Factories.CompoundTrain;
import Routes.Routes;

import java.awt.*;
import java.util.ArrayList;

public class TrainDispatcher
{
    private ArrayList<TrainDrawable> trainsOnTrack=new ArrayList();
    private ArrayList<CompoundTrain> startedTrains=new ArrayList<>();
    int[] start;
    private MethodClass GUIMethods=new MethodClass();
    private int helper=0;

    public void sendTrain(MapPanel mp,Routes route,CompoundTrain train)
    {
        startedTrains.add(train);

        double drawInterval = 1000 / 30;
        double delta = 0;
        long lastTime = System.currentTimeMillis();
        long currentTime;
        long timer = 0;
        int i=0;

        int drawCount = 0;
        trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(i),train.getBackImage(i),train.getFrontImage(i),1,0));
        i++;
        while(i<train.getTrainLenght())
        {
            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1)
            {
                //System.out.println("this");
                delta--;
            }
            if (timer >= 1000)
            {
                //System.out.println("FPS: "+drawCount);
                //System.out.println("that");
                trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(i),train.getBackImage(i),train.getFrontImage(i),1,0));
                i++;
                timer = 0;
            }
        }


        /*int helper=0;
        startedTrains.add(train);

        System.out.println(train.toString());
        //for (int i = 0; i < train.getTrainLenght(); i++)
        while(helper<=train.getTrainLenght())
        {
            if (trainsOnTrack.size()==0)
            {
                trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(helper),train.getBackImage(helper),train.getFrontImage(helper),1,0));
            }
            for (int j = 0; j < trainsOnTrack.size(); j++)
            {
                if( !trainsOnTrack.get(helper).isOccupied(route.getStart()))
                {
                    trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(helper),train.getBackImage(helper),train.getFrontImage(helper),1,0));
                }
            }
            helper++;
        }
        helper=0;*/
        //trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(0),train.getBackImage(0),train.getFrontImage(0),1,0));
    }

    /*public void sendTrain(MapPanel mp,Routes route,CompoundTrain train)
    {
        startedTrains.add(train);
        for (int i = 0; i < train.getTrainLenght(); i++)
        {
            trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(i),train.getBackImage(i),train.getFrontImage(i),1,0));
        }
    }*/

    public void update()
    {
        for (int i = 0; i < trainsOnTrack.size(); i++)
        {
            try
            {
                trainsOnTrack.get(i).update();
            }
            catch (RuntimeException e)
            {
                trainsOnTrack.remove(i);
            }
        }
    }

    public void draw(Graphics2D g2D)
    {
        for (int i = 0; i < trainsOnTrack.size(); i++)
        {
            trainsOnTrack.get(i).draw(g2D);
        }
        //trainsOnTrack.get(0).draw(g2D);
        //trainsOnTrack.add(new TrainDrawable())
    }
}
