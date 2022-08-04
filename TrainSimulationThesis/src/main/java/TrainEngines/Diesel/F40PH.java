package TrainEngines.Diesel;

public class F40PH extends DieselLocomotive
{
    @Override
    public String getModelName()
    {
        return "F40PH";
    }

    @Override
    public String getMakerName()
    {
        return "General-Motors";
    }

    @Override
    public int getPower()
    {
        return 3000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 170;
    }

    @Override
    public int getWeight()
    {
        return 120000;
    }

    @Override
    public int getLenght()
    {
        return 0;
    }

    @Override
    public int getGaugeSize()
    {
        return 1435;
    }

}
