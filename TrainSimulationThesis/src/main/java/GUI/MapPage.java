package GUI;

import Attachables.Cargo.Coal;
import Attachables.Cargo.IronOre;
import Attachables.Cargo.Passenger;
import Attachables.Cargo.Steel;
import Routes.Routes;
import Tiles.RailTiles.NonElectrified.*;
import Tiles.RailTiles.RailPlatformTileEW;
import Tiles.RailTiles.RailPlatformTileNS;
import Tiles.Scenery.*;
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

        trainPanel.setPreferredSize(new Dimension((int) (GUIMethods.getDim().getWidth()*0.16), (int) (GUIMethods.getDim().getHeight()-40)));
        c.gridx = 0;
        c.gridy = 0;
        add(trainPanel, c);

        //Middle map panel

        JPanel mapPanel = map;
        JScrollPane scrollMap=new JScrollPane(map);
        //mapPanel.setPreferredSize(new Dimension(1920 - 600, 1040));
        scrollMap.setPreferredSize(new Dimension((int) (GUIMethods.getDim().getWidth()*0.68), (int) (GUIMethods.getDim().getHeight()-40)));
        c.gridx = 1;
        c.gridy = 0;
        add(scrollMap, c);

        //Right side panels
        JPanel stopsPanel = new JPanel();
        stopsPanel.setLayout(new GridLayout(2, 1));

        JPanel routePanel=new JPanel();
        routePanel.setLayout(new BorderLayout());

        JPanel stationsPanel=new JPanel();
        stationsPanel.setLayout(new BorderLayout());

        routes = new ArrayList<>();
        GUIMethods.addStation(new int[]{21,7},"Pass1",800,new Passenger());
        GUIMethods.addStation(new int[]{8,14},"Pass2",150,new Passenger());
        GUIMethods.addStation(new int[]{15,23},"Pass3",80,new Passenger());
        GUIMethods.addStation(new int[]{31,19},"Pass4",80,new Passenger());
        GUIMethods.addStation(new int[]{8,17},"Iron mine",8000,new IronOre());
        GUIMethods.addStation(new int[]{23,9},"Iron",0,new IronOre());
        GUIMethods.addStation(new int[]{31,16},"Coal mine",5000,new Coal());
        GUIMethods.addStation(new int[]{27,7},"Coal",0,new Coal());
        GUIMethods.addStation(new int[]{27,4},"Steel mill",0,new Steel());
        GUIMethods.addStation(new int[]{21,30},"Steel export",0,new Steel());

        Tile[][] line=new Tile[][]
                {
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {}
                };
        routes.add(new Routes(GUIMethods.getStations().get(0), GUIMethods.getStations().get(1), "Route 1 ϟ",line,-1,0,true));
        routes.add(new Routes(GUIMethods.getStations().get(1), GUIMethods.getStations().get(0), "Route 1 ϟ Reverse",line,1,0,true));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailPlatformTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(0),GUIMethods.getStations().get(2), "Route 2 ϟ",line,-1,0,true));
        routes.add(new Routes(GUIMethods.getStations().get(2),GUIMethods.getStations().get(0), "Route 2 ϟ Reverse",line,0,-1,true));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(0), GUIMethods.getStations().get(3), "Route 3 ϟ",line,-1,0,true));
        routes.add(new Routes(GUIMethods.getStations().get(3), GUIMethods.getStations().get(0), "Route 3 ϟ Reverse",line,-1,0,true));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailPlatformTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(1), GUIMethods.getStations().get(2), "Route 4",line,1,0,false));
        routes.add(new Routes(GUIMethods.getStations().get(2), GUIMethods.getStations().get(1), "Route 4 Reverse",line,1,0,false));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailPlatformTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(1), GUIMethods.getStations().get(2), "Route 4 ϟ",line,1,0,true));
        routes.add(new Routes(GUIMethods.getStations().get(2), GUIMethods.getStations().get(1), "Route 4 ϟ Reverse",line,0,-1,true));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(1), GUIMethods.getStations().get(3), "Route 5",line,1,0,false));
        routes.add(new Routes(GUIMethods.getStations().get(3), GUIMethods.getStations().get(1), "Route 5 Reverse",line,-1,0,false));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(1), GUIMethods.getStations().get(3), "Route 5 ϟ",line,1,0,true));
        routes.add(new Routes(GUIMethods.getStations().get(3), GUIMethods.getStations().get(1), "Route 5 ϟ Reverse",line,-1,0,true));

        line=new Tile[][]
                {
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailPlatformTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(2), GUIMethods.getStations().get(3), "Route 6 ϟ",line,0,-1,true));
        routes.add(new Routes(GUIMethods.getStations().get(3), GUIMethods.getStations().get(2), "Route 6 ϟ Reverse",line,-1,0,true));

        line=new Tile[][]
                {
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailPlatformTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileNW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(4), GUIMethods.getStations().get(5), "Iron ϟ",line,1,0,true));
        //.add(new Routes(GUIMethods.getStations().get(5), GUIMethods.getStations().get(4), "Route 7 ϟ Reverse",line,0,1,true));

        line=new Tile[][]
                {
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailPlatformTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileNW(),null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailPlatformTileEW(),null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };
        routes.add(new Routes(GUIMethods.getStations().get(6), GUIMethods.getStations().get(7), "Coal",line,-1,0,false));

        line=new Tile[][]
                {
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileSE(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,new RailPlatformTileNS(),null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNE(),new RailTileEW(),new RailTileEW(),new RailTileSW(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
                        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,new RailTileNS(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
                };

        routes.add(new Routes(GUIMethods.getStations().get(8), GUIMethods.getStations().get(9), "Steel export ϟ",line,0,-1,true));

        DefaultListModel<String> stopDLM = new DefaultListModel<>();
        for (int i = 0; i < routes.size(); i++)
        {
            stopDLM.addElement(routes.get(i).getRouteName());
        }
        //stopDLM.addElement("A -> B");
        //stopDLM.addElement("A -> C");
        JList<String> stopList = new JList<>(stopDLM);
        JScrollPane stopListSP=new JScrollPane(stopList);
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

        routePanel.add(stopListSP,BorderLayout.CENTER);
        //stopsPanel.setLayout(new BorderLayout());
        //stopsPanel.add(stopList, BorderLayout.CENTER);

        JButton sendTrainButton = new JButton("Send train");
        routePanel.add(sendTrainButton, BorderLayout.SOUTH);

        stationsInfo=new JTextArea();
        stationsInfo.setFont(GUIMethods.getFont());
        stationsInfo.setEditable(false);
        JScrollPane stationsInfoSP=new JScrollPane(stationsInfo);
        stationsPanel.add(stationsInfoSP);
        stationInfo();
        //stationsPanel.add(stationsInfo,BorderLayout.CENTER);
        //sendTrainButton.addActionListener(e -> sendTrain());
        //sendTrainButton.addActionListener(e -> map.send(routes.get(stopList.getSelectedIndex()), trainListInfoPanel.getSelectedIndex()));
        sendTrainButton.addActionListener(e ->
        {
            try
            {
                //sendTrainButton.setEnabled(false);
                Thread thread = new Thread(() ->{});
                map.send(routes.get(stopList.getSelectedIndex()), trainListInfoPanel.getSelectedIndex(), thread);
                thread.join();
                //sendTrainButton.setEnabled(true);
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex.getMessage());
            }
            catch (IndexOutOfBoundsException exe)
            {
                JOptionPane.showMessageDialog(this,"Route");
            }
        });

        stopsPanel.add(routePanel);
        stopsPanel.add(stationsPanel);
        stopsPanel.setPreferredSize(new Dimension((int) (GUIMethods.getDim().getWidth()*0.16), (int) (GUIMethods.getDim().getHeight()-40)));
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
