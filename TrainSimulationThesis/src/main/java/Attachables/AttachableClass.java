package Attachables;

import TrainFactories.Train;

public abstract class AttachableClass implements Train
{
    public abstract int getCapacity();
    public abstract int maxAllowedSpeed();
    public abstract int gaugeSize();

}
