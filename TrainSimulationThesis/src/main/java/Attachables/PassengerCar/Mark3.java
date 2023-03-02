package Attachables.PassengerCar;


import java.awt.image.BufferedImage;

public class Mark3 extends Car
{

    public Mark3()
    {
        filePaths = new String[]
                {
                        "./src/main/resources/Attachables/Passenger/Mk3/Mk3Front.png",
                        "./src/main/resources/Attachables/Passenger/Mk3/Mk3Front.png",
                        "./src/main/resources/Attachables/Passenger/Mk3/Mk3Side.png",
                        "./src/main/resources/Attachables/Passenger/Mk3/Mk3.png"
                };
    }
    public String getName()
    {
        return "British Rail Mark 3";
    }

    public String getType()
    {
        return "Passenger car";
    }

    public int getCapacity()
    {
        return 74;
    }


    public int getMaxSpeed()
    {
        return 200;
    }

    public int getGaugeSize()
    {
        return 1435;
    }

    public int getLength()
    {
        return 23;
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
        return "Mark 3 images not found";
    }
}
