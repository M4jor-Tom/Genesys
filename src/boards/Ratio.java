package boards;

public class Ratio {
	private double value;

	public Ratio(double value) {
		super();
		
		setValue(value);
	}

	public double getValue() {
		return value;
	}

	private void setValue(double value) {
		if(value > 1.0 || value < 0.0) {
			System.out.println("Ratio: value (" + value + ") out of bounds (0.0 - 1.0)");
		}
		
		this.value = value;
	}
}