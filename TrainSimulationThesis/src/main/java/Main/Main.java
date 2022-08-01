package Main;

import AlternateComponents.NewCars.NewICPlus;
import AlternateComponents.NewLoco.NewV63;
import Factories.CompoundTrain;

public class Main
{
    public static void main(String[] args)
    {
        CompoundTrain asd=new CompoundTrain();
        asd.add(new NewV63(),new NewICPlus(),new NewICPlus());
        asd.add(new NewICPlus());
        System.out.println(asd.getPassengerCapacityCount());
        asd.loadPassengers(120);
        asd.loadPassengers(30);
        System.out.println(asd.getPassengerCount());
        System.out.println(asd.toString());
    }
}