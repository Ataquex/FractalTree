package Controller;

import LineBuilder.LineBuilder;
import GUI.GUI;

public class Controller {
    private GUI controllersGUI;
    private LineBuilder controllersLineBuilder;

    public Controller(GUI gui){
        this.controllersGUI = gui;
    }

    public void startController(){
        this.controllersLineBuilder = new LineBuilder();
        this.controllersGUI.GUIstart(this.controllersLineBuilder);
    }
}
