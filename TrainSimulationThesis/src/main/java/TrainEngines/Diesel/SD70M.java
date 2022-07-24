package TrainEngines.Diesel;

public class SD70M extends SD70Family
{

    @Override
    public String getModelName()
    {
        return "SD70M";
    }

    @Override
    public String getMakerName()
    {
        return "General Motors";
    }

    @Override
    public int getPower()
    {
        return 4000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 0;
    }

    @Override
    public int getWeight()
    {
        return 181000;
    }


    @Override
    public int gaugeSize()
    {
        return 1435;
    }
}
