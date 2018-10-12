package pso.view;

import java.util.List;

import pso.managers.PsoParamsManager;


public class ConsolePrinter {

    public static void printResults(List<Double> minimum, PsoParamsManager p) {
        System.out.println("Testirana funkcija: " + p.getFunction());
        for (int i = 0; i < minimum.size(); i++) {
        	
            System.out.println("Koordinata:" + i + " = " + minimum.get(i));
        }
        System.out.println("Globalni minimum = " + p.getFunction().functionEvaluation(minimum));
    }
}
