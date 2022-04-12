package LineBuilder;

import javax.swing.*;
import java.awt.*;

public class LineBuilder extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(Color.decode("#ffd000"));
        graphic.fillRect(100, 100, 60, 800);;
    }
}
