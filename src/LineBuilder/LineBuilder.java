package LineBuilder;

import javax.swing.*;
import java.awt.*;

public class LineBuilder extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphic = (Graphics2D) g;

        graphic.translate(370, 600);
        graphic.setStroke(new BasicStroke(3));
        graphic.setColor(Color.decode("#ffffff"));
        graphic.drawLine(0,0,0,-300);
    }
}
