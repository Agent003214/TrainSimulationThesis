package TrainEngines;

import Factories.Train;

import java.awt.image.BufferedImage;

public interface Locomotive extends Train
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
    BufferedImage getFrontPixelArt();
    BufferedImage getBackPixelArt();
    BufferedImage getRightSidePixelArt();
    BufferedImage getImageLarge();
    void load();
}
