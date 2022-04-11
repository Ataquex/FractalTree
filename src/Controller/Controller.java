package Controller;

import GUI.GUI;

public class Controller {
    private GUI controllersGUI;

    public Controller(GUI gui){
        this.controllersGUI = gui;
    }

    public void startController(){
        this.controllersGUI.GUIstart(controllersGUI);
    }
}
