package TrainEngines.Diesel;

public class F40PH extends DieselLocomotive
{

    public String getModelName()
    {
        return "F40PH";
    }


    public String getMakerName()
    {
        return "General-Motors";
    }

    @Override
    public String getType()
    {
        return "Diesel";
    }

    @Override
    public int getPower()
    {
        return 3000;
    }


    public int getMaxSpeed()
    {
        return 170;
    }


    public int getWeight()
    {
        return 120000;
    }


    public int getLenght()
    {
        return 0;
    }


    public int getGaugeSize()
    {
        return 1435;
    }
}
