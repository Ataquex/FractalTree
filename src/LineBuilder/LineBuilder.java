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

        TreeRecursive(graphic, 0, 0, 0, FirstBranchLength, BranchLengthScaling, NumberBranchesPerNode, AngleBranchesPerNode, AngleMotherToDaughterBranch, RealizationLimit, randomness);

    }

    public void TreeRecursive(Graphics2D graphic, int x1, int y1, int x2, int y2, float scaling, int branchespernode, double anglenode, double anglemotherdaughter, int realization, int randomness){
        graphic.drawLine(x1, y1, x2, -y2);
        graphic.translate(x2, -y2);

        realization--;
        if(realization > 0){

            double saveangle = anglemotherdaughter * PI - PI;

            graphic.rotate(anglemotherdaughter * PI - PI);
            TreeRecursive(graphic, x1, y1, x2, y2, scaling, branchespernode, anglenode, anglemotherdaughter, realization, randomness);
            graphic.translate(0, y2);
            graphic.rotate(-saveangle);


            saveangle = anglemotherdaughter * PI - PI;

            graphic.rotate(-anglemotherdaughter * PI - PI);
            TreeRecursive(graphic, x1, y1, x2, y2, scaling, branchespernode, anglenode, anglemotherdaughter, realization, randomness);
            graphic.translate(0, y2);
            graphic.rotate(saveangle);
        }
    }

    public void DrawTree(){
        repaint();
    }
}
