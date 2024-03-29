package GUI;

import Attachables.Cargo.Cargo;
import Attachables.Cargo.Steel;

public class Station
{
    /**
     * The X and Y coordinates of the station
     */
    private final int[] location;
    private final int maxCapacity=150000;
    private int currentLoad;
    private final String name;
    private final Cargo cargoType;
    private MethodClass GUIMethods = new MethodClass();


    public Station(int[] location,String name, int currentLoad, Cargo cargoType)
    {
        this.location = location;
        this.currentLoad = currentLoad;
        this.name=name;
        this.cargoType=cargoType;
    }

    public String getName()
    {
        return name;
    }

    /**
     *
     * @return An array with a size of two,<br> first item X coordinate, second item Y coordinate
     */
    public int[] getLocation()
    {
        return location;
    }

    public Cargo getCargoType()
    {
        return cargoType;
    }

    public int getCurrentLoad()
    {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad)
    {
        this.currentLoad = currentLoad;
    }

    public int getMaxCapacity()
    {
        return maxCapacity;
    }

    public int getFreeSpace()
    {
        return maxCapacity-currentLoad;
    }

    public void update()
    {
        updateIron();
        updateCoal();
        updateSteel();
    }

    public void updateSteel()
    {
        int iron=GUIMethods.getStations().get(5).getCurrentLoad();
        int coal=GUIMethods.getStations().get(7).getCurrentLoad();
        if (iron>coal)
        {
            if (coal>0)
            {
                GUIMethods.getStations().get(7).setCurrentLoad(0);
                GUIMethods.getStations().get(5).setCurrentLoad(iron-coal);
                GUIMethods.getStations().get(8).setCurrentLoad(coal);
            }
        }
        else
        {
            if (iron>0)
            {
                GUIMethods.getStations().get(7).setCurrentLoad(coal-iron);
                GUIMethods.getStations().get(5).setCurrentLoad(0);
                GUIMethods.getStations().get(8).setCurrentLoad(iron);
            }
        }
    }

    private void updateIron()
    {
        if (GUIMethods.getStations().get(1).getCurrentLoad()>=300)
        {
            GUIMethods.getStations().get(4).setCurrentLoad(GUIMethods.getStations().get(4).getCurrentLoad()+100);
        }
    }

    private void updateCoal()
    {
        if (GUIMethods.getStations().get(3).getCurrentLoad()>=300)
        {
            GUIMethods.getStations().get(6).setCurrentLoad(GUIMethods.getStations().get(6).getCurrentLoad()+100);
        }
    }
}
