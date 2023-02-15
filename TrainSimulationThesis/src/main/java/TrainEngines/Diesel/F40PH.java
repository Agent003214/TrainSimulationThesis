package TrainEngines.Diesel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class F40PH extends DieselLocomotive
{
    public F40PH()
    {
        try
        {
            File file = new File("./src/main/resources/Locomotives/V63Front.png");
            imageFront = ImageIO.read(file);
            file = new File("./src/main/resources/Locomotives/V63Side.png");
            imageRightSide = ImageIO.read(file);
            file = new File("./src/main/resources/Attachables/Mk3.png");
            imageLarge = ImageIO.read(file);
        } catch (IOException e)
        {
            System.out.println("F40PH images not found");
            e.printStackTrace();
        }
    }
    @Override
    public BufferedImage getFrontPixelArt()
    {
        return imageFront;
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
    public BufferedImage getLeftSidePixelArt()
    {
        return null;
    }

    public BufferedImage getSidePixelArt()
    {
        return imageRightSide;
    }
    public BufferedImage getImageLarge()
    {
        return imageLarge;
    }
    public String getModelName()
    {
        return "F40PH";
    }


    public String getMakerName()
    {
        return "General-Motors";
    }

    @Override
    public String getType()
    {
        return "Diesel";
    }

    @Override
    protected String errorMessage()
    {
        return null;
    }

    @Override
    public int getPower()
    {
        return 3000;
    }


    public int getMaxSpeed()
    {
        return 170;
    }


    public int getWeight()
    {
        return 120000;
    }


    public int getLenght()
    {
        return 0;
    }


    public int getGaugeSize()
    {
        return 1435;
    }
}
