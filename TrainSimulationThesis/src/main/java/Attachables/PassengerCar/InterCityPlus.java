package Attachables.PassengerCar;

import Attachables.Attachable;

public class InterCityPlus extends Car
{
    private int load=0;


    @Override
    public int getCapacity()
    {
        return 80;
    }

    @Override
    public int maxAllowedSpeed()
    {
        return 200;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

    @Override
    public int getLength()
    {
        return 26;
    }

    @Override
    public void load(int num)
    {
        if (num+load<getCapacity())
        {
            load=load+num;
        }
    }

    @Override
    public void unload(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return load;
    }

    @Override
    public String toString()
    {
        return "InterCityPlus{}";
    }
}
