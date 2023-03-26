package Attachables.CargoWagon;

import Attachables.Attachable;
import Attachables.Cargo.*;
import Factories.Train;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class Wagon implements Attachable,Cloneable
{
    //https://www.greenbrier-europe.com/home/
    protected BufferedImage imageFront, imageBack, imageRightSide,imageLarge;
    protected String[] filePaths;
    protected Cargo cargo;
    protected int load;
    public void loadImg()
    {
        try
        {
            imageFront=ImageIO.read(getClass().getClassLoader().getResource(filePaths[0]));
            imageBack=ImageIO.read(getClass().getClassLoader().getResource(filePaths[1]));
            imageRightSide=ImageIO.read(getClass().getClassLoader().getResource(filePaths[2]));
            imageLarge=ImageIO.read(getClass().getClassLoader().getResource(filePaths[3]));
        }
        catch (IOException e)
        {
            System.out.println(errorMessage());
            e.printStackTrace();
        }
    }

    protected abstract String errorMessage();

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
    public Cargo[] getCargoCompatibility()
    {
        Cargo[] cargo=new Cargo[3];
        cargo[0]=new Coal();
        cargo[1]=new IronOre();
        cargo[2]=new Steel();
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
