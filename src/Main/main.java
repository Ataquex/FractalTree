package Main;

import Controller.Controller;
import GUI.GUI;

public class main{

    public static void main (String[] args){
        Controller controller = new Controller();
        controller.startController(controller);
    }
}
