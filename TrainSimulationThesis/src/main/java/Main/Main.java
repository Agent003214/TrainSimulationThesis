package Main;

import TrainEngines.Diesel.F40PH;
import TrainFactories.Train;
import TrainFactories.TrainClass;
import TrainFactories.TrainFactory;
import TrainFactories.TrainBuilder;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        /*System.out.println("Hello world!");
        TrainFactory valami=TrainBuilder.getFactory(true);

        TrainFactories.Train valamiMas=valami.getTrain();
        System.out.println(valamiMas.toString());*/

        ArrayList<Train> vonat=new ArrayList<>();

        TrainBuilder epit=new TrainBuilder();
        TrainClass utas=epit.createPassengerTrain();
        utas.draw();

/*
        TrainBuilder epit2=new TrainBuilder();
        TrainClass cargo=epit2.createCargoTrain();
        cargo.draw();*/
        

    }
}