package Tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class Tile implements Loadable
{
    protected BufferedImage image;
    protected String[] filePaths;
    @Override
    public void load()
    {
        try
        {
            Random rnd = new Random();
            File file = new File(filePaths[rnd.nextInt(filePaths.length)]);
            image = ImageIO.read(file);

        }
        catch (IOException e)
        {
            System.out.println(errorMessage());
            e.printStackTrace();
        }
    }

    protected abstract String errorMessage();

}
