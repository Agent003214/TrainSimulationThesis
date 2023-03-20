package TrainEngines.Diesel;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SD70M extends DieselLocomotive
{
    //https://www.thedieselshop.us/Data%20EMD%20SD70M.HTML
    public SD70M()
    {
        filePaths = new String[]
                {
                        "Locomotives/Diesel/SD70M/SD70MFront.png",
                        "Locomotives/Diesel/SD70M/SD70MBack.png",
                        "Locomotives/Diesel/SD70M/SD70MRight.png",
                        "Locomotives/Diesel/SD70M/SD70M.png"
                };
    }

    @Override
    protected String errorMessage()
    {
        return "SD70M images not found";
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
    public BufferedImage getLeftSidePixelArt()
    {
        AffineTransform tx=AffineTransform.getScaleInstance(-1,1);
        tx.translate(-imageRightSide.getWidth(null),0);
        AffineTransformOp op=new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(imageRightSide,null);
    }
    @Override
    public BufferedImage getImageLarge()
    {
        return imageLarge;
    }
    @Override
    public String getModelName()
    {
        return "SD70M";
    }

    @Override
    public String getMakerName()
    {
        return "General-Motors";
    }

    @Override
    public String getType()
    {
        return "Diesel";
    }

    @Override
    public int getPower()
    {
        return 4000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 110;
    }

    @Override
    public int getWeight()
    {
        return 181000;
    }

    @Override
    public int getLenght()
    {
        return 0;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }
}
