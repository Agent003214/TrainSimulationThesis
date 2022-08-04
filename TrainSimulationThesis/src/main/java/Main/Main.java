package Main;

import Attachables.FlatBedBuilders.FlatBedDirector;
import Attachables.PassengerCar.InterCityPlus;
import Factories.CompoundTrain;
import TrainEngines.Diesel.F40PH;
import TrainEngines.Electric.V63;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<CompoundTrain> train=new ArrayList<>();
        train.add(new CompoundTrain());
        train.get(0).add(new V63(),new InterCityPlus(),new InterCityPlus());
        System.out.println(train.get(0).getPassengerCapacityCount());
        System.out.println(train.get(0).toString());
        train.get(0).altLoad(1,15);
        System.out.println(train.get(0).getLoad(1));
        System.out.println(train.get(0).getLoad(2));

    }
}