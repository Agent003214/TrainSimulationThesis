package GUI;

import Attachables.Cargo.Cargo;

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

    private void steelMill()
    {

    }
}
