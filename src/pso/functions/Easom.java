package pso.functions;

import java.util.List;

import pso.logic.FunctionInterface;


public class Easom implements FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        return -Math.cos(args.get(0)) * Math.cos(args.get(1))
                * Math.pow(Math.E, -Math.pow(args.get(0) - Math.PI, 2) - Math.pow(args.get(1) - Math.PI, 2));
    }
}
