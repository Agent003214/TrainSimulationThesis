package GUI;

import javax.swing.*;
import java.awt.*;

public class TrainGUI extends JFrame
{
    private final CardLayout cardLayout;
    private final JPanel mainPane;

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
        ImageIcon icon=new ImageIcon("./TrainSimulationThesis/src/main/resources/Locomotives/Electric/V63/V63Side.png");
        setIconImage(icon.getImage());

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
        buttonPanel.setPreferredSize(new Dimension(100, 33));
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
