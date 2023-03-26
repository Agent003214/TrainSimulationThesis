package TrainEngines.Electric;

import Factories.Train;
import TrainEngines.Locomotive;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class ElectricLocomotive implements Locomotive, Train
{
    protected BufferedImage imageFront, imageBack, imageRightSide,imageLarge;
    protected String[] filePaths;
    @Override
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
}
