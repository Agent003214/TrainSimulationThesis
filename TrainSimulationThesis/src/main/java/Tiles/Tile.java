package Tiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;
import java.util.Random;

public abstract class Tile implements Loadable
{
    protected BufferedImage image;
    protected String[] filePaths;
    @Override
    public void load()
    {
        Random rnd = new Random();
        try
        {
            image = ImageIO.read(getClass().getClassLoader().getResource(filePaths[rnd.nextInt(filePaths.length)]));
        }
        catch (IOException e)
        {
            System.out.println(errorMessage());
            e.printStackTrace();
        }

    }

    protected abstract String errorMessage();

}
