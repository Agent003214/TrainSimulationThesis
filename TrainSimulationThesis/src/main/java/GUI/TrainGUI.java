package GUI;

import javax.swing.*;
import java.awt.*;

public class TrainGUI extends JFrame
{
    private final CardLayout cardLayout;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
    private JList<String> locomotiveList;
    private JList<String> attachableList;
    private JTextArea locoAttachableInfoPanel;
    private final JPanel mainPane;
    private locoFilter locoFilterVar;

    private enum locoFilter
    {
        ALL, ELECTRIC, DIESEL
    }

    private attachableFilter attachableFilterVar;

    private enum attachableFilter
    {
        ALL, CAR, TANK, CONTAINER, BOX
    }


    public TrainGUI()
    {
        //https://techhelpnotes.com/swing-java-gui-switching-between-panels-on-button-click-2/

        setTitle("Train");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPane = new JPanel();
        cardLayout = new CardLayout();
        mainPane.setLayout(cardLayout);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon icon=new ImageIcon("./src/main/resources/Locomotives/V63Side.png");
        setIconImage(icon.getImage());


        //Create the train creation page
        //JPanel createTrainPage = new JPanel();
        /*createTrainPage.setBackground(Color.RED);
        gridBagLayout = new GridBagLayout();
        createTrainPage.setLayout(gridBagLayout);*/

        //Create top panel
        /*GridBagConstraints c = new GridBagConstraints();
        JPanel createTrainPageTopPanel = new JPanel();
        createTrainPageTopPanel.setPreferredSize(new Dimension(dim.width, ((dim.height / 3) * 2) - 20));
        createTrainPageTopPanel.setBackground(Color.WHITE);
        createTrainPageTopPanel.setLayout(new GridLayout(1, 3));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        createTrainPage.add(createTrainPageTopPanel, c);*/

        //Create add locomotive panels
        //Top left panel
        /*JPanel addSelectorTopPanel = new JPanel();
        addSelectorTopPanel.setLayout(cardLayout);
        JPanel addLocomotivePanel = new JPanel();
        addLocomotivePanel.setLayout(new BorderLayout());*/
        /*JList<String>*/
       /* locomotiveList = new JList<>(locomotives());
        JButton addLocomotiveButton = new JButton("Add locomotive");
        addLocomotivePanel.add(locomotiveList, BorderLayout.CENTER);
        addLocomotivePanel.add(addLocomotiveButton, BorderLayout.SOUTH);

        JPanel addAttachablePanel = new JPanel();
        addAttachablePanel.setLayout(new BorderLayout());
        attachableList = new JList<>(attachables());
        JButton addAttachableButton = new JButton("Add attachable");
        addAttachablePanel.add(attachableList, BorderLayout.CENTER);
        addAttachablePanel.add(addAttachableButton, BorderLayout.SOUTH);
        Font listFont = new Font(locomotiveList.getFont().getFontName(), locomotiveList.getFont().getStyle(), 22);
        locomotiveList.setFont(listFont);
        attachableList.setFont(listFont);

        locoFilterVar = locoFilter.ALL;

        addSelectorTopPanel.add("locomotiveSelect", addLocomotivePanel);
        addSelectorTopPanel.add("attachableSelect", addAttachablePanel);

        createTrainPageTopPanel.add(addSelectorTopPanel);


        //Create top middle Panel
        JPanel selectorButtonPanel = new JPanel();
        selectorButtonPanel.setLayout(new GridBagLayout());
        selectorButtonPanel.setBackground(Color.BLUE);
        c = new GridBagConstraints();
        JButton showLocoButton = new JButton("Locomotives");
        JButton showAttachableButton = new JButton("Cars/Wagons");
        createTrainPageTopPanel.add(selectorButtonPanel);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        selectorButtonPanel.add(showLocoButton, c);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        selectorButtonPanel.add(showAttachableButton, c);
        JPanel filterButtonPanel = new JPanel();
        filterButtonPanel.setLayout(cardLayout);
        JPanel locomotiveFilterButtonPanel = new JPanel();
        locomotiveFilterButtonPanel.setLayout(new GridLayout(2, 2));
        JButton electricLocomotiveFilterButton = new JButton("Electric");
        JButton dieselLocomotiveFilterButton = new JButton("Diesel");
        JButton locomotiveRemoveFilterButton = new JButton("All");
        locomotiveFilterButtonPanel.add(electricLocomotiveFilterButton);
        locomotiveFilterButtonPanel.add(dieselLocomotiveFilterButton);
        locomotiveFilterButtonPanel.add(locomotiveRemoveFilterButton);

        JPanel attachableFilterButtonPanel = new JPanel();
        attachableFilterButtonPanel.setLayout(new GridLayout(3, 2));
        JButton carFilterButton = new JButton("Passener cars");
        JButton fluidTankFilterButton = new JButton("Fluid tank");
        JButton intermodelContainerFilterButton = new JButton("Container");
        JButton looseBulkFilterButton = new JButton("Grain/ore");
        JButton attachableRemoveFilterButton = new JButton("All");

        attachableFilterButtonPanel.add(carFilterButton);
        attachableFilterButtonPanel.add(fluidTankFilterButton);
        attachableFilterButtonPanel.add(intermodelContainerFilterButton);
        attachableFilterButtonPanel.add(looseBulkFilterButton);
        attachableFilterButtonPanel.add(attachableRemoveFilterButton);

        filterButtonPanel.add("locomotiveFilter", locomotiveFilterButtonPanel);
        filterButtonPanel.add("attachableFilter", attachableFilterButtonPanel);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.gridheight = 2;
        selectorButtonPanel.add(filterButtonPanel, c);

        showLocoButton.addActionListener(e -> showLocomotiveList(addSelectorTopPanel, filterButtonPanel));
        showAttachableButton.addActionListener(e -> showAttachableList(addSelectorTopPanel, filterButtonPanel));

        electricLocomotiveFilterButton.addActionListener(e -> setElectricLocomotiveEnum());
        dieselLocomotiveFilterButton.addActionListener(e -> setDieselLocomotiveEnum());
        locomotiveRemoveFilterButton.addActionListener(e -> setAllLocomotiveEnum());

        carFilterButton.addActionListener(e -> setCarAttachableEnum());
        fluidTankFilterButton.addActionListener(e -> setTankAttachableEnum());
        intermodelContainerFilterButton.addActionListener(e -> setContainerAttachableEnum());
        looseBulkFilterButton.addActionListener(e -> setBoxAttachableEnum());
        attachableRemoveFilterButton.addActionListener(e ->setAllAttachableEnum());

        //create top right panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.magenta);
        createTrainPageTopPanel.add(infoPanel);
        infoPanel.setLayout(new BorderLayout());
        locoAttachableInfoPanel = new JTextArea();
        locoAttachableInfoPanel.setFont(listFont);
        infoPanel.add(locoAttachableInfoPanel, BorderLayout.CENTER);

        locomotiveList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                locoTextPanel();
            }
        });

        attachableList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                attachableTextPanel();
            }
        });


        //Create bottom panel
        JPanel createTrainPageBottomPanel = new JPanel();
        createTrainPageBottomPanel.setBackground(Color.YELLOW);
        createTrainPageBottomPanel.setPreferredSize(new Dimension(dim.width, ((dim.height) / 3) - 20));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        createTrainPage.add(createTrainPageBottomPanel, c);*/


        JPanel p2 = new JPanel();
        p2.setBackground(Color.GREEN);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.BLUE);

