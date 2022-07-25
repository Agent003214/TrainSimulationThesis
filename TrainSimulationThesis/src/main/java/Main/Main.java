package Main;

import AlternateComponents.NewCars.NewICPlus;
import AlternateComponents.NewLoco.NewV63;
import Attachables.Attachable;
import Factories.CompoundTrain;
import TrainBuilder.Builder;
import TrainBuilder.Director;
import TrainBuilder.PassengerTrain;
import TrainBuilder.PassengerTrainBuilder;
import TrainEngines.Locomotive;

public class Main
{
    public static void main(String[] args)
    {
        CompoundTrain asd=new CompoundTrain();
        asd.add(new NewV63(),new NewICPlus(),new NewICPlus());
        asd.add(new NewICPlus());
        System.out.println(asd.toString());
    }
}