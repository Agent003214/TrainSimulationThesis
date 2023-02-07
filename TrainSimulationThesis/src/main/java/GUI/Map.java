package GUI;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel
{
    private MethodClass GUIMethods=new MethodClass();
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
    public Map()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(dim);
        gridBagLayout=new GridBagLayout();
        setLayout(gridBagLayout);
        c=new GridBagConstraints();
        JPanel trainPanel =new JPanel();

        trainPanel.setLayout(new GridLayout(2,1));
        JPanel trainPanelTop=new JPanel();
        JPanel trainPanelBottom=new JPanel();

        trainPanel.add(trainPanelTop);
        trainPanel.add(trainPanelBottom);

        trainPanel.setPreferredSize(new Dimension(300,1040));
        c.gridx=0;
        c.gridy=0;
        add(trainPanel,c);


        MapPanel map=new MapPanel();
        JPanel mapPanel=map;
        mapPanel.setPreferredSize(new Dimension(1920-600,1040));
        c.gridx=1;
        c.gridy=0;
        add(mapPanel,c);

        JPanel stopsPanel=new JPanel();
        stopsPanel.setPreferredSize(new Dimension(300,1040));
        stopsPanel.setBackground(Color.orange);
        c.gridx=2;
        c.gridy=0;
        add(stopsPanel,c);
    }
}
