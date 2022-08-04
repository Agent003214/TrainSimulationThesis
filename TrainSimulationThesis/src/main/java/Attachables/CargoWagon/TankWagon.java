package Attachables.CargoWagon;

import Attachables.Attachable;

public class TankWagon extends Attachable
{
    private int load;
    /**
     * Returns the capacity in liters
     * @return
     */
    @Override
    public int getCapacity()
    {
        return 88000;
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
        return 15;
    }

    @Override
    public void load(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return load;
    }
}
