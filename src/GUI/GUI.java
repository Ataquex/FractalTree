package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panelMain;
    private JButton button;
    private JSlider slider1;

    public void GUIstart(GUI gui){
        JFrame jframe = new JFrame("Fractal Tree");

        //JFRAME PROPERTIES
        jframe.setResizable(false);
        jframe.setContentPane(panelMain);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1200,800);

        //JPANEL PROPERTIES
        panelMain.setBackground(Color.decode("#201e29"));
        panelMain.setSize(500, 500);

        jframe.setVisible(true);
    }

    public GUI(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(panelMain.getComponents());
            }
        });
    }
}