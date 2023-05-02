package Factories;

import Attachables.Cargo.Coal;
import Attachables.Cargo.Passenger;
import Attachables.PassengerCar.Mark3;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrainTest
{

    @Test
    public void PassengerCargoTypeTest()
    {
        Mark3 kocsi=new Mark3();
        kocsi.loadCargo(10,new Coal());
        assertEquals(kocsi.getLoad(),0);
    }

    @Test
    public void CarLoadCargoTest()
    {
        Mark3 kocsi=new Mark3();
        int helperint=kocsi.loadCargo(kocsi.getCapacity()+10,new Passenger());
        assertEquals(helperint,10);
    }

    @Test
    public void CarUnloadCargoTest()
    {
        Mark3 kocsi=new Mark3();
        kocsi.loadCargo(kocsi.getCapacity(),new Passenger());
        int helperint=kocsi.unloadCargo(kocsi.getCapacity()+10);
        assertEquals(helperint,10);//
    }

    @Test
    public void CarUnloadCargoTypeTest()
    {
        Mark3 kocsi=new Mark3();
        kocsi.loadCargo(kocsi.getCapacity(),new Passenger());
        kocsi.unloadCargo(kocsi.getCapacity()+10);
        assertNull(kocsi.getCargo());//
    }
}