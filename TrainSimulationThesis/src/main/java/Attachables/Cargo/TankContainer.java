package Attachables.Cargo;

public class TankContainer extends Cargo
{

    /**
     * Returns the capacity in liters
     * @return
     */
    @Override
    public int getCapacity()
    {
        return 21000;
    }

    @Override
    public void load(int num)
    {

    }

    @Override
    public int getLoad()
    {
        return 0;
    }
}
