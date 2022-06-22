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

            double saveangle = anglemotherdaughter * PI - PI;
            graphic.rotate(-anglemotherdaughter * PI - PI);

            TreeRecursive(graphic, x1, y1, x2, (int) (y2 * scaling), scaling, branchespernode, anglenode, anglemotherdaughter, realization, randomness);
            graphic.translate(0, (int) (y2 * scaling));
            graphic.rotate(saveangle);


            saveangle =  (anglenode * PI - PI) + (anglemotherdaughter * PI);
            graphic.rotate(-((anglenode * PI - PI) + (anglemotherdaughter * PI)));

            TreeRecursive(graphic, x1, y1, x2, (int) (y2 * scaling), scaling, branchespernode, anglenode, anglemotherdaughter, realization, randomness);
            graphic.translate(0, (int) (y2 * scaling));
            graphic.rotate(saveangle);
        }
    }

    public void DrawTree(){
        repaint();
    }
}
