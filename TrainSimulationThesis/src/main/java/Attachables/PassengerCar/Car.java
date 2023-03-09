package Attachables.PassengerCar;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;
import Attachables.Cargo.Passenger;
import Factories.BaseTrain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public abstract class Car extends BaseTrain implements Attachable,Cloneable
{
    protected BufferedImage imageFront, imageBack, imageRightSide, imageLarge;
    protected String[] filePaths;
    protected Cargo cargo;
    protected int load;

    public void loadImg()
    {
        try
        {
            File file = new File(filePaths[0]);
            imageFront = ImageIO.read(file);
            file = new File(filePaths[1]);
            imageBack = ImageIO.read(file);
            file = new File(filePaths[2]);
            imageRightSide = ImageIO.read(file);
            file = new File(filePaths[3]);
            imageLarge = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println(errorMessage());
            e.printStackTrace();
        }
    }

    protected abstract String errorMessage();

    @Override
    public void loadCargoType(Cargo cargo)
    {
        if (cargo instanceof Passenger)
        {
            this.cargo = cargo;
        }
    }

    @Override
    public int loadCargo(int num,Cargo type)
    {
        for (int i = 0; i < getCargoCompatibility().length; i++)
        {
            if (Objects.equals(getCargoCompatibility()[i].getName(), type.getName()))
            {
                int emptySpace=getCapacity()-getLoad();
                if (num<=emptySpace)
                {
                    load+=num;
                    return 0;
                }
                else
                {
                    load+=emptySpace;
                    return num-emptySpace;
                }
            }
        }
        return -1;
    }

    @Override
    public int unloadCargo(int num)
    {
        if (load-num>=0)
        {
            load-=num;
            return num;
        }
        else
        {
            int helper=Math.abs(load-num);
            load=0;
            cargo=null;
            return helper;
        }
    }

    @Override
    public int getLoad()
    {
        return load;
    }

    @Override
    public Cargo[] getCargoCompatibility()
    {
        Cargo[] cargo=new Cargo[1];
        cargo[0]=new Passenger();
        return cargo;
    }

    @Override
    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
