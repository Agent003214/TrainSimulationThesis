package Attachables.CargoContainer;

public class ShortContainer extends CargoContainer
{
    //https://www.icontainers.com/help/20-foot-container/
    @Override
    public String getName()
    {
        return "20ft container";
    }

    @Override
    public int getCapacity()
    {
        return 25400;
    }
}
