package Factories;

import Attachables.Attachable;
import Attachables.Cargo.Cargo;

public abstract class BaseTrain implements Train
{

    @Override
    public int getLength()
    {
        return 0;
    }

    @Override
    public void draw()
    {

    }
}
