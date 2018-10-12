package pso;

import java.util.List;

import pso.functions.Ackley;
import pso.functions.Easom;
import pso.functions.Michalewicz;
import pso.functions.Parabol;
import pso.functions.Rastrigin;
import pso.logic.Pso;
import pso.managers.PsoParamsManager;
import pso.view.ConsolePrinter;



public class JPso {


    public static void main(String args[]) {
        PsoParamsManager p = new PsoParamsManager();
        p.setParticlesNumber(20);
        p.setC1(1.0);
        p.setC2(1.0);
        p.setOmegaValue(0.9);
        p.setBoundsMax(5.12);
        p.setBoundsMin(-5.12);
        p.setIterations(100);
        p.setDimension(3);
        p.setFunction("rastrigin");

        Pso pso = new Pso(p);
        List<Double> globalMin = pso.getMinimum();
        ConsolePrinter.printResults(globalMin, p);
    }

}
