 package pso.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pso.managers.PsoParamsManager;


public class Particle {

    private Random random;
    private Double lastParticleBestEval;
    private PsoParamsManager psoParams;
    private List<Double> currentPosition;
    private List<Double> acceleration;
    private List<Double> lastBestPosition;

    public Double getlastParticleBestEval() {
        return lastParticleBestEval;
    }

    public List<Double> getCurrentPosition() {
        return currentPosition;
    }

    private Double randBeet(Double min, Double max) {
        return min + random.nextDouble() * (max - min);
    }

    public Particle(PsoParamsManager psoParams) {
        this.random = new Random();
        this.psoParams = psoParams;

        double accelInitDiffAbs = Math.abs(psoParams.getBoundsMax() - psoParams.getBoundsMin());
        double negDiff = -1.0 * accelInitDiffAbs;
        double posDiff = accelInitDiffAbs;
        currentPosition = new ArrayList<Double>(psoParams.getDimension());
        acceleration = new ArrayList<Double>(psoParams.getDimension());

        for (int i = 0; i < psoParams.getDimension(); i++) {


            this.currentPosition.add(randBeet(psoParams.getBoundsMin(), psoParams.getBoundsMax()));


            this.acceleration.add(randBeet(negDiff, posDiff));
        }

        lastBestPosition = new ArrayList<Double>(this.currentPosition);
        this.lastParticleBestEval = psoParams.getFunction().functionEvaluation(currentPosition);
    }

    public void moveParticle(List<Double> swarmLastBestPos) {
        for (int i = 0; i < psoParams.getDimension(); i++) {

            Double accel;
            accel = this.psoParams.getOmegaValue() * this.acceleration.get(i)
                    + this.psoParams.getC1() * randBeet(0.0, 1.0)
                    * (this.lastBestPosition.get(i) - this.currentPosition.get(i))
                    + this.psoParams.getC2() * randBeet(0.0, 1.0)
                    + (swarmLastBestPos.get(i) - this.currentPosition.get(i));

            this.acceleration.set(i, accel);
            this.currentPosition.set(i, this.currentPosition.get(i) + this.acceleration.get(i));
            if(this.currentPosition.get(i)<this.psoParams.getBoundsMin()) {
            	this.currentPosition.set(i, psoParams.getBoundsMin());
            }
            if(this.currentPosition.get(i)>this.psoParams.getBoundsMax()) {
            	this.currentPosition.set(i, psoParams.getBoundsMax());
            }
        }
    }

    public Integer checkParticleLastBestPos() {
        Integer retVal = 0;
        Double newPosEval = this.psoParams.getFunction().functionEvaluation(currentPosition);
        if (newPosEval < this.lastParticleBestEval) {
            this.lastParticleBestEval = newPosEval;
            this.lastBestPosition = new ArrayList<Double>(this.currentPosition);
            retVal = 1;
        }
        return retVal;
    }

    public List<Double> getLastBestPosition() {
        return lastBestPosition;
    }

	public PsoParamsManager getPsoParams() {
		return psoParams;
	}

	public void setPsoParams(PsoParamsManager psoParams) {
		this.psoParams = psoParams;
	}
    
    
}
