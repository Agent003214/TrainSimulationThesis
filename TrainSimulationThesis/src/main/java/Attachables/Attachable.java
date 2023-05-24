package Attachables;

import Attachables.Cargo.Cargo;
import Factories.Train;

import java.awt.image.BufferedImage;

public interface Attachable extends Train
{
    /**
     * The front side of the attachable pixel art fot the map panel
     * @return
     */
    BufferedImage getFrontPixelArt();

    /**
     * The rear side of the attachable pixel art fot the map panel
     * @return
     */
    BufferedImage getBackPixelArt();

    /**
     * The right side of the attachable pixel art fot the map panel. For the left side, this image is flipped
     * @return
     */
    BufferedImage getRightSidePixelArt();

    /**
     * The image appearing when creating a train in the "Create train" page
     * @return
     */
    BufferedImage getImageLarge();

    /**
     * Loads all child class image files
     */
    void loadImg();
    String getName();
    String getType();

    /**
     *
     * @return The capacity in tonnes for cargo, passenger count for passenger cars
     */
    int getCapacity();
    void loadCargoType(Cargo cargo);

    /**
     * Loads the cargo to the car.
     * @param num The number of cargo you wish to load
     * @param type The type of cargo you wish to load
     * @return  The number you failed to load because the car is full.
     * <br>EG: Car capacity is 100, load 110, return 10
     */
    int loadCargo(int num,Cargo type);

    /**
     * Unloads the cargo from the car.
     * @param num The free space available on a station/The number of passengers you wish to unload
     * @return The new free space on the station
     * <br> EG:free capacity of station:110, car load:100, return:10
     */
    int unloadCargo(int num);

    /**
     *
     * @return Returns the current load of the car
     */
    int getLoad();
    Cargo[] getCargoCompatibility();
    Object clone();

}
