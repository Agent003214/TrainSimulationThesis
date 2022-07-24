package Trains;

import TrainFactories.Train;

public class PassengerTrain implements Train
{

    @Override
    public int gaugeSize()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "PassengerTrain{}";
    }
}
