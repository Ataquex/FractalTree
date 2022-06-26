package LineBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.PI;

import Model.Model;
import com.sun.source.tree.Tree;

public class LineBuilder extends JComponent {
    private final Model model;

    public LineBuilder(Model model){
        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphic = (Graphics2D) g;

        int FirstBranchLength = model.getFirstBranchLength();
        float BranchLengthScaling = model.getBranchLengthScaling();
        int NumberBranchesPerNode = model.getNumberBranchesPerNode();
        double AngleBranchesPerNode = model.getAngleBranchesPerNode();
        double AngleMotherToDaughterBranch = model.getAngleMotherToDaughterBranch();
        int RealizationLimit = model.getRealizationLimit();
        int randomness = model.getRandomness();
        String[][] ColorList = new String[][]{
                {"#00ff0d", "#00ccff", "#ffffff"},
                {"#ff00e6"},
                {"#ff00e6"}
        };

        //GRAPHIC PROPERTIES
        graphic.translate(370, 600);
        graphic.setStroke(new BasicStroke(1));
        graphic.setColor(Color.decode("#ffffff"));

        TreeRecursive(graphic, 0, 0, 0, FirstBranchLength, BranchLengthScaling, NumberBranchesPerNode, AngleBranchesPerNode, AngleMotherToDaughterBranch, RealizationLimit, randomness, RealizationLimit - 4, ColorList, RealizationLimit);

    }

    public void TreeRecursive(Graphics2D graphic, int x1, int y1, int x2, int y2, float scaling, int branchespernode, double anglenode, double anglemotherdaughter, int realization, int randomness, int strokewidth, String[][] ColorList, int TreeLevel){

        //COLOR
        if(ColorList.length >= TreeLevel){
            graphic.setColor(Color.decode(ColorList[TreeLevel - 1][ThreadLocalRandom.current().nextInt(0, ColorList[TreeLevel - 1].length)]));
        }else{
            graphic.setColor(Color.decode("#ffffff"));
        }

        //STROKEWIDTH =! 0
        if(strokewidth < 1){
            strokewidth = 1;
        }

        graphic.setStroke(new BasicStroke(strokewidth));
        graphic.drawLine(x1, y1, x2, -y2);
        graphic.translate(x2, -y2);

        realization--;
        if(realization > 0){

            for(int i = 0; i < branchespernode; i++) {

                double randomfactorScaling = 1;
                double randomfactorAngle = 1;

                if(randomness > 0){
                    randomfactorScaling = 1 + ((ThreadLocalRandom.current().nextDouble(0, 1 + randomness * 5) - (randomness * 1.5)) / 100);
                    randomfactorAngle = 1 + ((ThreadLocalRandom.current().nextDouble(0, 1 + randomness * 10) - (randomness * 1.5)) / 100);
                }

                double saveangle = ((anglemotherdaughter * PI - PI) + (i * (anglenode * PI))) * randomfactorAngle;
                graphic.rotate(-(saveangle));

                TreeRecursive(graphic, x1, y1, x2, (int) (y2 * (scaling * randomfactorScaling)), scaling, branchespernode, anglenode, anglemotherdaughter, realization, randomness, (strokewidth - 1), ColorList, TreeLevel - 1);
                graphic.translate(0, (int) (y2 * (scaling * randomfactorScaling)));
                graphic.rotate(saveangle);
            }
        }
    }

    public void DrawTree(){
        repaint();
    }
}