package Attachables.CargoWagon;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;
import Attachables.Cargo.IntermodelContainer;
import Attachables.Cargo.TankContainer;

/**
 * The flatbed train wagon.
 */
public class RLMMPS651FlatWagon extends Wagon
{
    //https://www.dybas.de/dybas/gw/gw_r_6/g651.html
    private Cargo cargo;

    @Override
    public String getName()
    {
        try
        {
            return "Flat Wagon with "+getCargo().getName();
        }
        catch (NullPointerException e)
        {
            return "Flat Wagon";
        }

    }

    public RLMMPS651FlatWagon()
    {
    }

    public RLMMPS651FlatWagon(Cargo cargo)
    {
        this.cargo = cargo;
    }

    @Override
    public int getCapacity()
    {
        return cargo.getCapacity();
    }

    @Override
    public int maxAllowedSpeed()
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

    public void loadCargo(Cargo cargo)
    {
        this.cargo=cargo;
    }

    public Cargo getCargo()
    {
        return cargo;
    }

    @Override
    public void load(int num)
    {
        cargo.load(num);
    }

    public void unload(int num)
    {
        cargo.unload(num);
    }

    @Override
    public int getLoad()
    {
        return cargo.getLoad();
    }

    @Override
    public String toString()
    {
        return "RLMMPS651FlatWagon{}";
    }
}
