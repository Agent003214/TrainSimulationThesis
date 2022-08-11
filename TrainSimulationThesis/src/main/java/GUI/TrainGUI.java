package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainGUI extends JFrame implements ActionListener
{
    private final CardLayout cardLayout;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints c;
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
        JPanel addLocomotivePanel=new JPanel();
        addLocomotivePanel.setLayout(new GridLayout(2,1));
        DefaultListModel<String> locoDefaultList=new DefaultListModel<>();
        locoDefaultList.addElement("V63");
        locoDefaultList.addElement("F40PH");
        JList<String> locoList=new JList<>(locoDefaultList);
        addLocomotivePanel.add(locoList);
        JButton addLoco=new JButton("Add");
        addLocomotivePanel.add(addLoco);
        createTrainPageTopPanel.add(addLocomotivePanel);

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

    void showYellowPane()
    {
        cardLayout.show(mainPane, "valami");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
