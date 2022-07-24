package Attachables.PassengerCar;

import Attachables.Attachable;
import Attachables.AttachableClass;

public class InterCityPlus extends AttachableClass
{
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
    public int gaugeSize()
    {
        return 1435;
    }

    @Override
    public String toString()
    {
        return "InterCityPlus{}";
    }
}