        MapPage trainMap=new MapPage();

        mainPane.add("createTrainPage", new CreateTrainPage());
        mainPane.add("viewTrainPage", new ViewTrainsPage());
        mainPane.add("mapPage", trainMap);
        //trainMap.startGameThread();


        Container pane = this.getContentPane();
        pane.add(mainPane, BorderLayout.CENTER);
        JButton button1 = new JButton("Create train");
        button1.addActionListener(e -> cardLayout.show(mainPane, "createTrainPage"));
        JButton button2 = new JButton("View trains");
        button2.addActionListener(e -> cardLayout.show(mainPane, "viewTrainPage"));
        JButton button3 = new JButton("Map");
        button3.addActionListener(e -> cardLayout.show(mainPane, "mapPage"));
        JButton button4 = new JButton("Quit");
        button4.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.setPreferredSize(new Dimension(dim.width, 33));
        pane.add(buttonPanel, BorderLayout.SOUTH);

        setUndecorated(true);
        setVisible(true);
    }

    /*private void showLocomotiveList(JPanel listPanel, JPanel buttonPanel)
    {
        cardLayout.show(listPanel, "locomotiveSelect");
        cardLayout.show(buttonPanel, "locomotiveFilter");
        locoAttachableInfoPanel.setText("");
        locomotiveList.clearSelection();
    }

    private void showAttachableList(JPanel listPanel, JPanel buttonpanel)
    {
        cardLayout.show(listPanel, "attachableSelect");
        cardLayout.show(buttonpanel, "attachableFilter");
        locoAttachableInfoPanel.setText("");
        attachableList.clearSelection();
    }

    private void locoTextPanel()
    {
        locoAttachableInfoPanel.setText("");

        for (int i = 0; i < getLocomotivesArrayList().size(); i++)
        {
            if (locomotiveList.getSelectedValue().equals(getLocomotivesArrayList().get(i).getModelName()))
            {
                locoAttachableInfoPanel.append("Maker name: " + getLocomotivesArrayList().get(i).getMakerName() + "\n");
                locoAttachableInfoPanel.append("Model name: " + getLocomotivesArrayList().get(i).getModelName() + "\n");
                locoAttachableInfoPanel.append("Type: " + getLocomotivesArrayList().get(i).getType() + "\n");
                if (getLocomotivesArrayList().get(i) instanceof ElectricLocomotive)
                {
                    locoAttachableInfoPanel.append("Power: " + getLocomotivesArrayList().get(i).getPower() + " kW\n");
                }
                if (getLocomotivesArrayList().get(i) instanceof DieselLocomotive)
                {
                    locoAttachableInfoPanel.append("Power: " + getLocomotivesArrayList().get(i).getPower() + " HP\n");
                }
                locoAttachableInfoPanel.append("Max speed: " + getLocomotivesArrayList().get(i).getMaxSpeed() + " KP/H\n");
                locoAttachableInfoPanel.append("Weight: " + getLocomotivesArrayList().get(i).getWeight() + " Kg\n");
            }
        }
    }

    private void attachableTextPanel()
    {
        locoAttachableInfoPanel.setText("");
        for (int i = 0; i < getAttachableArrayList().size(); i++)
        {
            if (attachableList.getSelectedValue().equals(getAttachableArrayList().get(i).getName()))
            {
                locoAttachableInfoPanel.append("Name: " + getAttachableArrayList().get(i).getName() + "\n");
                locoAttachableInfoPanel.append("Type: " + getAttachableArrayList().get(i).getType() + "\n");
                if (getAttachableArrayList().get(i) instanceof Car)
                {
                    locoAttachableInfoPanel.append("Capacity: " + getAttachableArrayList().get(i).getCapacity() + " Passenger\n");
                }
                if (getAttachableArrayList().get(i) instanceof Wagon)
                {
                    locoAttachableInfoPanel.append("Capacity: " + getAttachableArrayList().get(i).getCapacity() + " t\n");
                }
                if (getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
                {
                    locoAttachableInfoPanel.append("Possible cargo: \n");
                    for (int j = 0; j < getCargoArrayList().size(); j++)
                    {
                        locoAttachableInfoPanel.append("\t"+getCargoArrayList().get(j).getName()+"\n");
                    }
                }
                locoAttachableInfoPanel.append("Max speed: " + getAttachableArrayList().get(i).getMaxSpeed());
            }
        }

    }

    private void setElectricLocomotiveEnum()
    {
        locoFilterVar = locoFilter.ELECTRIC;
        locomotivelistData();
    }

    private void setDieselLocomotiveEnum()
    {
        locoFilterVar = locoFilter.DIESEL;
        locomotivelistData();
    }

    private void setAllLocomotiveEnum()
    {
        locoFilterVar = locoFilter.ALL;
        locomotivelistData();
    }

    private String[] locomotivelistData()
    {

        ArrayList<String> tempArray = new ArrayList<>();
        switch (locoFilterVar)
        {
            case ALL:
                for (int i = 0; i < getLocomotivesArrayList().size(); i++)
                {
                    tempArray.add(getLocomotivesArrayList().get(i).getModelName());
                }
                break;
            case DIESEL:
                for (int i = 0; i < getLocomotivesArrayList().size(); i++)
                {
                    if (getLocomotivesArrayList().get(i) instanceof DieselLocomotive)
                    {
                        tempArray.add(getLocomotivesArrayList().get(i).getModelName());
                    }
                }
                break;
            case ELECTRIC:
                for (int i = 0; i < getLocomotivesArrayList().size(); i++)
                {
                    if (getLocomotivesArrayList().get(i) instanceof ElectricLocomotive)
                    {
                        tempArray.add(getLocomotivesArrayList().get(i).getModelName());
                    }
                }
                break;
        }
        String[] filteredArray = new String[tempArray.size()];
        for (int i = 0; i < tempArray.size(); i++)
        {
            filteredArray[i] = tempArray.get(i);
        }
        locomotiveList.setListData(filteredArray);
        locomotiveList.revalidate();
        locomotiveList.repaint();
        locoAttachableInfoPanel.setText("");
        return filteredArray;
    }

    private void setCarAttachableEnum()
    {
        attachableFilterVar=attachableFilter.CAR;
        attachableListData();
    }

    private void setBoxAttachableEnum()
    {
        attachableFilterVar=attachableFilter.BOX;
        attachableListData();
    }

    private void setTankAttachableEnum()
    {
        attachableFilterVar=attachableFilter.TANK;
        attachableListData();
    }

    private void setContainerAttachableEnum()
    {
        attachableFilterVar=attachableFilter.CONTAINER;
        attachableListData();
    }
    private void setAllAttachableEnum()
    {
        attachableFilterVar=attachableFilter.ALL;
        attachableListData();
    }

    private String[] attachableListData()
    {
        ArrayList<String> tempArray = new ArrayList<>();
        switch (attachableFilterVar)
        {
            case ALL:
                for (int i = 0; i < getAttachableArrayList().size(); i++)
                {
                    tempArray.add(getAttachableArrayList().get(i).getName());
                }
                break;
            case CAR:
                for (int i = 0; i < getAttachableArrayList().size(); i++)
                {
                    if (getAttachableArrayList().get(i) instanceof Car)
                    {
                        tempArray.add(getAttachableArrayList().get(i).getName());
                    }
                }
                break;
            case BOX:
                for (int i = 0; i < getAttachableArrayList().size(); i++)
                {
                    if (getAttachableArrayList().get(i).getType().contains("Box")||getAttachableArrayList().get(i).getType().contains("Grain"))
                    {
                        tempArray.add(getAttachableArrayList().get(i).getName());
                    }
                }
                break;
            case TANK:
                for (int i = 0; i < getAttachableArrayList().size(); i++)
                {
                    if (getAttachableArrayList().get(i).getType().contains("Fluid"))
                    {
                        tempArray.add(getAttachableArrayList().get(i).getName());
                    }
                    if (getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
                    {
                        if (((RLMMPS651FlatWagon) getAttachableArrayList().get(i)).getCargo() instanceof TankContainer)
                        {
                            tempArray.add(getAttachableArrayList().get(i).getName());
                        }
                    }
                }
                break;
            case CONTAINER:
                for (int i = 0; i < getAttachableArrayList().size(); i++)
                {
                    if (getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
                    {
                        if (((RLMMPS651FlatWagon) getAttachableArrayList().get(i)).getCargo() instanceof LongContainer)
                        {
                            tempArray.add(getAttachableArrayList().get(i).getName());
                        }
                        if (((RLMMPS651FlatWagon) getAttachableArrayList().get(i)).getCargo() instanceof ShortContainer)
                        {
                            tempArray.add(getAttachableArrayList().get(i).getName());
                        }
                    }
                }
                break;
        }
        String[] filteredArray = new String[tempArray.size()];
        for (int i = 0; i < tempArray.size(); i++)
        {
            filteredArray[i] = tempArray.get(i);
        }
        attachableList.setListData(filteredArray);
        attachableList.revalidate();
        attachableList.repaint();
        return filteredArray;
    }


    private DefaultListModel<String> locomotives()
    {
        ArrayList<Locomotive> locomotiveList = getLocomotivesArrayList();

        DefaultListModel<String> locoDefaultList = new DefaultListModel<>();

        for (Locomotive locomotive : locomotiveList)
        {
            locoDefaultList.addElement(locomotive.getModelName());
        }
        return locoDefaultList;
    }

    private ArrayList<Locomotive> getLocomotivesArrayList()
    {
        ArrayList<Locomotive> locomotiveList = new ArrayList<>();
        locomotiveList.add(new V63());
        locomotiveList.add(new F40PH());
        locomotiveList.add(new SD70M());
        return locomotiveList;
    }

    private DefaultListModel<String> attachables()
    {
        ArrayList<Attachable> attachableList = getAttachableArrayList();
        DefaultListModel<String> locoDefaultList = new DefaultListModel<>();
        for (Attachable attachable : attachableList)
        {
            locoDefaultList.addElement(attachable.getName());
        }
        return locoDefaultList;
    }

    protected ArrayList<Attachable> getAttachableArrayList()
    {
        ArrayList<Attachable> attachableList = new ArrayList<>();
        attachableList.add(new InterCityPlus());
        attachableList.add(new Mark3());
        attachableList.add(new BoxWagon());
        attachableList.add(new HopperWagon());
        attachableList.add(new TankWagon());
        attachableList.add(new RLMMPS651FlatWagon());
        return attachableList;
    }

    private ArrayList<Cargo> getCargoArrayList()
    {
        ArrayList<Cargo> cargoArrayList=new ArrayList<>();
        cargoArrayList.add(new ShortContainer());
        cargoArrayList.add(new LongContainer());
        cargoArrayList.add(new TankContainer());
        return cargoArrayList;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }*/
}
