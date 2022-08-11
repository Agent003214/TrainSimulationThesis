package Attachables.Cargo;


public class IntermodelContainer extends Cargo
{
    private int load;
    /**
     * Returns the capacity in kilograms.
     * @return
     */
    @Override
    public int getCapacity()
    {
        return 20000;
    }

    @Override
    public void load(int num)
    {
        if (num+load<=getCapacity())
        {
            load=load+num;
        }
    }

    @Override
    public void unload(int num)
    {
        if (load-num>=0)
        {
            load=load-num;
        }
    }
    /**
     * Return the currently loaded cargo in kilograms.
     * @return
     */
    @Override
    public int getLoad()
    {
        return load;
    }
}
