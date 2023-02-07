package Attachables.CargoWagon;

import Attachables.CargoContainer.CargoContainer;

/**
 * The flatbed train wagon.
 */
public class RLMMPS651FlatWagon extends Wagon
{
    //https://www.dybas.de/dybas/gw/gw_r_6/g651.html
    private CargoContainer cargoContainer;

    @Override
    public String getName()
    {
        try
        {
            return "RLMMPS651 with "+getCargo().getName();
        }
        catch (NullPointerException e)
        {
            return "RLMMPS651";
        }

    }

    @Override
    public String getType()
    {
        return "Flat wagon";
    }

    public RLMMPS651FlatWagon()
    {
    }

    public RLMMPS651FlatWagon(CargoContainer cargoContainer)
    {
        this.cargoContainer = cargoContainer;
    }

    @Override
    public int getCapacity()
    {
        try
        {
            return cargoContainer.getCapacity();
        }
        catch (NullPointerException e)
        {
            return 0;
        }

    }

    @Override
    public int getMaxSpeed()
    {
        return 120;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

    @Override
    public int getLength()
    {
        return 11;
    }

    public void loadCargo(CargoContainer cargoContainer)
    {
        this.cargoContainer = cargoContainer;
    }

    public CargoContainer getCargo()
    {
        return cargoContainer;
    }

    @Override
    public void load(int num)
    {
        cargoContainer.load(num);
    }

    public void unload(int num)
    {
        cargoContainer.unload(num);
    }

    @Override
    public int getLoad()
    {
        return cargoContainer.getLoad();
    }

    @Override
    public String toString()
    {
        return "RLMMPS651FlatWagon{}";
    }
}
