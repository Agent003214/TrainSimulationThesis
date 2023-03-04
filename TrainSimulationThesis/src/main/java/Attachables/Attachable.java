package Attachables;

import Attachables.Cargo.Cargo;

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

    /**
     *
     * @return The capacity in tonnes for cargo, passenger count for passenger cars
     */
    int getCapacity();
    void loadCargoType(Cargo cargo);
    int loadCargo(int num);
    int unloadCargo(int num);
    int getLoad();

}
