package Controller;

import LineBuilder.LineBuilder;
import GUI.GUI;
import Model.Model;

public class Controller {
    private GUI controllersGUI;
    private Model controllersModel;
    private LineBuilder controllersLineBuilder;
    private Controller controller;

    public Controller(){
        this.controllersGUI = new GUI();
        this.controllersModel = new Model();
        this.controllersLineBuilder = new LineBuilder();
    }

    public void startController(Controller controller){
        this.controller = controller;
        this.controllersGUI.GUIstart(this.controllersLineBuilder, this.controller);
    }

    public void ChangePerformed(int[] properties){
        this.controllersModel.setFirstBranchLength(properties[0]);
        this.controllersModel.setBranchLengthScaling(properties[1]);
        this.controllersModel.setNumberBranchesPerNode(properties[2]);
        this.controllersModel.setAngleBranchesPerNode(properties[3]);
        this.controllersModel.setAngleMotherToDaughterBranch(properties[4]);
        this.controllersModel.setRealizationLimit(properties[5]);
        this.controllersModel.setRandomness(properties[6]);
        System.out.println("written to model");
    }
}
