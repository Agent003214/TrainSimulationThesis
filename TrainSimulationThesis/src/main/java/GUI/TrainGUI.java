package GUI;

import Attachables.Attachable;
import Attachables.Cargo.IntermodelContainer;
import Attachables.Cargo.TankContainer;
import Attachables.CargoWagon.RLMMPS651FlatWagon;
import Attachables.PassengerCar.InterCityPlus;
import Attachables.PassengerCar.Mark3;
import TrainEngines.Diesel.DieselLocomotive;
import TrainEngines.Diesel.F40PH;
import TrainEngines.Diesel.SD70M;
import TrainEngines.Electric.ElectricLocomotive;
import TrainEngines.Electric.V63;
import TrainEngines.Locomotive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TrainGUI extends JFrame implements ActionListener
{
    private final CardLayout cardLayout;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
    //JPanel addLocomotivePanel;
    JTextArea locoAttachableInfoPanel;
    JList<String> selectList;
    private final JPanel mainPane;
    public TrainGUI()
    {
        //https://techhelpnotes.com/swing-java-gui-switching-between-panels-on-button-click-2/

        setTitle("Train");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPane =new JPanel();
        cardLayout=new CardLayout();
        mainPane.setLayout(cardLayout);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();


        //Create the train creation page
        JPanel createTrainPage=new JPanel();
        createTrainPage.setBackground(Color.RED);
        gridBagLayout=new GridBagLayout();
        createTrainPage.setLayout(gridBagLayout);

        //Create top panel
        GridBagConstraints c=new GridBagConstraints();
        JPanel createTrainPageTopPanel=new JPanel();
        createTrainPageTopPanel.setPreferredSize(new Dimension(dim.width,((dim.height/3)*2)-20));
        createTrainPageTopPanel.setBackground(Color.WHITE);
        createTrainPageTopPanel.setLayout(new GridLayout(1,3));
        c.gridx=0;
        c.gridy=0;
        c.gridheight=1;
        c.gridwidth=1;
        c.fill=GridBagConstraints.BOTH;
        createTrainPage.add(createTrainPageTopPanel,c);

        //Create add locomotive panels
        //Top left panel
        JPanel addSelectorTopPanel=new JPanel();
        addSelectorTopPanel.setLayout(cardLayout);
        JPanel addLocomotivePanel=new JPanel();
        addLocomotivePanel.setLayout(new BorderLayout());
        JList<String> locomotiveList=new JList<>(locomotives());
        JButton addLocomotiveButton=new JButton("Add locomotive");
        addLocomotivePanel.add(locomotiveList,BorderLayout.CENTER);
        addLocomotivePanel.add(addLocomotiveButton,BorderLayout.SOUTH);

        JPanel addAttachablePanel=new JPanel();
        addAttachablePanel.setLayout(new BorderLayout());
        JList<String> attachableList=new JList<>(attachables());
        JButton addAttachableButton=new JButton("Add attachable");
        addAttachablePanel.add(attachableList,BorderLayout.CENTER);
        addAttachablePanel.add(addAttachableButton,BorderLayout.SOUTH);
        Font listFont=new Font(locomotiveList.getFont().getFontName(),locomotiveList.getFont().getStyle(),22);
        locomotiveList.setFont(listFont);
        attachableList.setFont(listFont);

        addSelectorTopPanel.add("locomotiveSelect",addLocomotivePanel);
        addSelectorTopPanel.add("attachableSelect",addAttachablePanel);

        createTrainPageTopPanel.add(addSelectorTopPanel);



        //Create top middle Panel
        JPanel selectorButtonPanel=new JPanel();
        selectorButtonPanel.setLayout(new GridLayout());
        selectorButtonPanel.setBackground(Color.BLUE);
        c=new GridBagConstraints();
        JButton showLocoButton=new JButton("Locomotives");
        showLocoButton.addActionListener(e -> showLocomotiveList(addSelectorTopPanel));
        JButton showAttachableButton=new JButton("Cars/Wagons");
        showAttachableButton.addActionListener(e -> showAttachableList(addSelectorTopPanel));
        createTrainPageTopPanel.add(selectorButtonPanel);
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=2;
        c.gridheight=1;
        selectorButtonPanel.add(showLocoButton,c);
        c=new GridBagConstraints();
        c.gridx=2;
        c.gridy=0;
        c.gridwidth=2;
        c.gridheight=1;
        selectorButtonPanel.add(showAttachableButton,c);
        JPanel filterButtonPanel=new JPanel();
        filterButtonPanel.setLayout(cardLayout);
        JPanel locomotiveFilterButtonPanel=new JPanel();
        locomotiveFilterButtonPanel.setLayout(new GridLayout(2,2));
        JButton electricLocomotiveFilterButton=new JButton("Electric");
        JButton dieselLocomotiveFilterButton=new JButton("Diesel");
        JButton locomotiveRemoveFilterButton=new JButton("All");
        locomotiveFilterButtonPanel.add(electricLocomotiveFilterButton);
        locomotiveFilterButtonPanel.add(dieselLocomotiveFilterButton);
        locomotiveFilterButtonPanel.add(locomotiveRemoveFilterButton);

        JPanel attachableFilterButtonPanel=new JPanel();
        JButton carFilterButton=new JButton("Passener cars");
        JButton fluidTankFilterButton=new JButton("Fluid tank");
        JButton intermodelContainerFilterButton=new JButton("Container");

        JButton attachableRemoveFilterButton=new JButton("All");






        //create top right panel
        JPanel infoPanel=new JPanel();
        infoPanel.setBackground(Color.magenta);
        createTrainPageTopPanel.add(infoPanel);
        infoPanel.setLayout(new BorderLayout());
        locoAttachableInfoPanel=new JTextArea();
        locoAttachableInfoPanel.setFont(listFont);
        infoPanel.add(locoAttachableInfoPanel,BorderLayout.CENTER);

        locomotiveList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                locoTextPanel(locomotiveList.getSelectedIndex());
            }
        });

        attachableList.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                attachableTextPanel(attachableList.getSelectedIndex());
            }
        });


        //Create bottom panel
        JPanel createTrainPageBottomPanel=new JPanel();
        createTrainPageBottomPanel.setBackground(Color.YELLOW);
        createTrainPageBottomPanel.setPreferredSize(new Dimension(dim.width, ((dim.height)/3)-20));
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=2;
        c.gridheight=1;
        c.gridwidth=1;
        createTrainPage.add(createTrainPageBottomPanel,c);



        JPanel p2=new JPanel();
        p2.setBackground(Color.GREEN);
        JPanel p3=new JPanel();
        p3.setBackground(Color.BLUE);

        mainPane.add("createTrainPage",createTrainPage);
        mainPane.add("p2",p2);
        mainPane.add("p3",p3);

        Container pane=this.getContentPane();
        pane.add(mainPane,BorderLayout.CENTER);
        JButton button1=new JButton("gomb1");
        button1.addActionListener(e -> cardLayout.show(mainPane,"createTrainPage"));
        JButton button2=new JButton("gomb2");
        button2.addActionListener(e -> cardLayout.show(mainPane,"p2"));
        JButton button3=new JButton("gomb3");
        button3.addActionListener(e -> cardLayout.show(mainPane,"p3"));
        JButton button4=new JButton("quit");
        button4.addActionListener(e -> System.exit(0));

        JPanel buttonPanel=new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.setPreferredSize(new Dimension(dim.width,33));
        pane.add(buttonPanel,BorderLayout.SOUTH);

        setUndecorated(true);
        setVisible(true);
        System.out.println(buttonPanel.getSize().toString());
    }

    private void showLocomotiveList(JPanel container)
    {
        cardLayout.show(container,"locomotiveSelect");
        locoAttachableInfoPanel.setText("");
    }
    private void showAttachableList(JPanel container)
    {
        cardLayout.show(container,"attachableSelect");
        locoAttachableInfoPanel.setText("");
    }

    private void locoTextPanel(int selectedIndex)
    {
        locoAttachableInfoPanel.setText("");
        locoAttachableInfoPanel.append("Maker name: "+ getLocomotivesArrayList().get(selectedIndex).getMakerName()+"\n");
        locoAttachableInfoPanel.append("Model name: "+ getLocomotivesArrayList().get(selectedIndex).getModelName()+"\n");
        if (getLocomotivesArrayList().get(selectedIndex) instanceof ElectricLocomotive)
        {
            locoAttachableInfoPanel.append("Power: "+ getLocomotivesArrayList().get(selectedIndex).getPower()+" kW\n");
            locoAttachableInfoPanel.append("Type: Electric\n");
        }
        if (getLocomotivesArrayList().get(selectedIndex) instanceof DieselLocomotive)
        {
            locoAttachableInfoPanel.append("Power: "+ getLocomotivesArrayList().get(selectedIndex).getPower()+" HP\n");
            locoAttachableInfoPanel.append("Type: Diesel\n");
        }
        locoAttachableInfoPanel.append("Max speed: "+getLocomotivesArrayList().get(selectedIndex).getMaxSpeed()+" KP/H\n");
        locoAttachableInfoPanel.append("Weight: "+getLocomotivesArrayList().get(selectedIndex).getWeight()+" Kg\n");
    }

    private void attachableTextPanel(int selectedIndex)
    {
        locoAttachableInfoPanel.setText("");
        locoAttachableInfoPanel.append("Name: "+ getAttachableArrayList().get(selectedIndex).getName()+"\n");
        locoAttachableInfoPanel.append("Capacity: "+getAttachableArrayList().get(selectedIndex).getCapacity()+"\n");
    }

    private DefaultListModel<String> locomotives()
    {
        ArrayList<Locomotive> locomotiveList = getLocomotivesArrayList();

        DefaultListModel<String> locoDefaultList=new DefaultListModel<>();
        for (Locomotive locomotive : locomotiveList)
        {
            locoDefaultList.addElement(locomotive.getModelName());
        }
        return locoDefaultList;
    }

    private static ArrayList<Locomotive> getLocomotivesArrayList()
    {
        ArrayList<Locomotive> locomotiveList=new ArrayList<>();
        locomotiveList.add(new V63());
        locomotiveList.add(new F40PH());
        locomotiveList.add(new SD70M());
        return locomotiveList;
    }

    private DefaultListModel<String> attachables()
    {
        ArrayList<Attachable> attachableList = getAttachableArrayList();

        DefaultListModel<String> locoDefaultList=new DefaultListModel<>();
        for (Attachable attachable : attachableList)
        {
            locoDefaultList.addElement(attachable.getName());
        }
        return locoDefaultList;
    }

    private static ArrayList<Attachable> getAttachableArrayList()
    {
        ArrayList<Attachable> attachableList=new ArrayList<>();
        attachableList.add(new InterCityPlus());
        attachableList.add(new Mark3());
        attachableList.add(new RLMMPS651FlatWagon());
        attachableList.add(new RLMMPS651FlatWagon());
        attachableList.add(new RLMMPS651FlatWagon());
        if (attachableList.get(3) instanceof RLMMPS651FlatWagon)
        {
            ((RLMMPS651FlatWagon) attachableList.get(3)).loadCargo(new IntermodelContainer());
        }
        if (attachableList.get(4) instanceof RLMMPS651FlatWagon)
        {
            ((RLMMPS651FlatWagon) attachableList.get(4)).loadCargo(new TankContainer());
        }
        return attachableList;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
