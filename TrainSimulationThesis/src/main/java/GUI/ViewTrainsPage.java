package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTrainsPage extends JPanel
{
    private MethodClass GUIMethods=new MethodClass();
    GridBagLayout gridBagLayout;
    GridBagConstraints c;
    private final CardLayout cardLayout;
    private JList<String> trainListInfoPanel;
    private static DefaultListModel<String> test;
    private JTextArea trainStatsInfoPanel;
    private JTextArea trainElementsInfoPanel;
    public ViewTrainsPage()
    {
        setBackground(Color.YELLOW);
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
        JPanel trainListPanel=new JPanel();
        trainListPanel.setLayout(new BorderLayout());
        //trainListInfoPanel=new JList<>(DLMtest());
        //trainListInfoPanel=new JList<>(new DefaultListModel<>());
        trainListInfoPanel=new JList<>(test=new DefaultListModel<>());
        trainListPanel.add(trainListInfoPanel,BorderLayout.CENTER);
        trainListInfoPanel.setFont(GUIMethods.font);
        topPanel.add(trainListPanel);
        trainListPanel.setBackground(Color.magenta);
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

                /*if (e.getClickCount()==2)
                {
                    int index=list.locationToIndex(e.getPoint());
                    //System.out.println(index);
                }
                else if (e.getClickCount()==3)
                {
                    int index=list.locationToIndex(e.getPoint());
                }*/

            }
        });

        //Top middle panel
        JPanel middleSeparator=new JPanel();
        middleSeparator.setBackground(Color.BLUE);

        JButton refreshButton=new JButton("Refresh");
        refreshButton.addActionListener(e -> trainList());
        middleSeparator.add(refreshButton);
        topPanel.add(middleSeparator);

        //Top right panel
        JPanel trainInfoPanel=new JPanel(new GridLayout(2,1));
        Border border=BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK);
        trainStatsInfoPanel=new JTextArea();
        trainStatsInfoPanel.setBorder(border);
        trainStatsInfoPanel.setFont(GUIMethods.font);
        trainElementsInfoPanel=new JTextArea();
        trainElementsInfoPanel.setFont(GUIMethods.font);
        trainInfoPanel.add(trainStatsInfoPanel);
        trainInfoPanel.add(trainElementsInfoPanel);
        trainInfoPanel.setBackground(Color.CYAN);
        topPanel.add(trainInfoPanel);



        //Create bottom panel
        JPanel createTrainPageBottomPanel = new JPanel();
        createTrainPageBottomPanel.setBackground(Color.YELLOW);
        createTrainPageBottomPanel.setPreferredSize(new Dimension(dim.width, ((dim.height) / 3) - 20));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(createTrainPageBottomPanel, c);
    }

    private void trainInfoTop(int index)
    {
        trainStatsInfoPanel.setText("");
        trainStatsInfoPanel.append("Combined locomotive power: "+GUIMethods.getTrain().get(index).getCombinedPower()+"\n");
        trainStatsInfoPanel.append("Number of cars: "+GUIMethods.getTrain().get(index).getNumbersOfCars()+"\n");
        trainStatsInfoPanel.append("Total passenger capacity: "+GUIMethods.getTrain().get(index).getPassengerCapacityCount()+"\n");
    }

    private void trainInfoBottom(int index)
    {
        trainElementsInfoPanel.setText("");
        String[] printString=GUIMethods.getTrain().get(index).trainCars();
        for (int i = 0; i < printString.length; i++)
        {
            trainElementsInfoPanel.append(printString[i]+"\n");
        }
    }

    private void deleteTrain()
    {
        GUIMethods.getTrain().remove(trainListInfoPanel.getSelectedIndex());
        trainList();
        //test.addElement("aa");
    }

    protected void trainList()
    {
        String[] tempArray=new String[GUIMethods.getTrain().size()];
        for (int i = 0; i < GUIMethods.getTrain().size(); i++)
        {
            tempArray[i]=GUIMethods.getTrain().get(i).getTrainName();
            //System.out.println(tempArray[i]);
        }
        trainListInfoPanel.setListData(tempArray);
        trainListInfoPanel.revalidate();
        trainListInfoPanel.repaint();
    }

  //private DefaultListModel<String> DLMtest()
  //{
  //    DefaultListModel<String> test=new DefaultListModel<>();
  //    /*for (int i = 0; i < GUIMethods.getTrain().size(); i++)
  //    {
  //        test.addElement(i+" train");
  //    }*/
  //    for (int i = 0; i < GUIMethods.getTrain().size(); i++)
  //    {
  //        test.addElement(GUIMethods.getTrain().get(i).getTrainName());
  //    }
  //    return test;
  //}

    protected void DLMtest2()
    {

        for (int i = 0; i < GUIMethods.getTrain().size(); i++)
        {
            test.addElement(GUIMethods.getTrain().get(i).getTrainName());
        }
    }


    protected void DLMtest()
    {
        //test=new DefaultListModel<>();
        for (int i = 0; i < GUIMethods.getTrain().size(); i++)
        {
            test.addElement(GUIMethods.getTrain().get(i).getTrainName());
        }
        trainListInfoPanel.setModel(test);
            //test.addElement("1 train");
        trainListInfoPanel.revalidate();
        trainListInfoPanel.repaint();
        //return test;
    }
}