package AlternateComponents.NewCars;

public class NewICPlus extends Cars
{
    @Override
    public int getCapacity()
    {
        return 80;
    }

    @Override
    public int maxAllowedSpeed()
    {
        return 200;
    }

    @Override
    public int getgaugeSize()
    {
        return 1435;
    }

    @Override
    public String toString()
    {
        return "InterCityPlus{}";
    }
}
