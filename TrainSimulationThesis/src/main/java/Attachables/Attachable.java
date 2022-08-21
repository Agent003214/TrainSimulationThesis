package Attachables;

import Factories.BaseTrain;

public interface Attachable
{
    String getName();
    String getType();
    int getCapacity();
    int getMaxSpeed();
    int getGaugeSize();

    int getLength();

    void load(int num);
    void unload(int num);
    int getLoad();
}
