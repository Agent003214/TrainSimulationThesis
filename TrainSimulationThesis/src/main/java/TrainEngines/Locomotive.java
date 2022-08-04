package TrainEngines;

import Factories.BaseTrain;

public abstract class Locomotive extends BaseTrain
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

    public abstract int getLenght();

    public abstract int getGaugeSize();
}
