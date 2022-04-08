package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public JPanel panelMain;
    private JButton buttonmsg;

    public GUI() {
        buttonmsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("lal");
            }
        });
    }
}