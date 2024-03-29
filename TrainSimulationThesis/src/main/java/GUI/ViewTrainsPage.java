package GUI;

import FileIO.FileIO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTrainsPage extends JPanel
{
    private MethodClass GUIMethods=new MethodClass();
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
    private final CardLayout cardLayout;
    private JList<String> trainListInfoPanel;
    private static JTextArea trainStatsInfoPanel;
    private JTextArea trainElementsInfoPanel;
    protected  String[] refreshArray;
    private JLabel errorLabel;
    public ViewTrainsPage()
    {
        //setBackground(Color.YELLOW);
        gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
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
        add(topPanel,c);

        //Top left panel
        JPanel trainListPanel=new JPanel();
        trainListPanel.setLayout(new BorderLayout());
        trainListInfoPanel=new JList<>(new DefaultListModel<>());
        trainListPanel.add(trainListInfoPanel,BorderLayout.CENTER);
        trainListInfoPanel.setFont(GUIMethods.getFont());
        topPanel.add(trainListPanel);
        //trainListPanel.setBackground(Color.magenta);
        JButton deleteButton=new JButton("Delete train");
        trainListPanel.add(deleteButton,BorderLayout.SOUTH);
        deleteButton.addActionListener(e -> deleteTrain());


        trainListInfoPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                JList list=(JList) e.getSource();
                trainInfoTop(list.getSelectedIndex());
                trainInfoBottom(list.getSelectedIndex());
            }
        });

        //Top middle panel
        JPanel middleSeparator=new JPanel();
        middleSeparator.setLayout(gridBagLayout);
        c=new GridBagConstraints();
        //middleSeparator.setBackground(Color.BLUE);

        JButton saveButton=new JButton("Save train");
        saveButton.addActionListener(e -> saveTrainToFile());
        c.gridx=0;
        c.gridy=0;
        c.weighty=0;
        c.fill=GridBagConstraints.NONE;
        c.anchor=GridBagConstraints.NORTH;
        middleSeparator.add(saveButton,c);
        topPanel.add(middleSeparator);

        JButton loadButton=new JButton("Load train");
        loadButton.addActionListener(e -> loadTrain());
        c.gridx=1;
        c.gridy=0;
        c.weighty=10;
        c.fill=GridBagConstraints.NONE;
        c.anchor=GridBagConstraints.NORTH;
        middleSeparator.add(loadButton);
        topPanel.add(middleSeparator);

        errorLabel=new JLabel();
        errorLabel.setForeground(Color.RED);
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=GridBagConstraints.REMAINDER;
        //c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.NORTH;
        middleSeparator.add(errorLabel,c);

        //Top right panel
        JPanel trainInfoPanel=new JPanel(new GridLayout(2,1));
        Border border=BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        trainStatsInfoPanel=new JTextArea();
        trainStatsInfoPanel.setBorder(border);
        trainStatsInfoPanel.setFont(GUIMethods.getFont());
        trainElementsInfoPanel=new JTextArea();
        trainElementsInfoPanel.setFont(GUIMethods.getFont());
        trainStatsInfoPanel.setEditable(false);
        trainElementsInfoPanel.setEditable(false);
        trainInfoPanel.add(trainStatsInfoPanel);
        trainInfoPanel.add(trainElementsInfoPanel);
        //trainInfoPanel.setBackground(Color.CYAN);
        topPanel.add(trainInfoPanel);



        //Create bottom panel
        JPanel createTrainPageBottomPanel = new JPanel();
       // createTrainPageBottomPanel.setBackground(Color.YELLOW);
        createTrainPageBottomPanel.setPreferredSize(new Dimension(GUIMethods.getDim().width, ((GUIMethods.getDim().height) / 3) - 20));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(createTrainPageBottomPanel, c);
    }

    /**
     * Displays information for the selected train.
     * @param index The selected index for train to display
     */
    private void trainInfoTop(int index)
    {
        try
        {
            errorLabel.setText("");
            trainStatsInfoPanel.setText("");
            trainStatsInfoPanel.append("Combined locomotive power: " + GUIMethods.getTrain().get(index).getCombinedPower() + "\n");
            trainStatsInfoPanel.append("Number of cars: " + GUIMethods.getTrain().get(index).getNumbersOfCars() + "\n");
            trainStatsInfoPanel.append("Total passenger capacity: " + GUIMethods.getTrain().get(index).getPassengerCapacity() + "\n");
            trainStatsInfoPanel.append("Total cargo capacity: " + GUIMethods.getTrain().get(index).getCargoCapacity() + "\n");
        }
        catch (IndexOutOfBoundsException ignored)
        {

        }
    }

    /**
     * The selected train to be saved.
     */
    private void saveTrainToFile()
    {
        try
        {
            new FileIO().save(GUIMethods.getTrain().get(trainListInfoPanel.getSelectedIndex()), this);
        }
        catch (IndexOutOfBoundsException e)
        {
            errorLabel.setText("Please select a train first!");
        }
    }

    private void loadTrain()
    {
        new FileIO().load(this);
        trainList();
    }

    /**
     * Displays the cars for the selected train.
     * @param index The selected index for train cars to display
     */
    private void trainInfoBottom(int index)
    {
        try
        {
            errorLabel.setText("");
            trainElementsInfoPanel.setText("");
            String[] printString = GUIMethods.getTrain().get(index).trainCars();
            for (int i = 0; i < printString.length; i++) {
                trainElementsInfoPanel.append(printString[i] + "\n");
            }
        }
        catch (IndexOutOfBoundsException ignored)
        {

        }
    }

    private void deleteTrain()
    {
        try
        {
            GUIMethods.getTrain().remove(trainListInfoPanel.getSelectedIndex());
            trainList();
            trainStatsInfoPanel.setText("");
            trainElementsInfoPanel.setText("");
            errorLabel.setText("");
        }
        catch (IndexOutOfBoundsException e)
        {
            errorLabel.setText("Please select a train first!");
        }
    }

    /**
     * Updates the list for the created trains.
     * */
    protected void trainList()
    {
        refreshArray =new String[GUIMethods.getTrain().size()];
        for (int i = 0; i < GUIMethods.getTrain().size(); i++)
        {
            refreshArray[i]=GUIMethods.getTrain().get(i).getTrainName();
        }
        trainListInfoPanel.setListData(refreshArray);
        trainListInfoPanel.revalidate();
        trainListInfoPanel.repaint();
    }

}
