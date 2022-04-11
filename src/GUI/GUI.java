package GUI;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame jframe;
    private JPanel MainPanel;
    private JPanel CanvasPanel;
    private JPanel SliderPanel;
    private JLabel[] LabelArrayTreeProperties;
    private JSlider[] SliderArrayTreeProperties;
    private JSeparator[] SeparatorArrayTreeProperties1;
    private JSeparator[] SeparatorArrayTreeProperties2;

    //CONSTRUCTOR
    public GUI(){

    }

    //INITIALIZE GUI
    public void GUIstart(GUI gui){
        initializeGUIObjects();

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
        SliderPanel.setBackground(Color.decode("#302d3d"));
        SliderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        jframe.setContentPane(MainPanel);
        MainPanel.add(CanvasPanel);
        MainPanel.add(SliderPanel);

        LabelArrayTreeProperties[0].setText("First branches length");
        LabelArrayTreeProperties[1].setText("Branch length scaling");
        LabelArrayTreeProperties[2].setText("Number of branches in a node");
        LabelArrayTreeProperties[3].setText("angle between branches in a node");
        LabelArrayTreeProperties[4].setText("angle between mother branch and daughter branch");
        LabelArrayTreeProperties[5].setText("limit of realization");
        LabelArrayTreeProperties[6].setText("randomness");
        for(int i=0; i<7; i++){
            //SLIDER PROPERTIES
            SliderArrayTreeProperties[i].setPreferredSize(new Dimension(400, 25));
            SliderArrayTreeProperties[i].setBackground(Color.decode("#302d3d"));

            //LABEL PROPERTIES
            LabelArrayTreeProperties[i].setForeground(Color.decode("#ffffff"));
            LabelArrayTreeProperties[i].setPreferredSize(new Dimension(400, 30));

            //SEPARATOR PROPERTIES
            if(i==1 || i==4 || i==5) {
                SeparatorArrayTreeProperties1[i].setPreferredSize(new Dimension(360, 51));
                SeparatorArrayTreeProperties1[i].setBackground(Color.decode("#201e29"));
                SeparatorArrayTreeProperties1[i].setForeground(null);
                SliderPanel.add(SeparatorArrayTreeProperties1[i]);
            }
            SeparatorArrayTreeProperties2[i].setPreferredSize(new Dimension(360, 31));
            SeparatorArrayTreeProperties2[i].setBackground(Color.decode("#302d3d"));
            SeparatorArrayTreeProperties2[i].setForeground(null);

            //ADD COMPONENTS
            SliderPanel.add(LabelArrayTreeProperties[i]);
            SliderPanel.add(SliderArrayTreeProperties[i]);
            SliderPanel.add(SeparatorArrayTreeProperties2[i]);
        }

        jframe.setVisible(true);
    }

    private void initializeGUIObjects(){
        //JFRAME
        JFrame jframe = new JFrame("Fractal Tree");
        this.jframe = jframe;

        //JPANEL
        JPanel MainPanel = new JPanel();
        this.MainPanel = MainPanel;

        JPanel CanvasPanel = new JPanel();
        this.CanvasPanel = CanvasPanel;

        JPanel SliderPanel = new JPanel();
        this.SliderPanel = SliderPanel;

        //JLABEL TREE PROPERTIES OPTIONS
        JLabel[] LabelArrayTreeProperties = new JLabel[7];
        for(int i=0; i<7; i++) {
            LabelArrayTreeProperties[i] = new JLabel();
        }
        this.LabelArrayTreeProperties = LabelArrayTreeProperties;

        //JSLIDER TREE PROPERTIES OPTIONS
        JSlider[] SliderArrayTreeProperties = new JSlider[7];
        for(int i=0; i<7; i++){
            SliderArrayTreeProperties[i] = new JSlider();
        }
        this.SliderArrayTreeProperties = SliderArrayTreeProperties;

        //JSEPARATOR TREE PROPERTIES OPTIONS
        JSeparator[] SeparatorArrayTreeProperties1 = new JSeparator[7];
        JSeparator[] SeparatorArrayTreeProperties2 = new JSeparator[7];
        for(int i=0; i<7; i++){
            SeparatorArrayTreeProperties1[i] = new JSeparator();
            SeparatorArrayTreeProperties2[i] = new JSeparator();
        }
        this.SeparatorArrayTreeProperties1 = SeparatorArrayTreeProperties1;
        this.SeparatorArrayTreeProperties2 = SeparatorArrayTreeProperties2;

        /*
        0-first branch length
        1-scaling of branch length
        2-Number of Branches in a node
        3-angle between branches in a node
        4-angle between daughter branch and mother branch
        5-limit of realization
        6-randomness (angles/length)
         */
    }
}