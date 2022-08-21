package TrainEngines;

import Factories.BaseTrain;

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
}
