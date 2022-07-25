package AlternateComponents.NewCars;

import Factories.BaseTrain;

public abstract class Cars extends BaseTrain
{

    public abstract int getCapacity();

    public abstract int maxAllowedSpeed();

    public abstract int getgaugeSize();

    public abstract String toString();
}
