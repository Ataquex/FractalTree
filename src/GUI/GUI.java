package GUI;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame jframe;
    private JPanel MainPanel;
    private JPanel CanvasPanel;
    private JPanel SliderPanel;

    //CONSTRUCTOR
    public GUI(){

    }

    //INITIALIZE GUI
    public void GUIstart(GUI gui){
        initializeObjects();

        //JFRAME PROPERTIES
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1200,800);

    //JPANEL PROPERTIES

        //MAINPANEL PROPERTIES
        MainPanel.setBackground(Color.decode("#433f54"));;
        MainPanel.setLayout(null);

        //CANVASPANEL PROPERTIES
        CanvasPanel.setBounds(0,0,741,jframe.getHeight());
        CanvasPanel.setBackground(Color.decode("#201e29"));

        //SLIDERPANEL PROPERTIES
        SliderPanel.setBounds(745,0,458,jframe.getHeight());
        SliderPanel.setBackground(Color.decode("#201e29"));

        jframe.setContentPane(MainPanel);
        MainPanel.add(CanvasPanel);
        MainPanel.add(SliderPanel);
        jframe.setVisible(true);
    }

    private void initializeObjects(){
        JFrame jframe = new JFrame("Fractal Tree");
        this.jframe = jframe;

        JPanel MainPanel = new JPanel();
        this.MainPanel = MainPanel;

        JPanel CanvasPanel = new JPanel();
        this.CanvasPanel = CanvasPanel;

        JPanel SliderPanel = new JPanel();
        this.SliderPanel = SliderPanel;
    }
}