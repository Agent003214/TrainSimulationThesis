package Attachables;

import java.awt.image.BufferedImage;

public interface Attachable
{
    BufferedImage getFrontPixelArt();
    BufferedImage getBackPixelArt();
    BufferedImage getRightSidePixelArt();
    BufferedImage getImageLarge();
    void loadImg();
    String getName();
    String getType();
    int getCapacity();
    int getMaxSpeed();
    int getGaugeSize();

    int getLength();

    void loadCargo(int num);
    void unloadCargo(int num);
    int getLoad();

}
