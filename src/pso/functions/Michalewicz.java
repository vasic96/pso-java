package pso.functions;

import java.util.List;

import pso.logic.FunctionInterface;

public class Michalewicz implements FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        Double sum = 0.0;
        for (int i = 0; i < args.size() - 1; i++) {
            sum += Math.sin(args.get(i)) * Math.pow(Math.sin(((i + 1) * Math.pow(args.get(i), 2)) / Math.PI), 2 * 10);
        }
        return sum * -1.0;
    }
}
