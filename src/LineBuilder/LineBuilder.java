package LineBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.PI;

import Model.Model;

public class LineBuilder extends JComponent {
    private final Model model;

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

        int FirstBranchLength = model.getFirstBranchLength();
        float BranchLengthScaling = model.getBranchLengthScaling();
        int NumberBranchesPerNode = model.getNumberBranchesPerNode();
        double AngleBranchesPerNode = model.getAngleBranchesPerNode();
        double AngleMotherToDaughterBranch = model.getAngleMotherToDaughterBranch();
        int RealizationLimit = model.getRealizationLimit();
        int randomness = model.getRandomness();

        TreeRecursive(graphic, 0, 0, 0, FirstBranchLength, BranchLengthScaling, NumberBranchesPerNode, AngleBranchesPerNode, AngleMotherToDaughterBranch, RealizationLimit, randomness);

    }

    public void TreeRecursive(Graphics2D graphic, int x1, int y1, int x2, int y2, float scaling, int branchespernode, double anglenode, double anglemotherdaughter, int realization, int randomness){
        graphic.drawLine(x1, y1, x2, -y2);
        graphic.translate(x2, -y2);

        realization--;
        if(realization > 0) {

            for(int i = 0; i < branchespernode; i++) {

                double randomfactorScaling = 1 + ((ThreadLocalRandom.current().nextDouble(0, 1 + randomness * 5) - (randomness * 3 / 2)) / 100);
                double randomfactorAngle = 1 + ((ThreadLocalRandom.current().nextDouble(0, 1 + randomness * 5) - (randomness * 3 / 2)) / 100);

                double saveangle = ((anglemotherdaughter * PI - PI) + (i * (anglenode * PI))) * randomfactorAngle;
                graphic.rotate(-(((anglemotherdaughter * PI - PI) + (i * (anglenode * PI))) * randomfactorAngle));

                TreeRecursive(graphic, x1, y1, x2, (int) (y2 * (scaling * randomfactorScaling)), scaling, branchespernode, anglenode, anglemotherdaughter, realization, randomness);
                graphic.translate(0, (int) (y2 * (scaling * randomfactorScaling)));
                graphic.rotate(saveangle);
            }
        }
    }

    public void DrawTree(){
        repaint();
    }
}
