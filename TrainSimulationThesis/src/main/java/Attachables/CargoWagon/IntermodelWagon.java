package Attachables.CargoWagon;

import Attachables.Attachable;

public class IntermodelWagon extends Attachable
{
    @Override
    public int getCapacity()
    {
        return 2;
    }

    @Override
    public int maxAllowedSpeed()
    {
        return 0;
    }

    @Override
    public int getGaugeSize()
    {
        return 0;
    }

    @Override
    public int getLength()
    {
        return 0;
    }

    @Override
    public void load(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return 0;
    }
}
