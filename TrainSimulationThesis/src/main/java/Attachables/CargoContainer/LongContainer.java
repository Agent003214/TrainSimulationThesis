package Attachables.CargoContainer;

public class LongContainer extends CargoContainer
{
    //https://www.icontainers.com/help/40-foot-container/
    @Override
    public String getName()
    {
        return "40ft container";
    }

    @Override
    public int getCapacity()
    {
        return 26300;
    }
}
