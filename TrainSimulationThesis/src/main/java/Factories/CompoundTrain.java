package Factories;

import Attachables.Attachable;
import Attachables.CargoWagon.BoxWagon;
import Attachables.CargoWagon.Wagon;
import Attachables.PassengerCar.Car;
import Exceptions.NoEngineException;
import TrainEngines.Electric.ElectricLocomotive;
import TrainEngines.Locomotive;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class CompoundTrain extends BaseTrain
{
    protected ArrayList<Train> trains =new ArrayList<>();
    private final int maxlength=10;
    private String trainName;

    public void setTrainName(String trainName)
    {
        this.trainName = trainName;
    }

    public String getTrainName()
    {
        return trainName;
    }

    public String addComponent(Train component)
    {

        try
        {
            if (trains.size()<maxlength)
            {
                checkEngine(component);
                trains.add(component);
                return "";
            }
            else
            {
                return "The train length is limited to "+maxlength;
            }

        }
        catch (NoEngineException e)
        {
            return "The train requires at least one locomotive";
        }
    }
    public String addComponent(Train ... component)
    {
        try
        {
            checkEngine(component);
            trains.addAll(Arrays.asList(component));
            return "";
        }
        catch (NoEngineException e)
        {
            return "The train requires at least one locomotive";
        }
    }

    /**
     * Check, if there is a locomotive in the train. If not, throws an exception.
     * @param component
     *
     */
    private void checkEngine(Train ... component) throws NoEngineException
    {
        int counter=0;
        for (int i = 0; i < component.length; i++)
        {
            if (component[i] instanceof Locomotive)
            {
                counter++;
            }
        }
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Locomotive)
            {
                counter++;
            }
        }
        if (counter==0)
        {
            throw new NoEngineException();
        }
    }


    public int getTrainLenght()
    {
        return trains.size();
    }

    public int getCombinedPower()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Locomotive)
            {
                szamlalo+=((Locomotive) trains.get(i)).getPower();
            }
        }
        return szamlalo;
    }

    public int getNumbersOfCars()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Attachable)
            {
                szamlalo++;
            }
        }
        return szamlalo;
    }

    public int getPassengerCapacity()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Car)
            {
                szamlalo=szamlalo+((Car) trains.get(i)).getCapacity();
            }
        }
        return szamlalo;
    }

    public int getCargoCapacity()
    {
        int szamlalo=0;
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof BoxWagon)
            {
                szamlalo=szamlalo+((Wagon) trains.get(i)).getCapacity();
            }
        }
        return szamlalo;
    }


    public int getLoadOfCar(int i)
    {
        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getLoad();
        }
        return 0;
    }

    public int getCapacityOfCar(int i)
    {
        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getCapacity();
        }
        return 0;
    }

    public Train getCar(int i)
    {
        return trains.get(i);
    }

    /*public void createTankFlatBed()
    {
        trains.add(new RLMMPS651FlatWagon(new TankContainer()));
    }*/

    /*public void createIntermodelFlatBed()
    {
        trains.add(new RLMMPS651FlatWagon(new IntermodelContainer()));
    }*/

    @Override
    public int getLength()
    {
        return super.getLength();
    }

    public String[] trainCars()
    {
        String[] trainCars=new String[trains.size()];
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof Locomotive)
            {
                trainCars[i]=((Locomotive) trains.get(i)).getModelName();
            }
            if (trains.get(i) instanceof Attachable)
            {
                trainCars[i]=((Attachable) trains.get(i)).getName();
            }
            //trainCars[i]=trains.get(i).toString();
        }
        return trainCars;
    }

    public BufferedImage drawImage(int i)
    {
        if (trains.get(i) instanceof Locomotive)
        {
            return ((Locomotive) trains.get(i)).getImageLarge();
        }

        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getImageLarge();
        }

        return null;
    }

    public BufferedImage getRightImage(int i)
    {
        if (trains.get(i) instanceof Locomotive)
        {
            return ((Locomotive) trains.get(i)).getRightSidePixelArt();
        }

        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getRightSidePixelArt();
        }

        return null;
    }

    public BufferedImage getFrontImage(int i)
    {
        if (trains.get(i) instanceof Locomotive)
        {
            return ((Locomotive) trains.get(i)).getFrontPixelArt();
        }

        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getFrontPixelArt();
        }

        return null;
    }

    public BufferedImage getBackImage(int i)
    {
        if (trains.get(i) instanceof Locomotive)
        {
            return ((Locomotive) trains.get(i)).getBackPixelArt();
        }

        if (trains.get(i) instanceof Attachable)
        {
            return ((Attachable) trains.get(i)).getBackPixelArt();
        }

        return null;
    }

    public boolean checkElectrified()
    {
        for (int i = 0; i < trains.size(); i++)
        {
            if (trains.get(i) instanceof ElectricLocomotive)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "CompoundTrain{" +
                "Train=" + trains +
                '}';
    }
}
