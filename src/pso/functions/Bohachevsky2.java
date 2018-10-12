package pso.functions;

import java.util.List;

import pso.logic.FunctionInterface;


public class Bohachevsky2 implements FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        return Math.pow(args.get(0), 2) + 2 * Math.pow(args.get(1), 2)
                - 0.3 * (Math.cos(3 * Math.PI * args.get(0)) * Math.cos(4 * Math.PI * args.get(1))) + 0.3;
    }
}
