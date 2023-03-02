package GUI;

import Attachables.Attachable;
import Attachables.CargoContainer.LongContainer;
import Attachables.CargoContainer.ShortContainer;
import Attachables.CargoContainer.TankContainer;
import Attachables.CargoWagon.*;
import Attachables.PassengerCar.Car;
import Factories.CompoundTrain;
import Factories.Train;
import TrainEngines.Diesel.DieselLocomotive;
import TrainEngines.Electric.ElectricLocomotive;
import TrainEngines.Locomotive;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CreateTrainPage extends JPanel
{
    private final CardLayout cardLayout;
    GridBagLayout gridBagLayout;
    GridBagConstraints c;
    private JList<String> locomotiveList;
    private JList<String> attachableList;
    private locoFilter locoFilterVar;
    private JTextArea locoAttachableInfoPanel;
    private MethodClass GUIMethods=new MethodClass();
    private JButton showAttachableButton;
    private JTextArea trainInfoPanel;
    private JTextField setNameTextField;
    private static ArrayList<CompoundTrain> tempTrain=new ArrayList<>();
    private JButton addLocomotiveButton;
    private JButton addAttachableButton;
    private CTPImageDraw drawBottomImage=new CTPImageDraw();
    private JScrollPane drawSP;


    private enum locoFilter
    {
        ALL, ELECTRIC, DIESEL
    }

    private attachableFilter attachableFilterVar;

    private enum attachableFilter
    {
        ALL, CAR, TANK, CONTAINER, BOX
    }
    public CreateTrainPage()
    {
        setBackground(Color.RED);
        gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        cardLayout = new CardLayout();

        //Create top panel
        GridBagConstraints c = new GridBagConstraints();
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(dim.width, ((dim.height / 3) * 2) - 20));
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new GridLayout(1, 3));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        add(topPanel,c);

        //Top left panel
        JPanel addSelectorTopPanel = new JPanel();
        addSelectorTopPanel.setLayout(cardLayout);
        JPanel addLocomotivePanel = new JPanel();
        addLocomotivePanel.setLayout(new BorderLayout());
        locomotiveList = new JList<>(locomotives());
        addLocomotiveButton = new JButton("Add locomotive");
        addLocomotivePanel.add(locomotiveList, BorderLayout.CENTER);
        addLocomotivePanel.add(addLocomotiveButton, BorderLayout.SOUTH);
        addLocomotiveButton.setEnabled(false);
        addLocomotiveButton.addActionListener(e -> addLoco());


        JPanel addAttachablePanel = new JPanel();
        addAttachablePanel.setLayout(new BorderLayout());
        attachableList = new JList<>(attachables());
        addAttachableButton = new JButton("Add attachable");
        addAttachablePanel.add(attachableList, BorderLayout.CENTER);
        addAttachablePanel.add(addAttachableButton, BorderLayout.SOUTH);
        Font listFont = new Font(locomotiveList.getFont().getFontName(), locomotiveList.getFont().getStyle(), 22);
        locomotiveList.setFont(GUIMethods.getFont());
        attachableList.setFont(GUIMethods.getFont());
        addAttachableButton.setEnabled(false);
        addAttachableButton.addActionListener(e -> addAttachable());

        locoFilterVar = locoFilter.ALL;

        addSelectorTopPanel.add("locomotiveSelect", addLocomotivePanel);
        addSelectorTopPanel.add("attachableSelect", addAttachablePanel);

        topPanel.add(addSelectorTopPanel);

        //Create top middle Panel
        JPanel modifierPanel=new JPanel(new BorderLayout());
        JPanel modifierMiddlePanel=new JPanel();
        JPanel selectorButtonPanel = new JPanel();
        selectorButtonPanel.setLayout(new GridBagLayout());
        selectorButtonPanel.setBackground(Color.BLUE);
        JButton createNewTrainButton=new JButton("Create new train / Reset current train");
        modifierPanel.add(createNewTrainButton,BorderLayout.NORTH);
        createNewTrainButton.addActionListener(e -> createNewTrain());

        setNameTextField=new JTextField();
        setNameTextField.setPreferredSize(new Dimension(100,20));
        modifierPanel.add(modifierMiddlePanel,BorderLayout.CENTER);
        modifierMiddlePanel.add(setNameTextField);

        c = new GridBagConstraints();
        JButton showLocoButton = new JButton("Locomotives");
        showAttachableButton = new JButton("Cars/Wagons");
        JButton saveTrainButton=new JButton("Save train");
        modifierPanel.add(saveTrainButton,BorderLayout.SOUTH);
        saveTrainButton.addActionListener(e -> saveTrain());
        topPanel.add(modifierPanel);
        //topPanel.add(selectorButtonPanel);
        modifierMiddlePanel.add(selectorButtonPanel);
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
        topPanel.add(infoPanel);
        //infoPanel.setLayout(new BorderLayout());
        infoPanel.setLayout(new GridLayout(2,1));
        locoAttachableInfoPanel = new JTextArea();
        locoAttachableInfoPanel.setFont(listFont);
        locoAttachableInfoPanel.setEditable(false);
        JScrollPane locoAttachableInfoPanelSP=new JScrollPane(locoAttachableInfoPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        trainInfoPanel=new JTextArea();
        trainInfoPanel.setFont(listFont);
        trainInfoPanel.setEditable(false);
        Border border=BorderFactory.createMatteBorder(1,0,0,0,Color.BLACK);
        trainInfoPanel.setBorder(border);
        JScrollPane trainInfoPanelSP=new JScrollPane(trainInfoPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoPanel.add(locoAttachableInfoPanelSP);
        infoPanel.add(trainInfoPanelSP);
        //infoPanel.add(locoAttachableInfoPanel, BorderLayout.CENTER);

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
        JPanel createTrainPageBottomPanel=new JPanel();
        createTrainPageBottomPanel.setBackground(Color.YELLOW);
        createTrainPageBottomPanel.setPreferredSize(new Dimension(dim.width, ((dim.height) / 3) - 20));

        JPanel imageDrawPanel=drawBottomImage;
        imageDrawPanel.setPreferredSize(new Dimension(30000, ((dim.height) / 3) - 20));
        drawSP=new JScrollPane(imageDrawPanel);
        drawSP.setPreferredSize(new Dimension(dim.width, ((dim.height) / 3) - 20));
        drawSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        drawSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        createTrainPageBottomPanel.add(drawSP);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(createTrainPageBottomPanel, c);



        /*JPanel createTrainPageBottomPanel = drawBottomImage;
        //createTrainPageBottomPanel.setBackground(Color.YELLOW);
        //createTrainPageBottomPanel.setPreferredSize(new Dimension(dim.width, ((dim.height) / 3) - 20));
        drawSP=new JScrollPane(createTrainPageBottomPanel);
        //drawSP.setPreferredSize(new Dimension(800,600));
        drawSP.setPreferredSize(new Dimension(dim.width, ((dim.height) / 3) - 20));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        //add(createTrainPageBottomPanel, c);
        drawSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        drawSP.setViewportView(createTrainPageBottomPanel);
        add(drawSP,c);*/


    }

    private void createNewTrain()
    {
        tempTrain=new ArrayList<>();
        tempTrain.add(new CompoundTrain());
        addLocomotiveButton.setEnabled(true);
        addAttachableButton.setEnabled(true);
        trainInfoPanel.setText("");
        updateNameTextField();
        drawBottomImage.resetImages();
        drawSP.repaint();
    }

    private void saveTrain()
    {
        if (tempTrain.get(0).getTrainLenght()!=0)
        {
            tempTrain.get(tempTrain.size()-1).setTrainName(setNameTextField.getText());
            GUIMethods.createTrain(tempTrain.get(tempTrain.size()-1));
        }
    }


    private void updateNameTextField()
    {
        setNameTextField.setText("Train " + (GUIMethods.getTrain().size()+1));
        /*if (GUIMethods.getTrain().size()==0)
        {
            setNameTextField.setText("Train 0");
        }
        else
        {
            setNameTextField.setText("Train " + (GUIMethods.getTrain().size()-1));
        }*/

    }



    private void printCurrentTrain()
    {
        /*trainInfoPanel.setText("");
        trainInfoPanel.append(tempTrain.toString()+"\n");*/
        trainInfoPanel.setText("");
        /*trainInfoPanel.append("Combined locomotive power: "+tempTrain.get(tempTrain.size()-1).getCombinedPower()+"\n");
        trainInfoPanel.append("Number of cars: "+tempTrain.get(tempTrain.size()-1).getNumbersOfCars()+"\n");
        trainInfoPanel.append("Total passenger capacity: "+tempTrain.get(tempTrain.size()-1).getPassengerCapacityCount()+"\n");*/
        trainInfoPanel.append("Combined locomotive power: "+tempTrain.get(0).getCombinedPower()+"\n");
        trainInfoPanel.append("Number of cars: "+tempTrain.get(0).getNumbersOfCars()+"\n");
        trainInfoPanel.append("Total passenger capacity: "+tempTrain.get(0).getPassengerCapacityCount()+"\n");
        //trainInfoPanel.append("Total box wagon capacity: "+GUIMethods.getCurrentTrain().getBoxWagonCapacityCount()+" kg\n");
    }

    private void addLoco()
    {
        //GUIMethods.getLocomotivesArrayList().get(locomotiveList.getSelectedIndex()).getImageLarge();
        tempTrain.get(0).add((Train) GUIMethods.getLocomotivesArrayList().get(locomotiveList.getSelectedIndex()));
        drawBottomImage.addTrainImage(tempTrain.get(0).drawImage(tempTrain.get(0).getTrainLenght()-1));
        drawSP.repaint();
        /*try
        {
            for (int i = 0; i < GUIMethods.getLocomotivesArrayList().size(); i++)
            {
                if (locomotiveList.getSelectedValue().equals(GUIMethods.getLocomotivesArrayList().get(i).getModelName()))
                {
                    if (GUIMethods.getLocomotivesArrayList().get(i) instanceof Locomotive)
                    {
                        //GUIMethods.train.get(GUIMethods.train.size()-1).add((Train) GUIMethods.getLocomotivesArrayList().get(i));
                        //GUIMethods.getLatestTrain().add((Train) GUIMethods.getLocomotivesArrayList().get(i));
                        tempTrain.get(0).add((Train) GUIMethods.getLocomotivesArrayList().get(i));
                        drawBottomImage.addTrainImage(tempTrain.size()-1,tempTrain.get(0).drawImage(tempTrain.get(0).getTrainLenght()-1));
                        drawSP.repaint();
                    }
                }
            }
            showAttachableButton.setEnabled(true);
        }
        catch (NullPointerException e)
        {

        }*/
        printCurrentTrain();
        /*GUIMethods.printCurrentTrain();
        GUIMethods.printTest();*/
    }

    private void addAttachable()
    {
        tempTrain.get(tempTrain.size()-1).add((Train) GUIMethods.getAttachableArrayList().get(attachableList.getSelectedIndex()));
        drawBottomImage.addTrainImage(tempTrain.get(0).drawImage(tempTrain.get(0).getTrainLenght()-1));
        drawSP.repaint();
        /*try
        {
            for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
            {
                if (attachableList.getSelectedValue().equals(GUIMethods.getAttachableArrayList().get(i).getName()))
                {
                    //GUIMethods.train.get(GUIMethods.train.size()-1).add((Train) getAttachableArrayList().get(i));
                    //GUIMethods.getLatestTrain().add((Train) getAttachableArrayList().get(i));
                    tempTrain.get(tempTrain.size()-1).add((Train) GUIMethods.getAttachableArrayList().get(i));
                }
            }
        }
        catch (NullPointerException e)
        {

        }*/
        printCurrentTrain();
        //GUIMethods.printCurrentTrain();
    }

    private DefaultListModel<String> locomotives()
    {
        ArrayList<Locomotive> locomotiveList = GUIMethods.getLocomotivesArrayList();

        DefaultListModel<String> locoDefaultList = new DefaultListModel<>();

        for (Locomotive locomotive : locomotiveList)
        {
            locoDefaultList.addElement(locomotive.getModelName());
        }
        return locoDefaultList;
    }



    private DefaultListModel<String> attachables()
    {
        //ArrayList<Attachable> attachableList = getAttachableArrayList();
        ArrayList<Attachable> attachableList= GUIMethods.getAttachableArrayList();
        DefaultListModel<String> locoDefaultList = new DefaultListModel<>();
        for (Attachable attachable : attachableList)
        {
            locoDefaultList.addElement(attachable.getName());
        }
        return locoDefaultList;
    }

    /*private ArrayList<Attachable> getAttachableArrayList()
    {
        ArrayList<Attachable> attachableList = new ArrayList<>();
        attachableList.add(new InterCityPlus());
        attachableList.add(new Mark3());
        attachableList.add(new BoxWagon());
        attachableList.add(new HopperWagon());
        attachableList.add(new TankWagon());
        attachableList.add(new RLMMPS651FlatWagon());
        return attachableList;
    }*/

    private void showLocomotiveList(JPanel listPanel, JPanel buttonPanel)
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
            case ALL ->
            {
                for (int i = 0; i < GUIMethods.getLocomotivesArrayList().size(); i++)
                {
                    tempArray.add(GUIMethods.getLocomotivesArrayList().get(i).getModelName());
                }
            }
            case DIESEL ->
            {
                for (int i = 0; i < GUIMethods.getLocomotivesArrayList().size(); i++)
                {
                    if (GUIMethods.getLocomotivesArrayList().get(i) instanceof DieselLocomotive)
                    {
                        tempArray.add(GUIMethods.getLocomotivesArrayList().get(i).getModelName());
                    }
                }
            }
            case ELECTRIC ->
            {
                for (int i = 0; i < GUIMethods.getLocomotivesArrayList().size(); i++)
                {
                    if (GUIMethods.getLocomotivesArrayList().get(i) instanceof ElectricLocomotive)
                    {
                        tempArray.add(GUIMethods.getLocomotivesArrayList().get(i).getModelName());
                    }
                }
            }
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
        attachableFilterVar= attachableFilter.CAR;
        attachableListData();
    }

    private void setBoxAttachableEnum()
    {
        attachableFilterVar= attachableFilter.BOX;
        attachableListData();
    }

    private void setTankAttachableEnum()
    {
        attachableFilterVar= attachableFilter.TANK;
        attachableListData();
    }

    private void setContainerAttachableEnum()
    {
        attachableFilterVar= attachableFilter.CONTAINER;
        attachableListData();
    }
    private void setAllAttachableEnum()
    {
        attachableFilterVar= attachableFilter.ALL;
        attachableListData();
    }

    private String[] attachableListData()
    {
        ArrayList<String> tempArray = new ArrayList<>();
        switch (attachableFilterVar)
        {
            case ALL:
                for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
                {
                    tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
                }
                break;
            case CAR:
                for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
                {
                    if (GUIMethods.getAttachableArrayList().get(i) instanceof Car)
                    {
                        tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
                    }
                }
                break;
            case BOX:
                for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
                {
                    if (GUIMethods.getAttachableArrayList().get(i).getType().contains("Box")||GUIMethods.getAttachableArrayList().get(i).getType().contains("Grain"))
                    {
                        tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
                    }
                }
                break;
            case TANK:
                for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
                {
                    if (GUIMethods.getAttachableArrayList().get(i).getType().contains("Fluid"))
                    {
                        tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
                    }
                    if (GUIMethods.getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
                    {
                        if (((RLMMPS651FlatWagon) GUIMethods.getAttachableArrayList().get(i)).getCargo() instanceof TankContainer)
                        {
                            tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
                        }
                    }
                }
                break;
            case CONTAINER:
                for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
                {
                    if (GUIMethods.getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
                    {
                        if (((RLMMPS651FlatWagon) GUIMethods.getAttachableArrayList().get(i)).getCargo() instanceof LongContainer)
                        {
                            tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
                        }
                        if (((RLMMPS651FlatWagon) GUIMethods.getAttachableArrayList().get(i)).getCargo() instanceof ShortContainer)
                        {
                            tempArray.add(GUIMethods.getAttachableArrayList().get(i).getName());
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

    private void locoTextPanel()
    {
        locoAttachableInfoPanel.setText("");

        for (int i = 0; i < GUIMethods.getLocomotivesArrayList().size(); i++)
        {
            if (locomotiveList.getSelectedValue().equals(GUIMethods.getLocomotivesArrayList().get(i).getModelName()))
            {
                locoAttachableInfoPanel.append("Maker name: " + GUIMethods.getLocomotivesArrayList().get(i).getMakerName() + "\n");
                locoAttachableInfoPanel.append("Model name: " + GUIMethods.getLocomotivesArrayList().get(i).getModelName() + "\n");
                locoAttachableInfoPanel.append("Type: " + GUIMethods.getLocomotivesArrayList().get(i).getType() + "\n");
                if (GUIMethods.getLocomotivesArrayList().get(i) instanceof ElectricLocomotive)
                {
                    locoAttachableInfoPanel.append("Power: " + GUIMethods.getLocomotivesArrayList().get(i).getPower() + " kW\n");
                }
                if (GUIMethods.getLocomotivesArrayList().get(i) instanceof DieselLocomotive)
                {
                    locoAttachableInfoPanel.append("Power: " + GUIMethods.getLocomotivesArrayList().get(i).getPower() + " HP\n");
                }
                locoAttachableInfoPanel.append("Max speed: " + GUIMethods.getLocomotivesArrayList().get(i).getMaxSpeed() + " KP/H\n");
                locoAttachableInfoPanel.append("Weight: " + GUIMethods.getLocomotivesArrayList().get(i).getWeight() + " Kg\n");
            }
        }
    }

    private void attachableTextPanel()
    {
        locoAttachableInfoPanel.setText("");
        for (int i = 0; i < GUIMethods.getAttachableArrayList().size(); i++)
        {
            if (attachableList.getSelectedValue().equals(GUIMethods.getAttachableArrayList().get(i).getName()))
            {
                locoAttachableInfoPanel.append("Name: " + GUIMethods.getAttachableArrayList().get(i).getName() + "\n");
                locoAttachableInfoPanel.append("Type: " + GUIMethods.getAttachableArrayList().get(i).getType() + "\n");
                if (GUIMethods.getAttachableArrayList().get(i) instanceof Car)
                {
                    locoAttachableInfoPanel.append("Capacity: " + GUIMethods.getAttachableArrayList().get(i).getCapacity() + " Passenger\n");
                }
                if (GUIMethods.getAttachableArrayList().get(i) instanceof Wagon)
                {
                    locoAttachableInfoPanel.append("Capacity: " + GUIMethods.getAttachableArrayList().get(i).getCapacity() + " t\n");
                }
                if (GUIMethods.getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
                {
                    locoAttachableInfoPanel.append("Possible cargo: \n");
                    for (int j = 0; j < GUIMethods.getCargoArrayList().size(); j++)
                    {
                        locoAttachableInfoPanel.append("\t"+GUIMethods.getCargoArrayList().get(j).getName()+"\n");
                    }
                }
                locoAttachableInfoPanel.append("Max speed: " + GUIMethods.getAttachableArrayList().get(i).getMaxSpeed()+" KP/H");
            }
        }
    }
}
