package Attachables.PassengerCar;

import Attachables.Attachable;

public class InterCityPlus implements Attachable
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
    public int getgaugeSize()
    {
        return 1435;
    }

    @Override
    public String toString()
    {
        return "InterCityPlus{}";
    }
}
