package TrainEngines.Electric;

import Factories.BaseTrain;
import TrainEngines.Locomotive;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ElectricLocomotive extends BaseTrain implements Locomotive
{
    protected BufferedImage imageFront, imageBack, imageRightSide,imageLarge;
    protected String[] filePaths;
    @Override
    public void load()
    {
        try
        {
            /*File file=new File(filePaths[0]);
            imageFront= ImageIO.read(file);
            file=new File(filePaths[1]);
            imageBack= ImageIO.read(file);
            file=new File(filePaths[2]);
            imageRightSide= ImageIO.read(file);
            file=new File(filePaths[3]);
            imageLarge= ImageIO.read(file);*/
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
