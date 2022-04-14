package LineBuilder;

import javax.swing.*;
import java.awt.*;
import Model.Model;

public class LineBuilder extends JComponent {
    private Model model;

    public LineBuilder(Model model){
        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphic = (Graphics2D) g;

        //GRAPHIC PROPERTIES
        graphic.translate(370, 600);
        graphic.setStroke(new BasicStroke(3));
        graphic.setColor(Color.decode("#ffffff"));

        graphic.drawLine(0,0,0,-300);
    }

    public void DrawTree(){
        repaint();
    }
}
