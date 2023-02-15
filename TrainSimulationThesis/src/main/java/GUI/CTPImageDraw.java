package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CTPImageDraw extends JPanel
{
    private final int imgWidth=109;
    private final int imgHeight=28;
    private final double scale=4;
    private final int yCoord=100;
    private static ArrayList<BufferedImage> imgArray;
    public CTPImageDraw()
    {
        setBackground(Color.YELLOW);
        imgArray=new ArrayList<>();
    }

    protected void addTrainImage(BufferedImage img)
    {
        imgArray.add(img);
    }

    protected void resetImages()
    {
        imgArray=new ArrayList<>();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.GREEN);
        for (int i = 0; i < imgArray.size(); i++)
        {
            //g2D.fillRect(i*xCoord, yCoord, 721, 224);
            g2D.drawImage(imgArray.get(i),(int) ((i)*(imgWidth*scale)+50), yCoord, (int) (imgWidth*scale), (int)(imgHeight*scale),null);
        }




        g2D.dispose();
    }
}
