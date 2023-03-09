package GUI;

import Attachables.Attachable;
import Drawables.TrainDrawable;
import Factories.CompoundTrain;
import Factories.Train;
import Routes.Routes;

import java.awt.*;
import java.util.ArrayList;

public class TrainDispatcher
{
    private ArrayList<TrainDrawable> trainsOnTrack = new ArrayList();
    private ArrayList<CompoundTrain> startedTrains = new ArrayList<>();
    private MethodClass GUIMethods = new MethodClass();
    private int helper = 0;

    public void sendTrain(MapPanel mp, Routes route, CompoundTrain train)
    {
        //startedTrains.add(train);

        double drawInterval = 1000 / 30;
        double delta = 0;
        long lastTime = System.currentTimeMillis();
        long currentTime;
        long timer = 0;
        int i = 0;

        int drawCount = 0;
        //trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(i),train.getBackImage(i),train.getFrontImage(i),1,0));
        trainsOnTrack.add(new TrainDrawable(mp, route, train.getCar(i)));
        i++;
        while (i < train.getTrainLenght())
        {
            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1)
            {
                delta--;
            }
            if (timer >= 1000)
            {
                //System.out.println("FPS: "+drawCount);
                //trainsOnTrack.add(new TrainDrawable(mp,route,train.getRightImage(i),train.getBackImage(i),train.getFrontImage(i),1,0));
                if (train.getCar(i) instanceof Attachable)
                {


                        //((Car) train.getCar(i)).clone();
                        trainsOnTrack.add(new TrainDrawable(mp, route, (Train) ((Attachable) train.getCar(i)).clone()));

                }
                else
                {
                    trainsOnTrack.add(new TrainDrawable(mp, route, train.getCar(i)));
                }

                //trainsOnTrack.add(new TrainDrawable(mp, route, new InterCityPlus()));
                i++;
                timer = 0;
            }
        }
    }

    public void update()
    {

        for (int i = 0; i < trainsOnTrack.size(); i++)
        {
            int result = trainsOnTrack.get(i).update();
            switch (result)
            {
                case 0 ->
                {

                }
                case -1 ->
                {
                    for (int j = 0; j < GUIMethods.getStations().size(); j++)
                    {
                        if (GUIMethods.getStations().get(j).getLocation() == trainsOnTrack.get(i).getStartStation())
                        {
                            System.out.println(trainsOnTrack.get(i).getTrainPiece().toString());
                            int newStationLoad = trainsOnTrack.get(i).load(GUIMethods.getStations().get(j).getCargoType(), GUIMethods.getStations().get(j).getCurrentLoad());
                            if (newStationLoad != -1)
                            {
                                GUIMethods.getStations().get(j).setCurrentLoad(newStationLoad);
                            }
                        }
                    }
                }
                case -2 ->
                {
                    for (int j = 0; j < GUIMethods.getStations().size(); j++)
                    {
                        if (GUIMethods.getStations().get(j).getLocation()==trainsOnTrack.get(i).getStopLocation())
                        {
                            int newStationFreeSpace=trainsOnTrack.get(i).unload(GUIMethods.getStations().get(j).getFreeSpace());
                            if (newStationFreeSpace!=-1)
                            {
                                GUIMethods.getStations().get(j).setCurrentLoad(GUIMethods.getStations().get(j).getMaxCapacity()-newStationFreeSpace);
                            }
                        }
                    }
                    trainsOnTrack.remove(i);
                }
            }
        }
    }

    public void draw(Graphics2D g2D)
    {
        for (int i = 0; i < trainsOnTrack.size(); i++)
        {
            trainsOnTrack.get(i).draw(g2D);
        }
    }
}
