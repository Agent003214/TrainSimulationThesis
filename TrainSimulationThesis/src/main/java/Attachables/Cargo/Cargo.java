package Attachables.Cargo;

import Factories.Train;

public abstract class Cargo implements Train
{
    public abstract String getName();

    /**
     * Returns the density in kg/m³
     * @return
     */
    public abstract int getDensity();
}
