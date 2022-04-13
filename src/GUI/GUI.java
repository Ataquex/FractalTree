package GUI;

import LineBuilder.LineBuilder;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import Controller.Controller;

public class GUI {
    private Controller controller;
    private JFrame jframe;
    private JPanel MainPanel;
    private JPanel CanvasPanel;
    private JPanel SliderPanel;
    private JLabel[] LabelArrayTreeProperties;
    private JSlider[] SliderArrayTreeProperties;
    private JSeparator[] SeparatorArrayTreeProperties1;
    private JSeparator[] SeparatorArrayTreeProperties2;
    private LineBuilder LineBuilder;
    private int[] TreeProperties;

    //CONSTRUCTOR
    public GUI(){

    }

    //INITIALIZE GUI
    public void GUIstart(LineBuilder lineBuilder, Controller controller){
        this.controller = controller;
        this.LineBuilder = lineBuilder;

        int[] TreeProperties = new int[7];
        this.TreeProperties = TreeProperties;

        initializeGUIObjects();

        //CHANGELISTENER
        ChangeListener sliderListener = e -> {
            for(int i=0; i<7; i++){
                this.TreeProperties[i] = SliderArrayTreeProperties[i].getValue();
            }
            this.controller.ChangePerformed(this.TreeProperties);
        };

        //JFRAME PROPERTIES
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1200,800);

    //JPANEL PROPERTIES

        //MAINPANEL PROPERTIES
        MainPanel.setBackground(Color.decode("#433f54"));
        MainPanel.setLayout(null);

        //CANVASPANEL PROPERTIES
        CanvasPanel.setBounds(0,0,741,jframe.getHeight());
        CanvasPanel.setBackground(Color.decode("#201e29"));
        CanvasPanel.setLayout(new BorderLayout());

        //SLIDERPANEL PROPERTIES
        SliderPanel.setBounds(745,0,458,jframe.getHeight());
        SliderPanel.setBackground(Color.decode("#302d3d"));
        SliderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        jframe.setContentPane(MainPanel);
        MainPanel.add(CanvasPanel);
        MainPanel.add(SliderPanel);
        CanvasPanel.add(this.LineBuilder);

        //JLABEL TEXT
        LabelArrayTreeProperties[0].setText("First branches length");
        LabelArrayTreeProperties[1].setText("Branch length scaling");
        LabelArrayTreeProperties[2].setText("Number of branches in a node");
        LabelArrayTreeProperties[3].setText("Angle between branches in a node");
        LabelArrayTreeProperties[4].setText("Angle between mother branch and daughter branch");
        LabelArrayTreeProperties[5].setText("Limit of realization");
        LabelArrayTreeProperties[6].setText("Randomness");

        //SLIDER PROPERTIES MIN TO MAX
        //TICKSPACING ARRAY
        int[] minortickspacing = new int[]{50,25,1,45,45,1,1};
        int[] majortickspacing = new int[]{100,100,5,90,90,5,5};
        //MIN MAX ARRAY
        int[] min = new int[]{1,1,1,0,0,1,0};
        int[] max = new int[]{300,200,10,360,360,20,10};

        for(int i=0; i<7; i++){
            //SLIDER PROPERTIES
            SliderArrayTreeProperties[i].setPreferredSize(new Dimension(400, 25));
            SliderArrayTreeProperties[i].setBackground(Color.decode("#302d3d"));
            SliderArrayTreeProperties[i].addChangeListener(sliderListener);
            SliderArrayTreeProperties[i].setMaximum(max[i]);
            SliderArrayTreeProperties[i].setMinimum(min[i]);
            SliderArrayTreeProperties[i].setValue(SliderArrayTreeProperties[i].getMinimum());
            SliderArrayTreeProperties[i].setPaintTicks(true);
            SliderArrayTreeProperties[i].setPaintLabels(true);
            SliderArrayTreeProperties[i].setSnapToTicks(true);
            SliderArrayTreeProperties[i].setMajorTickSpacing(majortickspacing[i]);
            SliderArrayTreeProperties[i].setMinorTickSpacing(minortickspacing[i]);

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

    //INSTANTIATE GUI OBJECTS
    private void initializeGUIObjects(){
        //LINEBUILDER
        this.LineBuilder = new LineBuilder();

        //JFRAME
        this.jframe = new JFrame("Fractal Tree");

        //JPANEL
        this.MainPanel = new JPanel();
        this.CanvasPanel = new JPanel();
        this.SliderPanel = new JPanel();

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

    public int[] getTreeProperties(){
        return this.TreeProperties;
    }
}