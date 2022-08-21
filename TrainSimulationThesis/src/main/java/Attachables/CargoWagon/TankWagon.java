package Attachables.CargoWagon;

import Attachables.Attachable;

public class TankWagon extends Wagon
{
    private int load=0;
    @Override
    public String getName()
    {
        return "Zags 53m³";
    }

    @Override
    public String getType()
    {
        return "Fluid tank wagon";
    }

    @Override
    public int getCapacity()
    {
        return 66000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 100;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

    @Override
    public int getLength()
    {
        return 13;
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
        return load;
    }
}
