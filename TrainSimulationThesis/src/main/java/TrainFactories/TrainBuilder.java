package TrainFactories;

import Attachables.PassengerCar.InterCityPlus;
import Attachables.PassengerCar.Mark3;
import TrainEngines.Diesel.SD70M;
import TrainEngines.Electric.V63;

public class TrainBuilder
{
    public TrainClass createPassengerTrain()
    {
        TrainClass train=new TrainClass();
        train.attach(new V63());
        train.attach(new InterCityPlus());
        train.attach(new Mark3());
        return train;
    }

    public TrainClass createCargoTrain()
    {
        TrainClass train=new TrainClass();
        train.attach(new SD70M());
        return train;
    }

    public static TrainFactory getFactory(boolean passengerTrain)
    {
        if (passengerTrain)
        {
            return new PassengerTrainFactory();
        }
        else
        {
            return new CargoTrainFactory();
        }
    }
}
