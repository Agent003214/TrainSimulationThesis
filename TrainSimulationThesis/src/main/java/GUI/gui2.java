package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui2 extends JFrame implements ActionListener
{
    private CardLayout cardLayout;
    private JPanel mainpanel;
    boolean isRedPaneVisible;
    JMenuItem i1, i2;
    public gui2()
    {
        setTitle("Card Layout Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        mainpanel = new JPanel();
        //mainpanel.setPreferredSize(new Dimension(250,150));

        cardLayout = new CardLayout();
        mainpanel.setLayout(cardLayout);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel yellowPane = new JPanel();
        yellowPane.setBackground(Color.YELLOW);
        JPanel redPane = new JPanel();
        redPane.setBackground(Color.RED);

        mainpanel.add("elso", yellowPane);
        mainpanel.add("masodik", redPane);
        showRedPane();

        JButton button = new JButton("Switch Panes");
        button.addActionListener(e -> switchPanes() );

        setLayout(new BorderLayout());
        add(mainpanel,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        //pack();
        setVisible(true);
    }
    void switchPanes() {
        if (isRedPaneVisible) {showYelloPane();}
        else { showRedPane();}
    }
    void showRedPane() {
        cardLayout.show(mainpanel, "masodik");
        isRedPaneVisible = true;
    }

    void showYelloPane() {
        cardLayout.show(mainpanel, "elso");
        isRedPaneVisible = false;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
