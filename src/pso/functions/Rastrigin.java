package pso.functions;

import java.util.List;


public class Rastrigin implements pso.logic.FunctionInterface {

    @Override
    public Double functionEvaluation(List<Double> args) {
        Double sum = (double) (10 * args.size());
        
        for(Double parameter:args) {
        	   sum += Math.pow(parameter, 2.0) - 10.0 * Math.cos(2 * Math.PI * parameter); 
        }
        
        return sum;
        
    }
}

