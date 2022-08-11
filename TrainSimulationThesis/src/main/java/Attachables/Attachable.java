package Attachables;

import Factories.BaseTrain;

public abstract class Attachable extends BaseTrain
{
    int a;
    public abstract int getCapacity();
    public abstract int maxAllowedSpeed();
    public abstract int getGaugeSize();

    public abstract int getLength();

    public abstract void load(int num);
    public abstract void unload(int num);
    public abstract int getLoad();
}
