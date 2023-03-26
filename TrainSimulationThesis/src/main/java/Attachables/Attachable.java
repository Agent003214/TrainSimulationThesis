package Attachables;

import Attachables.Cargo.Cargo;
import Factories.Train;

import java.awt.image.BufferedImage;

public interface Attachable extends Train
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
    int loadCargo(int num,Cargo type);
    int unloadCargo(int num);
    int getLoad();
    Cargo[] getCargoCompatibility();
    Object clone();

}
