package Attachables.Cargo;

import Factories.BaseTrain;

public abstract class Cargo extends BaseTrain
{
    public abstract String getName();

    /**
     * Returns the density in kg/m³
     * @return
     */
    public abstract int getDensity();
}
