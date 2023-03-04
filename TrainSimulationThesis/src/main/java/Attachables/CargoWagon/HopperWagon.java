package Attachables.CargoWagon;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;

import java.awt.image.BufferedImage;

public class HopperWagon extends Wagon
{
    //https://www.greenbrier-europe.com/products/product/tagnpps-130-m3/
    //https://www.greenbrier-europe.com/2022/10/07/tagnpps-130-m%c2%b3-4-axle-grain-hopper-wagon/
    private int load;

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
    public void loadCargoType(Cargo cargo)
    {

    }

    @Override
    public int getLoad()
    {
        return load;
    }

    @Override
    protected String errorMessage()
    {
        return null;
    }
}
