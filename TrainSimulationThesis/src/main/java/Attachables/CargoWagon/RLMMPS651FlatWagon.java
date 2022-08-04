package Attachables.CargoWagon;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;

/**
 * The flatbed train wagon.
 */
public class RLMMPS651FlatWagon extends Attachable
{
    //https://www.dybas.de/dybas/gw/gw_r_6/g651.html
    private Cargo cargo;
    @Override
    public int getCapacity()
    {
        return 0;
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
