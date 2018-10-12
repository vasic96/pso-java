package pso.functions;

import java.util.List;

import pso.logic.FunctionInterface;


public class Ackley implements FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        Double sum1 = 0.0;
        Double sum2 = 0.0;
        int i;
        for (i = 0; i < args.size() - 1; i++) {
            sum1 += args.get(i) * args.get(i);
            sum2 += Math.cos(2 * Math.PI * args.get(i));
        }
        //TODO cast to Double
        return -20 * Math.exp(0.2 * Math.sqrt(1 / (double) args.size() * sum1)) - Math.exp(1 / (double) args.size() * sum2) + 20 + Math.E;
    }
}
