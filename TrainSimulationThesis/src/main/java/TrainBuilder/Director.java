package TrainBuilder;

import Attachables.PassengerCar.InterCityPlus;
import TrainEngines.Electric.V63;

public class Director
{
    public void createPassengerTrain(Builder builder)
    {
        builder.setLoco(new V63());
        builder.setCar(new InterCityPlus());
    }
}
