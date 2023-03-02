package Attachables.CargoWagon;

import Attachables.Cargo.Cargo;
import Attachables.Cargo.Coal;
import Attachables.Cargo.IronOre;

import java.awt.image.BufferedImage;

public class BoxWagon extends Wagon
{
    //https://www.greenbrier-europe.com/products/product/eamnos-72-m3-e04e/
    //https://www.greenbrier-europe.com/2022/10/07/eamnos-72-m%c2%b3-e04e-4-axle-open-box-wagon/

    public BoxWagon()
    {
        filePaths = new String[]
                {
                        "./src/main/resources/Attachables/Cargo/BoxWagon/BoxWagonFront.png",
                        "./src/main/resources/Attachables/Cargo/BoxWagon/BoxWagonFront.png",
                        "./src/main/resources/Attachables/Cargo/BoxWagon/BoxWagonSide.png",
                        "./src/main/resources/Attachables/Cargo/BoxWagon/BoxWagon.png"
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
        return "Box wagon images not found";
    }

    @Override
    public String getName()
    {
        return "Eamnos 72 m³ - E04E";
    }

    @Override
    public String getType()
    {
        return "Box wagon";
    }

    @Override
    public int getCapacity()
    {
        return 71000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 100;
    }

    @Override
    public int getGaugeSize()
    {
        return 1425;
    }

    @Override
    public int getLength()
    {
        return 13;
    }

    @Override
    public void loadCargoType(Cargo cargo)
    {
        if(cargo instanceof IronOre || cargo instanceof Coal)
        {
            this.cargo=cargo;
        }
    }

    @Override
    public int getLoad()
    {
        return load;
    }
}
