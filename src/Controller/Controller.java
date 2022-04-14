package Controller;

import LineBuilder.LineBuilder;
import GUI.GUI;
import Model.Model;

public class Controller {
    private GUI controllersGUI;
    private Model controllersModel;
    private LineBuilder controllersLineBuilder;

    public Controller(){
        this.controllersGUI = new GUI();
        this.controllersModel = new Model();
        this.controllersLineBuilder = new LineBuilder(this.controllersModel);
    }

    public void startController(Controller controller){
        this.controllersGUI.GUIstart(this.controllersLineBuilder, controller);
    }

    public void WriteToModel(int[] properties){
        this.controllersModel.setFirstBranchLength(properties[0]);
        this.controllersModel.setBranchLengthScaling(properties[1]);
        this.controllersModel.setNumberBranchesPerNode(properties[2]);
        this.controllersModel.setAngleBranchesPerNode(properties[3]);
        this.controllersModel.setAngleMotherToDaughterBranch(properties[4]);
        this.controllersModel.setRealizationLimit(properties[5]);
        this.controllersModel.setRandomness(properties[6]);
    }

    public void ChangePerformed(){
        this.controllersLineBuilder.DrawTree();
    }
}
