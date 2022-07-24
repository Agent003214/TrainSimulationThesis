package TrainEngines;

public interface Locomotive
{
    String getModelName();

    String getMakerName();
    int getPower();

    /**
     * Lokomotív maximális sebessége km/h-ban.
     * @return
     */
     int getMaxSpeed();

    /**
     * Lokomotív tömege kilóban.
     * @return
     */
    int getWeight();

    int getGaugeSize();
}
