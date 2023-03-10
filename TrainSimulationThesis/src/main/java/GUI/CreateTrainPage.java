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
    private MethodClass GUIMethods = new MethodClass();
    private JButton showAttachableButton;
    private JTextArea trainInfoPanel;
    private JTextField setNameTextField;
    private static ArrayList<CompoundTrain> tempTrain = new ArrayList<>();
    private JButton addLocomotiveButton;
    private JButton addAttachableButton;
    private CTPImageDraw drawBottomImage = new CTPImageDraw();
    private JScrollPane drawSP;
    private JLabel errorLabel;


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
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        cardLayout = new CardLayout();

        //Create top panel
        GridBagConstraints c = new GridBagConstraints();
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(GUIMethods.getDim().width, ((GUIMethods.getDim().height / 3) * 2) - 20));
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new GridLayout(1, 3));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        add(topPanel, c);

        //Top left panel
        JPanel addSelectorTopPanel = new JPanel();
        addSelectorTopPanel.setLayout(cardLayout);
        JPanel addLocomotivePanel = new JPanel();
        addLocomotivePanel.setLayout(new BorderLayout());
        locomotiveList = new JList<>(locomotives());
        addLocomotiveButton = new JButton("Add locomotive");
        addLocomotiveButton.setPreferredSize(new Dimension(100, 30));
        addLocomotivePanel.add(locomotiveList, BorderLayout.CENTER);
        addLocomotivePanel.add(addLocomotiveButton, BorderLayout.SOUTH);
        addLocomotiveButton.setEnabled(false);
        addLocomotiveButton.addActionListener(e -> addLoco());


        JPanel addAttachablePanel = new JPanel();
        addAttachablePanel.setLayout(new BorderLayout());
        attachableList = new JList<>(attachables());
        addAttachableButton = new JButton("Add attachable");
        addAttachableButton.setPreferredSize(new Dimension(100, 30));
        addAttachablePanel.add(attachableList, BorderLayout.CENTER);
        addAttachablePanel.add(addAttachableButton, BorderLayout.SOUTH);
        Font listFont = new Font(locomotiveList.getFont().getFontName(), locomotiveList.getFont().getStyle(), 22);
        locomotiveList.setFont(GUIMethods.getFont());
        attachableList.setFont(GUIMethods.getFont());
        addAttachableButton.setEnabled(false);
        addAttachableButton.addActionListener(e -> addAttachable());

        locoFilterVar = locoFilter.ALL;

        locomotiveList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    addLoco();
                }
            }
        });

        attachableList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    if (e.getClickCount() == 2)
                    {
                        addAttachable();
                    }
                }
                catch (IndexOutOfBoundsException ex)
                {

                }
            }
        });

        addSelectorTopPanel.add("locomotiveSelect", addLocomotivePanel);
        addSelectorTopPanel.add("attachableSelect", addAttachablePanel);

        topPanel.add(addSelectorTopPanel);

        //Create top middle Panel
        JPanel modifierPanel = new JPanel(new BorderLayout());

        JPanel modifierMiddlePanel = new JPanel();
        modifierMiddlePanel.setLayout(new GridBagLayout());
        modifierMiddlePanel.setBackground(Color.ORANGE);

        JPanel selectorButtonPanel = new JPanel();
        selectorButtonPanel.setLayout(new GridBagLayout());
        selectorButtonPanel.setBackground(Color.BLUE);
        JButton createNewTrainButton = new JButton("Create new train / Reset current train");
        createNewTrainButton.setPreferredSize(new Dimension(100, 30));
        modifierPanel.add(createNewTrainButton, BorderLayout.NORTH);
        createNewTrainButton.addActionListener(e -> createNewTrain());

        JLabel trainNameLabel = new JLabel("Name of the train:");
        trainNameLabel.setPreferredSize(new Dimension(150, 20));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 50, 0);
        modifierMiddlePanel.add(trainNameLabel, c);

        setNameTextField = new JTextField();
        setNameTextField.setPreferredSize(new Dimension(150, 20));
        modifierPanel.add(modifierMiddlePanel, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 50, 0);
        modifierMiddlePanel.add(setNameTextField, c);

        c = new GridBagConstraints();
        JButton showLocoButton = new JButton("Locomotives");
        showAttachableButton = new JButton("Cars/Wagons");
        JButton saveTrainButton = new JButton("Save train");

        saveTrainButton.setPreferredSize(new Dimension(100, 30));

        showLocoButton.setPreferredSize(new Dimension(150, 50));
        showAttachableButton.setPreferredSize(new Dimension(150, 50));

        modifierPanel.add(saveTrainButton, BorderLayout.SOUTH);
        saveTrainButton.addActionListener(e -> saveTrain());
        topPanel.add(modifierPanel);
        //topPanel.add(selectorButtonPanel);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets=new Insets(0,0,400,0);
        modifierMiddlePanel.add(selectorButtonPanel, c);

        c = new GridBagConstraints();
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

        electricLocomotiveFilterButton.setPreferredSize(new Dimension(150, 30));
        dieselLocomotiveFilterButton.setPreferredSize(new Dimension(150, 30));
        locomotiveRemoveFilterButton.setPreferredSize(new Dimension(150, 30));

        locomotiveFilterButtonPanel.add(electricLocomotiveFilterButton);
        locomotiveFilterButtonPanel.add(dieselLocomotiveFilterButton);
        locomotiveFilterButtonPanel.add(locomotiveRemoveFilterButton);

        JPanel attachableFilterButtonPanel = new JPanel();
        attachableFilterButtonPanel.setLayout(new GridLayout(2, 2));
        JButton carFilterButton = new JButton("Passener cars");
        //JButton fluidTankFilterButton = new JButton("Fluid tank");
        //JButton intermodelContainerFilterButton = new JButton("Container");
        JButton looseBulkFilterButton = new JButton("Box wagons");
        JButton attachableRemoveFilterButton = new JButton("All");

        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        errorLabel.setText("Error message");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridwidth = 2;
        modifierMiddlePanel.add(errorLabel,c);

        attachableFilterButtonPanel.add(carFilterButton);
        //attachableFilterButtonPanel.add(fluidTankFilterButton);
        //attachableFilterButtonPanel.add(intermodelContainerFilterButton);
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
        //fluidTankFilterButton.addActionListener(e -> setTankAttachableEnum());
        //intermodelContainerFilterButton.addActionListener(e -> setContainerAttachableEnum());
        looseBulkFilterButton.addActionListener(e -> setBoxAttachableEnum());
        attachableRemoveFilterButton.addActionListener(e -> setAllAttachableEnum());


        //create top right panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.magenta);
        topPanel.add(infoPanel);
        //infoPanel.setLayout(new BorderLayout());
        infoPanel.setLayout(new GridLayout(2, 1));
        locoAttachableInfoPanel = new JTextArea();
        locoAttachableInfoPanel.setFont(listFont);
        locoAttachableInfoPanel.setEditable(false);
        JScrollPane locoAttachableInfoPanelSP = new JScrollPane(locoAttachableInfoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        trainInfoPanel = new JTextArea();
        trainInfoPanel.setFont(listFont);
        trainInfoPanel.setEditable(false);
        Border border = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
        trainInfoPanel.setBorder(border);
        JScrollPane trainInfoPanelSP = new JScrollPane(trainInfoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
        JPanel createTrainPageBottomPanel = new JPanel();
        createTrainPageBottomPanel.setBackground(Color.YELLOW);
        createTrainPageBottomPanel.setPreferredSize(new Dimension(GUIMethods.getDim().width, ((GUIMethods.getDim().height) / 3) - 20));

        JPanel imageDrawPanel = drawBottomImage;
        imageDrawPanel.setPreferredSize(new Dimension(5000, ((GUIMethods.getDim().height) / 3) - 20));
        drawSP = new JScrollPane(imageDrawPanel);
        drawSP.setPreferredSize(new Dimension(GUIMethods.getDim().width, ((GUIMethods.getDim().height) / 3) - 20));
        drawSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        drawSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        createTrainPageBottomPanel.add(drawSP);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(createTrainPageBottomPanel, c);

    }

    private void createNewTrain()
    {
        tempTrain = new ArrayList<>();
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
        if (tempTrain.get(0).getTrainLenght() != 0)
        {
            tempTrain.get(tempTrain.size() - 1).setTrainName(setNameTextField.getText());
            GUIMethods.createTrain(tempTrain.get(0));
            errorLabel.setText("Train saved!");
        }
    }


    private void updateNameTextField()
    {
        setNameTextField.setText("Train " + (GUIMethods.getTrain().size() + 1));
    }


    private void printCurrentTrain()
    {
        trainInfoPanel.setText("");
        trainInfoPanel.append("Combined locomotive power: " + tempTrain.get(0).getCombinedPower() + "\n");
        trainInfoPanel.append("Number of cars: " + tempTrain.get(0).getNumbersOfCars() + "\n");
        trainInfoPanel.append("Train lenght: "+tempTrain.get(0).getTrainLenght()+"/10\n");
        trainInfoPanel.append("Total passenger capacity: " + tempTrain.get(0).getPassengerCapacity() + "\n");
        trainInfoPanel.append("Total box wagon capacity: " + tempTrain.get(0).getCargoCapacity() + " kg\n");
    }

    private void addLoco()
    {
        //GUIMethods.getLocomotivesArrayList().get(locomotiveList.getSelectedIndex()).getImageLarge();
        try
        {
            errorLabel.setText(tempTrain.get(0).addComponent((Train) GUIMethods.getLocomotivesArrayList().get(locomotiveList.getSelectedIndex())));
        }
        catch (IndexOutOfBoundsException e)
        {
            errorLabel.setText("Please create the train first");
        }
        if (errorLabel.getText().length() == 0)
        {
            drawBottomImage.addTrainImage(tempTrain.get(0).drawImage(tempTrain.get(0).getTrainLenght() - 1));
        }

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
        errorLabel.setText(tempTrain.get(tempTrain.size() - 1).addComponent((Train) GUIMethods.getAttachableArrayList().get(attachableList.getSelectedIndex())));
        if (errorLabel.getText().length() == 0)
        {
            drawBottomImage.addTrainImage(tempTrain.get(0).drawImage(tempTrain.get(0).getTrainLenght() - 1));
        }

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
        ArrayList<Attachable> attachableList = GUIMethods.getAttachableArrayList();
        DefaultListModel<String> locoDefaultList = new DefaultListModel<>();
        for (Attachable attachable : attachableList)
        {
            locoDefaultList.addElement(attachable.getName());
        }
        return locoDefaultList;
    }

    private void showLocomotiveList(JPanel listPanel, JPanel buttonPanel)
    {
        locoFilterVar = locoFilter.ALL;
        locomotivelistData();
        cardLayout.show(listPanel, "locomotiveSelect");
        cardLayout.show(buttonPanel, "locomotiveFilter");
        locoAttachableInfoPanel.setText("");
        locomotiveList.clearSelection();
    }

    private void showAttachableList(JPanel listPanel, JPanel buttonpanel)
    {
        attachableFilterVar = attachableFilter.ALL;
        attachableListData();
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

    private void locomotivelistData()
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
    }

    private void setCarAttachableEnum()
    {
        attachableFilterVar = attachableFilter.CAR;
        attachableListData();
    }

    private void setBoxAttachableEnum()
    {
        attachableFilterVar = attachableFilter.BOX;
        attachableListData();
    }

    private void setTankAttachableEnum()
    {
        attachableFilterVar = attachableFilter.TANK;
        attachableListData();
    }

    private void setContainerAttachableEnum()
    {
        attachableFilterVar = attachableFilter.CONTAINER;
        attachableListData();
    }

    private void setAllAttachableEnum()
    {
        attachableFilterVar = attachableFilter.ALL;
        attachableListData();
    }

    private void attachableListData()
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
                    if (GUIMethods.getAttachableArrayList().get(i).getType().contains("Box") || GUIMethods.getAttachableArrayList().get(i).getType().contains("Grain"))
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
    }

    private void locoTextPanel()
    {
        locoAttachableInfoPanel.setText("");
        int i = locomotiveList.getSelectedIndex();
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

    private void attachableTextPanel()
    {
        locoAttachableInfoPanel.setText("");
        int i = attachableList.getSelectedIndex();
        locoAttachableInfoPanel.append("Name: " + GUIMethods.getAttachableArrayList().get(i).getName() + "\n");
        locoAttachableInfoPanel.append("Type: " + GUIMethods.getAttachableArrayList().get(i).getType() + "\n");
        if (GUIMethods.getAttachableArrayList().get(i) instanceof Car)
        {
            locoAttachableInfoPanel.append("Capacity: " + GUIMethods.getAttachableArrayList().get(i).getCapacity() + " Passenger\n");
        }
        if (GUIMethods.getAttachableArrayList().get(i) instanceof Wagon)
        {
            locoAttachableInfoPanel.append("Capacity: " + GUIMethods.getAttachableArrayList().get(i).getCapacity() + " kg\n");
        }
        if (GUIMethods.getAttachableArrayList().get(i) instanceof RLMMPS651FlatWagon)
        {
            locoAttachableInfoPanel.append("Possible cargo: \n");
            for (int j = 0; j < GUIMethods.getCargoArrayList().size(); j++)
            {
                locoAttachableInfoPanel.append("\t" + GUIMethods.getCargoArrayList().get(j).getName() + "\n");
            }
        }
        //locoAttachableInfoPanel.append("Max speed: " + GUIMethods.getAttachableArrayList().get(i).getMaxSpeed() + " KP/H");
    }
}
