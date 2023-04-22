package GUI;

import javax.swing.*;
import java.awt.*;

public class TrainGUI extends JFrame
{
    private final CardLayout cardLayout;
    private final JPanel mainPane;
    private ViewTrainsPage viewTrainsPage=new ViewTrainsPage();
    private MapPage trainMap=new MapPage();

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
        try
        {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Locomotives/Electric/V63/V63Side.png"));
            setIconImage(icon.getImage());
        }
        catch (NullPointerException e)
        {

        }



        mainPane.add("createTrainPage", new CreateTrainPage());
        mainPane.add("viewTrainPage", viewTrainsPage);
        mainPane.add("mapPage", trainMap);


        Container pane = this.getContentPane();
        pane.add(mainPane, BorderLayout.CENTER);
        JButton button1 = new JButton("Create train");
        button1.addActionListener(e -> cardLayout.show(mainPane, "createTrainPage"));
        JButton button2 = new JButton("View trains");
        button2.addActionListener(e -> showViewTrainPage());
        JButton button3 = new JButton("Map");
        button3.addActionListener(e -> showMapPage());
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

    private void showViewTrainPage() {
        cardLayout.show(mainPane, "viewTrainPage");
        viewTrainsPage.trainList();
    }

    private void showMapPage() {
        cardLayout.show(mainPane, "mapPage");
        trainMap.refresh();
    }
}
