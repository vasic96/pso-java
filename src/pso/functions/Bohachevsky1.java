package pso.functions;

import java.util.List;


public class Bohachevsky1 implements pso.logic.FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        return Math.pow(args.get(0), 2) + 2 * Math.pow(args.get(1), 2)
                - 0.3 * Math.cos(3 * Math.PI * args.get(0)) - 0.4 * Math.cos(4 * Math.PI * args.get(1)) + 0.7;
    }
}
