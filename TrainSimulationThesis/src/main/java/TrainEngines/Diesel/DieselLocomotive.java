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
            File file=new File(filePaths[0]);
            imageFront= ImageIO.read(file);
            file=new File(filePaths[1]);
            imageBack= ImageIO.read(file);
            file=new File(filePaths[2]);
            imageRightSide= ImageIO.read(file);
            file=new File(filePaths[3]);
            imageLarge= ImageIO.read(file);
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
