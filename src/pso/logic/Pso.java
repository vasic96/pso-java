package pso.logic;

import java.util.List;

import pso.managers.PsoParamsManager;


public class Pso {

    private Swarm s;
    private PsoParamsManager p;

    public Pso(PsoParamsManager p) {
        this.p = p;
        this.s = new Swarm(p);
    }

    public List<Double> getMinimum() {

        for (int i = 0; i < p.getIterations(); i++) {
            s.moveSwarm();
           
        }

        return s.getSwarmBestPosition();
    }

	public Swarm getS() {
		return s;
	}

	public void setS(Swarm s) {
		this.s = s;
	}

	public PsoParamsManager getP() {
		return p;
	}

	public void setP(PsoParamsManager p) {
		this.p = p;
	}
    
    
}
