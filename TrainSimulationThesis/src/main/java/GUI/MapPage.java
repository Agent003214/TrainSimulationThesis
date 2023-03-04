package GUI;

import Attachables.Cargo.Passenger;
import Routes.Routes;
import Tiles.RailTiles.NonElectrified.*;
import Tiles.RailTiles.RailPlatformTileEW;
import Tiles.Scenery.GrassTile;
import Tiles.Scenery.WaterTile;
import Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.chrono.IsoEra;
import java.util.ArrayList;

public class MapPage extends JPanel
{
    private MethodClass GUIMethods = new MethodClass();
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
    private JList<String> trainListInfoPanel;
    private JTextArea trainContentInfoPanel;
    private ArrayList<Routes> routes;
    private MapPanel map = new MapPanel();
    private JTextArea stationsInfo;
    //private TrainDispatcher dispatcher=new TrainDispatcher();

    public MapPage()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(dim);
        gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        c = new GridBagConstraints();

        //Left side panels
        JPanel trainPanel = new JPanel();
        trainPanel.setLayout(new GridLayout(2, 1));
        JPanel trainPanelTop = new JPanel();
        trainPanelTop.setLayout(new BorderLayout());
        //JPanel trainPanelBottom=new JPanel();

        trainListInfoPanel = new JList<>(new DefaultListModel<>());
        trainListInfoPanel.setFont(GUIMethods.getFont());
        trainPanelTop.add(trainListInfoPanel, BorderLayout.CENTER);
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refresh());
        trainPanelTop.add(refreshButton, BorderLayout.SOUTH);
        trainPanel.add(trainPanelTop);

        trainListInfoPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                JList list = (JList) e.getSource();
                trainComponents(list.getSelectedIndex());
            }
        });

        trainContentInfoPanel = new JTextArea();
        trainContentInfoPanel.setEditable(false);
        trainContentInfoPanel.setFont(GUIMethods.getFont());
        trainPanel.add(trainContentInfoPanel);

        /*trainPanel.add(trainPanelTop);
        trainPanel.add(trainPanelBottom);*/

        trainPanel.setPreferredSize(new Dimension(300, 1040));
        c.gridx = 0;
        c.gridy = 0;
        add(trainPanel, c);

        //Middle map panel

        JPanel mapPanel = map;
        mapPanel.setPreferredSize(new Dimension(1920 - 600, 1040));
        c.gridx = 1;
        c.gridy = 0;
        add(mapPanel, c);

        //Right side panels
        JPanel stopsPanel = new JPanel();
        stopsPanel.setLayout(new GridLayout(2, 1));

        JPanel routePanel=new JPanel();
        routePanel.setLayout(new BorderLayout());

        JPanel stationsPanel=new JPanel();
        stationsPanel.setLayout(new BorderLayout());

        //ArrayList<Station> stations=new ArrayList<>();

        routes = new ArrayList<>();
        int[] start = {1, 5};
        int[] stop = {5, 5};
        GUIMethods.addStation(start,"A",300,new Passenger());
        GUIMethods.addStation(stop,"B",10,new Passenger());
        //stations.add(new Station(start,"A",150,1));
        //stations.add(new Station(stop,"B",10,1));
        Tile[][] line = new Tile[][]
                {
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new RailPlatformTileEW(), new RailTileEW(), new RailTileEW(), new RailTileEW(), new RailPlatformTileEW(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new WaterTile(), new WaterTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new WaterTile(), new WaterTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()}
                };
        //routes.add(new Routes(start, stop, "Route 1 ϟ", line, true));
        routes.add(new Routes(GUIMethods.getStations().get(0), GUIMethods.getStations().get(1), "Route 1 ϟ", line,1,0, true));

        int[] stop2 = {5, 3};
        GUIMethods.addStation(stop2,"C",10,new Passenger());
        //stations.add(new Station(stop2,"C",10,1));
        Tile[][] line2 = new Tile[][]
                {
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new RailTileSE(), new RailTileEW(), new RailPlatformTileEW(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new RailTileNS(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new RailPlatformTileEW(), new RailTileEW(), new RailTileNW(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new WaterTile(), new WaterTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()},
                        {new GrassTile(), new WaterTile(), new WaterTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile(), new GrassTile()}
                };
        //routes.add(new Routes(start, stop2, "Route 2", line2, false));
        routes.add(new Routes(GUIMethods.getStations().get(0), GUIMethods.getStations().get(2), "Route 2", line2,1,0, false));

        DefaultListModel<String> stopDLM = new DefaultListModel<>();
        for (int i = 0; i < routes.size(); i++)
        {
            stopDLM.addElement(routes.get(i).getRouteName());
        }
        //stopDLM.addElement("A -> B");
        //stopDLM.addElement("A -> C");
        JList<String> stopList = new JList<>(stopDLM);
        stopList.setFont(GUIMethods.getFont());

        stopList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                JList list = (JList) e.getSource();
                map.setGlowPlatform(list.getSelectedIndex());
            }
        });

        routePanel.add(stopList,BorderLayout.CENTER);
        //stopsPanel.setLayout(new BorderLayout());
        //stopsPanel.add(stopList, BorderLayout.CENTER);

        JButton sendTrainButton = new JButton("Send train");
        routePanel.add(sendTrainButton, BorderLayout.SOUTH);

        stationsInfo=new JTextArea();
        stationsInfo.setFont(GUIMethods.getFont());
        stationsInfo.setEditable(false);
        stationsPanel.add(stationsInfo);
        stationInfo();
        //stationsPanel.add(stationsInfo,BorderLayout.CENTER);
        //sendTrainButton.addActionListener(e -> sendTrain());
        //sendTrainButton.addActionListener(e -> map.send(routes.get(stopList.getSelectedIndex()), trainListInfoPanel.getSelectedIndex()));
        sendTrainButton.addActionListener(e ->
        {
            try
            {
                sendTrainButton.setEnabled(false);
                Thread thread = new Thread(() ->{});
                map.send(routes.get(stopList.getSelectedIndex()), trainListInfoPanel.getSelectedIndex(), thread);
                thread.join();
                sendTrainButton.setEnabled(true);
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex.getMessage());
            }
        });

        stopsPanel.add(routePanel);
        stopsPanel.add(stationsPanel);
        stopsPanel.setPreferredSize(new Dimension(300, 1040));
        stopsPanel.setBackground(Color.orange);
        c.gridx = 2;
        c.gridy = 0;
        add(stopsPanel, c);
    }

    /*private void sendTrain()
    {
        dispatcher.sendTrain(map,routes.get(0),GUIMethods.getTrain().get(0));
    }*/

    private void refresh()
    {
        String[] refreshArray = new String[GUIMethods.getTrain().size()];
        for (int i = 0; i < GUIMethods.getTrain().size(); i++)
        {
            refreshArray[i] = GUIMethods.getTrain().get(i).getTrainName();
            //System.out.println(tempArray[i]);
        }
        trainListInfoPanel.setListData(refreshArray);
        trainListInfoPanel.revalidate();
        trainListInfoPanel.repaint();
    }

    private void trainComponents(int index)
    {
        trainContentInfoPanel.setText("");
        String[] printString = GUIMethods.getTrain().get(index).trainCars();
        for (int i = 0; i < printString.length; i++)
        {
            trainContentInfoPanel.append(printString[i] + "\n");
        }
    }

    private void stationInfo()
    {
        stationsInfo.setText("");
        for (int i = 0; i < GUIMethods.getStations().size(); i++)
        {
            stationsInfo.append("Station name: "+GUIMethods.getStations().get(i).getName());
            stationsInfo.append("\n    Cargo type: "+GUIMethods.getStations().get(i).getCargoType().getName());
            stationsInfo.append("\n    Max capacity: "+GUIMethods.getStations().get(i).getMaxCapacity());
            stationsInfo.append("\n");
        }
    }
}
