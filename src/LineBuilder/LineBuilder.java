package LineBuilder;

import javax.swing.*;
import java.awt.*;
import Model.Model;
import static java.lang.Math.PI;

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

        int FirstBranchLength = this.model.getFirstBranchLength();
        float BranchLengthScaling = this.model.getBranchLengthScaling();
        int NumberBranchesPerNode = this.model.getNumberBranchesPerNode();
        double AngleBranchesPerNode = this.model.getAngleBranchesPerNode();
        double AngleMotherToDaughterBranch = this.model.getAngleMotherToDaughterBranch();
        int RealizationLimit = this.model.getRealizationLimit();
        int randomness = this.model.getRandomness();

        int x1 = 0, y1 = 0, x2 = 0, y2 = FirstBranchLength;

        for(int i0 = 0; i0<RealizationLimit; i0++){
                graphic.drawLine(x1, y1, x2, -y2);

                graphic.translate(x2, -y2);
                graphic.rotate(AngleBranchesPerNode * PI);

                y2 *= BranchLengthScaling;
        }
    }

    public void DrawTree(){
        repaint();
    }
}
