package Main;

import Factories.CompoundTrain;

import GUI.MethodClass;
import GUI.TrainGUI;

import javax.swing.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
       try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {

        }

        //new TrainGUI();
        SwingUtilities.invokeLater(() -> new TrainGUI().setVisible(true));

    }
}