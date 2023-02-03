package GUI;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;
import Attachables.Cargo.LongContainer;
import Attachables.Cargo.ShortContainer;
import Attachables.Cargo.TankContainer;
import Attachables.CargoWagon.BoxWagon;
import Attachables.CargoWagon.HopperWagon;
import Attachables.CargoWagon.RLMMPS651FlatWagon;
import Attachables.CargoWagon.TankWagon;
import Attachables.PassengerCar.InterCityPlus;
import Attachables.PassengerCar.Mark3;
import Factories.CompoundTrain;
import TrainEngines.Diesel.F40PH;
import TrainEngines.Diesel.SD70M;
import TrainEngines.Electric.V63;
import TrainEngines.Locomotive;

import java.awt.*;
import java.util.ArrayList;

public class MethodClass
{
    private static ArrayList<CompoundTrain> train=new ArrayList<>();
    protected Font font = new Font("Tahoma",0,22);

    protected ArrayList<CompoundTrain> getTrain()
    {
        return train;
    }
    protected ArrayList<Locomotive> getLocomotivesArrayList()
    {
        ArrayList<Locomotive> locomotiveList = new ArrayList<>();
        locomotiveList.add(new V63());
        locomotiveList.add(new F40PH());
        locomotiveList.add(new SD70M());
        return locomotiveList;
    }

    protected ArrayList<Attachable> getAttachableArrayList()
    {
        ArrayList<Attachable> attachableList = new ArrayList<>();
        attachableList.add(new InterCityPlus());
        attachableList.add(new Mark3());
        attachableList.add(new BoxWagon());
        attachableList.add(new HopperWagon());
        attachableList.add(new TankWagon());
        attachableList.add(new RLMMPS651FlatWagon());
        return attachableList;
    }

    protected ArrayList<Cargo> getCargoArrayList()
    {
        ArrayList<Cargo> cargoArrayList=new ArrayList<>();
        cargoArrayList.add(new ShortContainer());
        cargoArrayList.add(new LongContainer());
        cargoArrayList.add(new TankContainer());
        return cargoArrayList;
    }
    protected CompoundTrain getLatestTrain()
    {
        if (train.size()>0)
        {
            return train.get(train.size()-1);
        }
        return train.get(0);
    }
    protected void setTrainName(String name)
    {
        getLatestTrain().setTrainName(name);
    }

    protected String getLatestTrainName()
    {
        return getLatestTrain().getTrainName();
    }

    protected void createTrain()
    {
        train.add(new CompoundTrain());
        printTest();
    }

    protected void createTrain(CompoundTrain createdTrain)
    {
        train.add(new CompoundTrain());
        train.set(train.size()-1,createdTrain);
        printTest();
    }

    protected void printCurrentTrain()
    {
        System.out.println(train.size());
    }

    protected void printTest()
    {
        ViewTrainsPage valami=new ViewTrainsPage();
        //valami.trainList();
        //valami.DLMtest();
    }
}
