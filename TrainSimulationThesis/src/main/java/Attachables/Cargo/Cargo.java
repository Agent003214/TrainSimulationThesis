package Attachables.Cargo;


import Factories.BaseTrain;

public abstract class Cargo extends BaseTrain
{
    int load;
    public abstract String getName();

    /**
     * Return the capacity in kilogramms.
     * @return
     */
    public abstract int getCapacity();
    public void load(int num)
    {
        if (load+num<=getCapacity())
        {
            load=load+num;
        }
    }

    public void unload(int num)
    {
            if (load-num>=0)
            {
                load=load-num;
            }
    }

    public int getLoad()
    {
        return load;
    }
}
