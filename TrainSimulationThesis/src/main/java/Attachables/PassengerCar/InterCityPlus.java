package Attachables.PassengerCar;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;
import Attachables.Cargo.Passenger;

import java.awt.image.BufferedImage;

public class InterCityPlus extends Car
{
    public InterCityPlus()
    {
        filePaths = new String[]
                {
                        "./TrainSimulationThesis/src/main/resources/Attachables/Passenger/IC/InterCityFront.png",
                        "./TrainSimulationThesis/src/main/resources/Attachables/Passenger/IC/InterCityFront.png",
                        "./TrainSimulationThesis/src/main/resources/Attachables/Passenger/IC/InterCitySide.png",
                        "./TrainSimulationThesis/src/main/resources/Attachables/Passenger/IC/InterCity.png"
                };
    }

    @Override
    public String getName()
    {
        return "Inter City+";
    }

    @Override
    public String getType()
    {
        return "Passenger car";
    }

    @Override
    public int getCapacity()
    {
        return 80;
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

    /*@Override
    public String toString()
    {
        return "InterCityPlus{}";
    }*/

    @Override
    protected String errorMessage()
    {
        return "IC+ images not found";
    }
}
