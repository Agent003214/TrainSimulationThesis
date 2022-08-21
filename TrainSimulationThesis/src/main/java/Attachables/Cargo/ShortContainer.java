package Attachables.Cargo;

public class ShortContainer extends Cargo
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
