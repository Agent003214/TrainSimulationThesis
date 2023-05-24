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
     *
     * @return All available locomotives.
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

    /**
     *
     * @return All available attachables.
     */
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

    /**
     * Creates and stores a new station.
     * @param location The X,Y coordinates
     * @param name The name of the new station for display
     * @param currentLoad The initial load value
     * @param cargoType The cargo type the station will load and unload
     */
    public void addStation(int[] location, String name, int currentLoad, Cargo cargoType)
    {
        stations.add(new Station(location, name, currentLoad, cargoType));
    }

    public ArrayList<Station> getStations()
    {
        return stations;
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

    /**
     * Screen data for the used monitor
     * @return
     */
    public Dimension getDim()
    {
        return dim;
    }
}
