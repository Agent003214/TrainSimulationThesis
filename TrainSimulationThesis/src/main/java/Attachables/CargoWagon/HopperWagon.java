package Attachables.CargoWagon;

import Attachables.Attachable;

public class HopperWagon extends Wagon
{
    //https://www.greenbrier-europe.com/products/product/tagnpps-130-m3/
    private int load;
    @Override
    public String getName()
    {
        return "Tagnpps 130m³";
    }

    @Override
    public String getType()
    {
        return "Grain hopper wagon";
    }

    @Override
    public int getCapacity()
    {
        return 68000;
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
        return 20;
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
