/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.managers;

import pso.functions.Ackley;
import pso.functions.Bohachevsky1;
import pso.functions.Bohachevsky2;
import pso.functions.Easom;
import pso.functions.Michalewicz;
import pso.functions.Parabol;
import pso.functions.Rastrigin;
import pso.functions.SchafferF6;
import pso.functions.SchafferF7;
import pso.logic.FunctionInterface;


public class PsoParamsManager {

    private Integer dimension;
    private Integer iterations;
    private Integer particlesNumber;
    private Double omegaValue;
    private Double omegaMin;
    private Double omegaDif;
    private Double c1;
    private Double c2;
    private Double boundsMax;
    private Double boundsMin;
    private FunctionInterface function;

    public Integer getDimension() {
        return dimension;
    }

    public Integer getIterations() {
        return iterations;
    }

    public Integer getParticlesNumber() {
        return particlesNumber;
    }

    public Double getOmegaValue() {
        return omegaValue;
    }

    public Double getC1() {
        return c1;
    }

    public Double getC2() {
        return c2;
    }

    public Double getBoundsMax() {
        return boundsMax;
    }

    public Double getBoundsMin() {
        return boundsMin;
    }

    public FunctionInterface getFunction() {
        return function;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public void setParticlesNumber(Integer particlesNumber) {
        this.particlesNumber = particlesNumber;
    }

    public void setOmegaValue(Double omegaValue) {
        this.omegaValue = omegaValue;
    }

    public void setC1(Double fiParticle) {
        this.c1 = fiParticle;
    }

    public void setC2(Double fiSwarm) {
        this.c2 = fiSwarm;
    }

    public void setBoundsMax(Double psoMaxPerVecElem) {
        this.boundsMax = psoMaxPerVecElem;
    }

    public void setBoundsMin(Double psoMinPerVecElem) {
        this.boundsMin = psoMinPerVecElem;
    }

    public void setFunction(String functionName) {
		switch (functionName) {
		case "rastrigin":
			this.function = new Rastrigin();
			this.boundsMin = -5.12;
			this.boundsMax = 5.12;
			break;
		case "ackley":
			this.function = new Ackley();
			this.boundsMin = -32.768;
			this.boundsMax = 32.768;
			break;
		case "bohachevsky1":
			this.function = new Bohachevsky1();
			this.boundsMin = -100.0;
			this.boundsMax = 100.0;
			break;
		case "bohachevsky2":
			this.function = new Bohachevsky2();
			this.boundsMin = -100.0;
			this.boundsMax = 100.0;
			break;
		case "easom":
			this.function = new Easom();
			this.boundsMin = -100.0;
			this.boundsMax = 100.0;
			break;
		case "michalewicz":
			this.function = new Michalewicz();
			this.boundsMin = -0.0;
			this.boundsMax = Math.PI;
			break;
		case "parabol":
			this.function = new Parabol();
			this.boundsMin = -100.0;
			this.boundsMax = 100.0;
			break;
		case "schafferf6":
			this.function = new SchafferF6();
			this.boundsMin = -100.0;
			this.boundsMax = 100.0;
			break;
		case "schafferf7":
			this.function = new SchafferF7();
			this.boundsMin = -100.0;
			this.boundsMax = 100.0;
			break;
		default:
			this.function = new Rastrigin();
			this.boundsMin = -5.12;
			this.boundsMax = 5.12;
			break;
		}
    }
    

    public Double getOmegaDif() {
		return omegaDif;
	}

	public void setOmegaDif(Double omegaDif) {
		this.omegaDif = omegaDif;
	}

	public Double getOmegaMin() {
		return omegaMin;
	}

	public void setOmegaMin(Double omegaMin) {
		this.omegaMin = omegaMin;
	}

	public void printResultsForTestPurposes(PsoParamsManager p) {
        System.out.println(p.getDimension());
        System.out.println(p.getC1());
        System.out.println(p.getC2());
        System.out.println(p.getIterations());
        System.out.println(p.getOmegaValue());
        System.out.println(p.getParticlesNumber());
        System.out.println(p.getBoundsMax());
        System.out.println(p.getBoundsMin());
        System.out.println(p.getFunction());
    }

}