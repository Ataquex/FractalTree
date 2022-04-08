package Main;
import GUI.GUI;
import javax.swing.*;

public class main{

    public static void main (String[] args){
        JFrame jframe = new JFrame("GUI");
        jframe.setContentPane(new GUI().panelMain);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
    }
}
