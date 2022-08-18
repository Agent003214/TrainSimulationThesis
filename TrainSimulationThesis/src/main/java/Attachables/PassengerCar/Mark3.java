package Attachables.PassengerCar;

import Attachables.Attachable;

public class Mark3 extends Car
{

    @Override
    public String getName()
    {
        return "British Rail Mark 3";
    }

    @Override
    public int getCapacity()
    {
        return 74;
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
        return 23;
    }

    @Override
    public void load(int num)
    {

    }

    @Override
    public void unload(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return 0;
    }
}
