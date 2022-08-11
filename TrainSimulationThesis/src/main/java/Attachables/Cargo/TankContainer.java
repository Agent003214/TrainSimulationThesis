package Attachables.Cargo;

public class TankContainer extends Cargo
{
    private int load;

    /**
     * Returns the capacity in liters
     * @return
     */
    @Override
    public int getCapacity()
    {
        return 25000*2;
    }

    /**
     * Returns the amount of currently loaded cargo in liters
     * @return
     */
    @Override
    public int getLoad()
    {
        return super.getLoad();
    }

    @Override
    public void load(int num)
    {
        super.load(num);
    }

    @Override
    public void unload(int num)
    {
        super.unload(num);
    }

    @Override
    public String toString()
    {
        return "TankContainer{}";
    }
}
