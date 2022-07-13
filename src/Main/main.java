package Main;

import Controller.Controller;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class main{

    public static void main (String[] args){

        Controller controller = new Controller();
        controller.startController(controller);
    }
}
