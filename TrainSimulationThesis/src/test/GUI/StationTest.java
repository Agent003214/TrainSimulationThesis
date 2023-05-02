package GUI;

import Attachables.Cargo.Coal;
import Attachables.Cargo.IronOre;
import Attachables.Cargo.Passenger;
import Attachables.Cargo.Steel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StationTest
{
    private MethodClass GUIMethods = new MethodClass();
    @BeforeTest
    public void setUp()
    {
        GUIMethods.addStation(new int[]{21,7},"Pass1",800,new Passenger());
        GUIMethods.addStation(new int[]{8,14},"Pass2",150,new Passenger());
        GUIMethods.addStation(new int[]{15,23},"Pass3",80,new Passenger());
        GUIMethods.addStation(new int[]{31,19},"Pass4",80,new Passenger());
        GUIMethods.addStation(new int[]{8,17},"Iron mine",8000,new IronOre());
        GUIMethods.addStation(new int[]{23,9},"Iron",0,new IronOre());
        GUIMethods.addStation(new int[]{31,16},"Coal mine",5000,new Coal());
        GUIMethods.addStation(new int[]{27,7},"Coal",0,new Coal());
        GUIMethods.addStation(new int[]{27,4},"Steel mill",0,new Steel());
        GUIMethods.addStation(new int[]{21,30},"Steel export",0,new Steel());
    }

    @Test
    public void IronOreUpdateTest()
    {
        GUIMethods.getStations().get(1).setCurrentLoad(301);
        GUIMethods.getStations().get(4).setCurrentLoad(0);

        GUIMethods.getStations().get(4).update();
        assertEquals(GUIMethods.getStations().get(4).getCurrentLoad(),100);
    }

    @Test
    public void CoalUpdateTest()
    {
        GUIMethods.getStations().get(3).setCurrentLoad(301);
        GUIMethods.getStations().get(6).setCurrentLoad(0);

        GUIMethods.getStations().get(6).update();
        assertEquals(GUIMethods.getStations().get(6).getCurrentLoad(),100);
    }

    @Test
    public void SteelUpdateTest()
    {
        GUIMethods.getStations().get(5).setCurrentLoad(1000);
        GUIMethods.getStations().get(7).setCurrentLoad(1000);

        GUIMethods.getStations().get(8).update();
        assertEquals(GUIMethods.getStations().get(8).getCurrentLoad(),1000);
    }
}