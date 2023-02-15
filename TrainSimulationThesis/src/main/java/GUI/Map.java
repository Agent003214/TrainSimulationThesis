package GUI;

import Routes.Routes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Map extends JPanel
{
    private MethodClass GUIMethods=new MethodClass();
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
    private JList<String> trainListInfoPanel;
    private JTextArea trainContentInfoPanel;
    private ArrayList<Routes> routes;

    public Map()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(dim);
        gridBagLayout=new GridBagLayout();
        setLayout(gridBagLayout);
        c=new GridBagConstraints();

        //Left side panels
        JPanel trainPanel =new JPanel();
        trainPanel.setLayout(new GridLayout(2,1));
        JPanel trainPanelTop=new JPanel();
        trainPanelTop.setLayout(new BorderLayout());
        //JPanel trainPanelBottom=new JPanel();

        trainListInfoPanel=new JList<>(new DefaultListModel<>());
        trainListInfoPanel.setFont(GUIMethods.font);
        trainPanelTop.add(trainListInfoPanel,BorderLayout.CENTER);
        JButton refreshButton=new JButton("Refresh");
        refreshButton.addActionListener(e -> refresh());
        trainPanelTop.add(refreshButton,BorderLayout.SOUTH);
        trainPanel.add(trainPanelTop);

        trainListInfoPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                JList list=(JList) e.getSource();
                trainComponents(list.getSelectedIndex());
            }
        });

        trainContentInfoPanel=new JTextArea();
        trainContentInfoPanel.setEditable(false);
        trainContentInfoPanel.setFont(GUIMethods.font);
        trainPanel.add(trainContentInfoPanel);

        /*trainPanel.add(trainPanelTop);
        trainPanel.add(trainPanelBottom);*/

        trainPanel.setPreferredSize(new Dimension(300,1040));
        c.gridx=0;
        c.gridy=0;
        add(trainPanel,c);

        //Middle map panel
        MapPanel map=new MapPanel();
        JPanel mapPanel=map;
        mapPanel.setPreferredSize(new Dimension(1920-600,1040));
        c.gridx=1;
        c.gridy=0;
        add(mapPanel,c);

        //Right side panels
        JPanel stopsPanel=new JPanel();

        JList stopList=new JList<>();
        int[] start={1,5};
        int[] stop={4,5};
        routes.add(new Routes(start,stop,"Route 1"));


        stopsPanel.setPreferredSize(new Dimension(300,1040));
        stopsPanel.setBackground(Color.orange);
        c.gridx=2;
        c.gridy=0;
        add(stopsPanel,c);


    }

    private void refresh()
    {
        String[] refreshArray =new String[GUIMethods.getTrain().size()];
        for (int i = 0; i < GUIMethods.getTrain().size(); i++)
        {
            refreshArray[i]=GUIMethods.getTrain().get(i).getTrainName();
            //System.out.println(tempArray[i]);
        }
        trainListInfoPanel.setListData(refreshArray);
        trainListInfoPanel.revalidate();
        trainListInfoPanel.repaint();
    }

    private void trainComponents(int index)
    {
        trainContentInfoPanel.setText("");
        String[] printString=GUIMethods.getTrain().get(index).trainCars();
        for (int i = 0; i < printString.length; i++)
        {
            trainContentInfoPanel.append(printString[i]+"\n");
        }
    }
}
