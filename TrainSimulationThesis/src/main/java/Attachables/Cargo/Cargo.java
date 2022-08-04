package Attachables.Cargo;


import Factories.BaseTrain;

public abstract class Cargo extends BaseTrain
{
    public abstract int getCapacity();
    public abstract void load(int num);
    public abstract int getLoad();
}
