package TrainEngines.Electric;

import Annotation.Findable;

import java.lang.annotation.Target;

@Findable(name = "TrainEngine")
public class V63 extends ElectricLocomotive
{
    @Override
    public String getModelName()
    {
        return "V63";
    }

    @Override
    public String getMakerName()
    {
        return "Ganz";
    }

    @Override
    public int getPower()
    {
        return 3575;
    }

    @Override
    public int getMaxSpeed()
    {
        return 160;
    }

    @Override
    public int getWeight()
    {
        return 116000;
    }

    @Override
    public int getLenght()
    {
        return 20;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

    @Override
    public String toString()
    {
        return "V63{}";
    }
}
