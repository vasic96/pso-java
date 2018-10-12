package pso.functions;

import java.util.List;

import pso.logic.FunctionInterface;


public class Parabol implements FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        Double result = 0.0;
        for (int i = 0; i < args.size(); i++) {
            result += args.get(i) * args.get(i);
        }
        return result;
    }
}