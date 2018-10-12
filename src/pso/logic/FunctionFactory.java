package pso.logic;

import pso.functions.Ackley;
import pso.functions.Bohachevsky1;
import pso.functions.Bohachevsky2;
import pso.functions.Easom;
import pso.functions.Michalewicz;
import pso.functions.Parabol;
import pso.functions.Rastrigin;
import pso.functions.SchafferF6;
import pso.functions.SchafferF7;

public class FunctionFactory {
	
	
	public static FunctionInterface getFunction(String functionName) {
		
		switch (functionName) {
		case "rastrigin":
			return new Rastrigin();
		case "ackley":
			return new Ackley();
		case "bohachevsky1":
			return new Bohachevsky1();
		case "bohachevsky2":
			return new Bohachevsky2();
		case "easom":
			return new Easom();
		case "michalewicz":
			return new Michalewicz();
		case "parabol":
			return new Parabol();
		case "schafferf6":
			return new SchafferF6();
		case "schafferf7":
			return new SchafferF7();
		default:
			return null;
		}
		
		
	}
	

}
