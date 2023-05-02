package GUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class CreateTrainPageGUITest
{
    private Robot robot=new Robot();
    private TrainGUI TrainGUI;


    public CreateTrainPageGUITest() throws AWTException
    {
    }

    @BeforeMethod
    public void GUISetup()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ignored)
        {

        }
        TrainGUI=new TrainGUI();

    }

    @Test
    public void ImageTest() throws InterruptedException
    {
        robot.mouseMove(1920/2,10);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(100,10);
        Thread.sleep(5000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(100,690);
        Thread.sleep(5000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(100,900);
        Thread.sleep(5000);
        Color colour=robot.getPixelColor(100,900);
        Color V63Colour=new Color(56,82,139);
        assertEquals(colour,V63Colour);
    }

    @Test
    public void ImageDeleteTest() throws InterruptedException
    {
        robot.mouseMove(1920/2,10);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(100,10);
        Thread.sleep(5000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(100,690);
        Thread.sleep(5000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(1920/2,710);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(5000);
        Color colour=robot.getPixelColor(100,900);
        Color backgroundColour=new Color(240,240,240);
        assertEquals(colour,backgroundColour);
    }
}
