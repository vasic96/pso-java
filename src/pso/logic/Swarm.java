/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pso.logic;

import java.util.ArrayList;
import java.util.List;

import pso.managers.PsoParamsManager;


public class Swarm {

    private Double lastSwarmBestEval;
    private PsoParamsManager psoParams;
    private List<Particle> particles;
    private List<Double> swarmBestPosition;

    public Double getLastSwarmBestEval() {
        return lastSwarmBestEval;
    }

    public List<Double> getSwarmBestPosition() {
        return swarmBestPosition;
    }

    public Swarm(PsoParamsManager psoParams) {
        this.psoParams = psoParams;
        swarmBestPosition = new ArrayList<Double>(psoParams.getDimension());
        particles = new ArrayList<Particle>(psoParams.getParticlesNumber());
        for (int i = 0; i < psoParams.getParticlesNumber(); i++) {
            this.particles.add(new Particle(psoParams));

            if (i == 0) {
                this.swarmBestPosition = new ArrayList<Double>(particles.get(0).getCurrentPosition());

            }
        }
        this.lastSwarmBestEval = psoParams.getFunction().functionEvaluation(swarmBestPosition);

    }

    public void moveSwarm() {
    	this.psoParams.setOmegaValue(this.psoParams.getOmegaValue() - (this.psoParams.getOmegaDif() /this.psoParams.getIterations()));
        for (int i = 0; i < psoParams.getParticlesNumber(); i++) {
        	particles.get(i).setPsoParams(this.psoParams);
            particles.get(i).moveParticle(this.getSwarmBestPosition());

            if ((particles.get(i).checkParticleLastBestPos()) == 1) {
                checkSwarmLastBestPos(particles.get(i));
            }
        }
    }

    private void checkSwarmLastBestPos(Particle p) {
        if (p.getlastParticleBestEval() < this.getLastSwarmBestEval()) {
            this.lastSwarmBestEval = p.getlastParticleBestEval();
            this.swarmBestPosition = new ArrayList<Double>(p.getLastBestPosition());
        }
    }

	public void setLastSwarmBestEval(Double lastSwarmBestEval) {
		this.lastSwarmBestEval = lastSwarmBestEval;
	}
    
    
}
