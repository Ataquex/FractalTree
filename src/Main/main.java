package Main;

import Controller.Controller;

import java.util.concurrent.ThreadLocalRandom;

public class main{

    public static void main (String[] args){

        Controller controller = new Controller();
        controller.startController(controller);
    }
}
