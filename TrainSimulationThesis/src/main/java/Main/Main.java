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
        //new TrainGUI();
        SwingUtilities.invokeLater(() -> new TrainGUI().setVisible(true));

    }
}