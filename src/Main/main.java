package Main;

import Controller.Controller;
import GUI.GUI;

public class main{

    public static void main (String[] args){
        GUI gui = new GUI();
        Controller controller = new Controller(gui);

        controller.startController();
    }
}
