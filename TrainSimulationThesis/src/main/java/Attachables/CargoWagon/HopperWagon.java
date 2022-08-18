package Attachables.CargoWagon;

import Attachables.Attachable;

public class HopperWagon extends Wagon
{
//https://www.gbrx.com/railcars/4575-carbon-black-covered-hopper/
    private int load;
    @Override
    public String getName()
    {
        return "4575 Covered Hopper wagon";
    }

    @Override
    public int getCapacity()
    {
        return 103000;
    }

    @Override
    public int maxAllowedSpeed()
    {
        return 0;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

    @Override
    public int getLength()
    {
        return 15;
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
