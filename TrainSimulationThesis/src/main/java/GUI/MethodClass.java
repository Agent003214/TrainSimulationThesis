package GUI;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;
import Attachables.CargoWagon.BoxWagon;
import Attachables.PassengerCar.InterCityPlus;
import Attachables.PassengerCar.Mark3;
import Factories.CompoundTrain;
import TrainEngines.Diesel.SD70M;
import TrainEngines.Electric.V63;
import TrainEngines.Locomotive;

import java.awt.*;
import java.util.ArrayList;

public final class MethodClass
{
    private static ArrayList<CompoundTrain> train = new ArrayList<>();
    private static ArrayList<Station> stations = new ArrayList<>();
    private Font font = new Font("Tahoma", 0, 22);
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    protected ArrayList<CompoundTrain> getTrain()
    {
        return train;
    }

    /**
     * All available locomotives.
     *
     * @return
     */
    public ArrayList<Locomotive> getLocomotivesArrayList()
    {
        ArrayList<Locomotive> locomotiveList = new ArrayList<>();
        locomotiveList.add(new V63());
        locomotiveList.add(new SD70M());
        for (int i = 0; i < locomotiveList.size(); i++)
        {
            locomotiveList.get(i).load();
        }
        return locomotiveList;
    }

    public ArrayList<Attachable> getAttachableArrayList()
    {
        ArrayList<Attachable> attachableList = new ArrayList<>();
        attachableList.add(new InterCityPlus());
        attachableList.add(new Mark3());
        attachableList.add(new BoxWagon());
        for (int i = 0; i < attachableList.size(); i++)
        {
            attachableList.get(i).loadImg();
        }
        return attachableList;
    }

    public CompoundTrain getLatestTrain()
    {
        if (train.size() > 0)
        {
            return train.get(train.size() - 1);
        }
        return train.get(0);
    }

    public void addStation(int[] location, String name, int currentLoad, Cargo cargoType)
    {
        stations.add(new Station(location, name, currentLoad, cargoType));
    }

    public ArrayList<Station> getStations()
    {
        return stations;
    }

    public void setTrainName(String name)
    {
        getLatestTrain().setTrainName(name);
    }

    public String getLatestTrainName()
    {
        return getLatestTrain().getTrainName();
    }

    public void createTrain()
    {
        train.add(new CompoundTrain());
    }

    public void createTrain(CompoundTrain createdTrain)
    {
        train.add(new CompoundTrain());
        train.set(train.size() - 1, createdTrain);
    }

    public Font getFont()
    {
        return font;
    }

    public Dimension getDim()
    {
        return dim;
    }
}
