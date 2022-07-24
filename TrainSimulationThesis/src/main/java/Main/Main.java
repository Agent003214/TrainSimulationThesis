package Main;

import Attachables.Attachable;
import TrainBuilder.Builder;
import TrainBuilder.Director;
import TrainBuilder.PassengerTrain;
import TrainBuilder.PassengerTrainBuilder;
import TrainEngines.Locomotive;

public class Main
{
    public static void main(String[] args)
    {
        Director director=new Director();

        PassengerTrainBuilder builder=new PassengerTrainBuilder();
        director.createPassengerTrain(builder);

        PassengerTrain train1=builder.getResult();

        System.out.println(train1.getEngine());
    }
}