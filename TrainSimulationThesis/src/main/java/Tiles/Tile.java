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
        //File file = new File(filePaths[rnd.nextInt(filePaths.length)]);
        //InputStream is=getClass().getClassLoader().getResourceAsStream(filePaths[rnd.nextInt(filePaths.length)]);
        try
        {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(filePaths[rnd.nextInt(filePaths.length)])));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //InputStream is= ClassLoader.getSystemResource(filePaths[rnd.nextInt(filePaths.length)]).openStream();
        //image=new ImageIcon(getClass().getClassLoader().getResource(filePaths[rnd.nextInt(filePaths.length)]));

    }

    protected abstract String errorMessage();

}
