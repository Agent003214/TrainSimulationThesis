package TrainEngines.Diesel;

public class SD70M extends DieselLocomotive
{
    //https://www.thedieselshop.us/Data%20EMD%20SD70M.HTML
    @Override
    public String getModelName()
    {
        return "SD70M";
    }

    @Override
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
        return 4000;
    }

    @Override
    public int getMaxSpeed()
    {
        return 110;
    }

    @Override
    public int getWeight()
    {
        return 181000;
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
