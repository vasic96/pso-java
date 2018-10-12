package web;

import java.util.List;

public class CalculationResult {
	
	private Double minimumValue;
	private List<Double> minimumPosition;
	
	public CalculationResult(Double minimumValue,List<Double> minimumPosition) {
		this.minimumPosition = minimumPosition;
		this.minimumValue = minimumValue;
	}

	public Double getMinimumValue() {
		return minimumValue;
	}

	public List<Double> getMinimumPosition() {
		return minimumPosition;
	}
	
	

}
