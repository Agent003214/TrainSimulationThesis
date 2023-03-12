package TrainEngines.Electric;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class V63 extends ElectricLocomotive
{
    public V63()
    {
        filePaths = new String[]
                {
                        "./TrainSimulationThesis/src/main/resources/Locomotives/Electric/V63/V63Front.png",
                        "./TrainSimulationThesis/src/main/resources/Locomotives/Electric/V63/V63Front.png",
                        "./TrainSimulationThesis/src/main/resources/Locomotives/Electric/V63/V63Side.png",
                        "./TrainSimulationThesis/src/main/resources/Locomotives/Electric/V63/V63.png"
                };
    }

    @Override
    protected String errorMessage()
    {
        return "V63 images not found";
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
        return "V63";
    }

    @Override
    public String getMakerName()
    {
        return "Ganz";
    }

    @Override
    public String getType()
    {
        return "Electric";
    }

    @Override
    public int getPower()
    {
        return 3575;
    }

    @Override
    public int getMaxSpeed()
    {
        return 160;
    }

    @Override
    public int getWeight()
    {
        return 116000;
    }

    @Override
    public int getLenght()
    {
        return 20;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

    @Override
    public String toString()
    {
        return "V63{}";
    }
}
