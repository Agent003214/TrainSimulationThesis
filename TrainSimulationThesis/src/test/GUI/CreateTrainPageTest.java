package GUI;

import Attachables.PassengerCar.Car;
import Factories.CompoundTrain;
import TrainEngines.Electric.ElectricLocomotive;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class CreateTrainPageTest {


    @Test
    public void TrainEngineTest()
    {
        ArrayList<CompoundTrain> train = new ArrayList<>();
        MethodClass methods=new MethodClass();
        train.add(new CompoundTrain());
        assertEquals(train.get(0).addComponent(methods.getAttachableArrayList().get(0)),"The train requires at least one locomotive");
    }

    @Test
    public void TrainLenghtCheck()
    {
        ArrayList<CompoundTrain> train = new ArrayList<>();
        MethodClass methods=new MethodClass();
        train.add(new CompoundTrain());
        train.get(0).addComponent(methods.getLocomotivesArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        assertEquals(train.get(0).getTrainLenght(),10);
    }

    @Test
    public void TrainElementRemoveLast()
    {
        ArrayList<CompoundTrain> train = new ArrayList<>();
        train.add(new CompoundTrain());
        assertEquals(train.get(0).removeLast(),"The train is already empty!");
    }

    @Test
    public void TrainCarTest()
    {
        ArrayList<CompoundTrain> train = new ArrayList<>();
        MethodClass methods=new MethodClass();
        train.add(new CompoundTrain());
        train.get(0).addComponent(methods.getLocomotivesArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        train.get(0).addComponent(methods.getAttachableArrayList().get(0));
        String[] temp={((ElectricLocomotive)train.get(0).getCar(0)).getModelName(),((Car)train.get(0).getCar(1)).getName(),((Car)train.get(0).getCar(2)).getName()};
        assertEquals(train.get(0).trainCars(),temp);
    }

    @Test
    public void PassengerCapacityTest()
    {

    }
}