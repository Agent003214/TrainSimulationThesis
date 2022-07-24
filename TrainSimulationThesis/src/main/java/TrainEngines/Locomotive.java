package TrainEngines;

import TrainFactories.Train;

public abstract class Locomotive implements Train
{
    public abstract String getModelName();

    public abstract String getMakerName();
    public abstract int getPower();

    /**
     * Lokomotív maximális sebessége km/h-ban.
     * @return
     */
    public abstract int getMaxSpeed();

    /**
     * Lokomotív tömege kilóban.
     * @return
     */
    public abstract int getWeight();
}
