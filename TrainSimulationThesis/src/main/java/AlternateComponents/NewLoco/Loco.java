package AlternateComponents.NewLoco;

import Factories.BaseTrain;

public abstract class Loco extends BaseTrain
{
    abstract String getModelName();

    abstract String getMakerName();
    abstract int getPower();

    /**
     * Lokomotív maximális sebessége km/h-ban.
     * @return
     */
    abstract int getMaxSpeed();

    /**
     * Lokomotív tömege kilóban.
     * @return
     */
    abstract int getWeight();

    abstract int getGaugeSize();
}
