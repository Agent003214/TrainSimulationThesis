package Attachables.PassengerCar;


import java.awt.image.BufferedImage;

public class Mark3 extends Car
{

    public Mark3()
    {
        filePaths = new String[]
                {
                        "Attachables/Passenger/Mk3/Mk3Front.png",
                        "Attachables/Passenger/Mk3/Mk3Front.png",
                        "Attachables/Passenger/Mk3/Mk3Side.png",
                        "Attachables/Passenger/Mk3/Mk3.png"
                };
    }
    @Override
    public String getName()
    {
        return "British Rail Mark 3";
    }

    @Override
    public String getType()
    {
        return "Passenger car";
    }

    @Override
    public int getCapacity()
    {
        return 74;
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
