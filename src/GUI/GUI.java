package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panelMain;
    private JButton button;

    public void GUIstart(GUI gui){
        JFrame jframe = new JFrame("Fractal Tree");
        jframe.setContentPane(gui.panelMain);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1200,800);
        panelMain.setBackground(Color.decode("#201e29"));
        jframe.setVisible(true);
    }

    public GUI(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aye");
            }
        });
    }
}