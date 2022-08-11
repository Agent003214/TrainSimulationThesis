package Main;

import Annotation.Findable;
import Factories.CompoundTrain;

import GUI.TrainGUI;
import GUI.gui2;
import TrainEngines.Electric.Osztaly;
import TrainEngines.Electric.V63;
import org.reflections.Reflections;

import javax.swing.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //Look and feel
        //https://www.codegrepper.com/code-examples/java/java+swing+windows+10+look+and+feel
       try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e)
        {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (InstantiationException e)
        {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
        new TrainGUI();
        //new gui2();
        /*SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new TrainGUI().setVisible(true);
            }
        });*/
        ArrayList<CompoundTrain> train=new ArrayList<>();

        /*Reflections ref=new Reflections("TrainEngines");
        for(Class<?> cl:ref.getTypesAnnotatedWith(Findable.class))
        {
            Findable findable=cl.getAnnotation(Findable.class);
            String[] vagott=cl.getName().split("\\.");
            if (vagott[1].equals("Electric"))
            {
                System.out.println(vagott[2]);
            }
        }*/

        /*train.add(new CompoundTrain());
        train.get(0).add(new V63());
        train.get(0).createIntermodelFlatBed();
        train.get(0).createIntermodelFlatBed();
        //System.out.println(train.get(0).getLoadOfCar(3));
        System.out.println(train.get(0).getIntermodelCapacityCount());
        train.get(0).loadCar(1,5000);
        train.get(0).unloadCar(1,6000);
        System.out.println(train.get(0).getLoadOfCar(1));
        //System.out.println(train.get(0).getPassengerCapacityCount());
        System.out.println(train.get(0).toString());*/
        /*train.get(0).loadCar(1,15);
        System.out.println(train.get(0).getLoad(1));
        System.out.println(train.get(0).getLoad(2));*/

    }
}