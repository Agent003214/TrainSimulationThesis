package Attachables.CargoWagon;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;

import java.awt.image.BufferedImage;

public class TankWagon extends Wagon
{
    //https://www.greenbrier-europe.com/2022/10/08/zags-53-m%c2%b3-4-axle-tank-wagon/
    //https://www.greenbrier-europe.com/2022/10/08/zags-103-m%c2%b3-4-axle-tank-wagon-for-ammonia/
    private int load=0;

    public TankWagon()
    {
        filePaths = new String[]
                {
                        "./src/main/resources/Attachables/Cargo/TankWagon/TankWagonFront.png",
                        "./src/main/resources/Attachables/Cargo/TankWagon/TankWagonFront.png",
                        "./src/main/resources/Attachables/Cargo/TankWagon/TankWagonSide.png",
                        "./src/main/resources/Attachables/Cargo/TankWagon/TankWagon.png"
                };
    }

    @Override
    public BufferedImage getFrontPixelArt()
    {
        return imageFront;
    }

    @Override
    public BufferedImage getBackPixelArt()
    {
        return imageBack;
    }

    @Override
    public BufferedImage getRightSidePixelArt()
    {
        return imageRightSide;
    }

    @Override
    public BufferedImage getImageLarge()
    {
        return imageLarge;
    }

    @Override
    protected String errorMessage()
    {
        return "Tank wagon images not found";
    }

    @Override
    public String getName()
    {
        return "Zags 103 m³";
    }

    @Override
    public String getType()
    {
        return "Fluid tank wagon";
    }

    @Override
    public int getCapacity()
    {
        return 55100;
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
    public void loadCargoType(Cargo cargo)
    {

    }

    @Override
    public int getLoad()
    {
        return load;
    }
}
