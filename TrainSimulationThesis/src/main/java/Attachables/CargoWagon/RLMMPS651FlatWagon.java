package Attachables.CargoWagon;

import Attachables.Cargo.Cargo;
import Attachables.CargoContainer.CargoContainer;

import java.awt.image.BufferedImage;

/**
 * The flatbed train wagon.
 */
public class RLMMPS651FlatWagon extends Wagon
{
    //https://www.dybas.de/dybas/gw/gw_r_6/g651.html
    private CargoContainer cargoContainer;

    @Override
    public BufferedImage getFrontPixelArt()
    {
        return null;
    }

    @Override
    public BufferedImage getBackPixelArt()
    {
        return null;
    }

    @Override
    public BufferedImage getRightSidePixelArt()
    {
        return null;
    }

    @Override
    public BufferedImage getImageLarge()
    {
        return null;
    }

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

    @Override
    public void loadCargoType(Cargo cargo)
    {

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
    public int getLoad()
    {
        return cargoContainer.getLoad();
    }

    @Override
    public String toString()
    {
        return "RLMMPS651FlatWagon{}";
    }

    @Override
    protected String errorMessage()
    {
        return null;
    }
}
