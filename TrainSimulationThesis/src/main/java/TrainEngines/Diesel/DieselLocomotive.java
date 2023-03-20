package TrainEngines.Diesel;

import Factories.BaseTrain;
import TrainEngines.Locomotive;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class DieselLocomotive extends BaseTrain implements Locomotive
{
    protected BufferedImage imageFront, imageBack, imageRightSide,imageLarge;
    protected String[] filePaths;

    public void load()
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

    /**
     * Lokomotív teljesítménye lóerőben.
     * @return
     */
    public abstract int getPower();
}
