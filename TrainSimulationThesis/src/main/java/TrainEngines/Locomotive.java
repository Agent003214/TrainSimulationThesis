package TrainEngines;

import java.awt.image.BufferedImage;

public interface Locomotive
{
    String getModelName();

    String getMakerName();

    String getType();

    int getPower();

    /**
     * Lokomotív maximális sebessége km/h-ban.
     *
     * @return
     */
    int getMaxSpeed();

    /**
     * Lokomotív tömege kilóban.
     *
     * @return
     */
    int getWeight();

    int getLenght();

    int getGaugeSize();
    BufferedImage getFrontPixelArt();
    BufferedImage getBackPixelArt();
    BufferedImage getRightSidePixelArt();
    BufferedImage getLeftSidePixelArt();
    BufferedImage getImageLarge();
    void load();
}
