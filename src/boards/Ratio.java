package boards;

public class Ratio {
	private double value;

	public Ratio(double value, boolean strict) {
		super();
		
		if(strict) {
			strictSetValue(value);
		}
		else {
			setValue(value);
		}
	}

	public double getValue() {
		return value;
	}
	
	public void setValue(double value)
	{
		if(Ratio.valueIsTooHigh(value)) {
			this.value = 1.0;
		}
		else if(Ratio.valueIsTooLow(value)) {
			this.value = 0.0;
		}
		else {
			this.value = value;
		}
	}

	public void strictSetValue(double value) {
		this.value = Double.NaN;
		
		if(Ratio.valueIsOutOfBounds(value)) {
			System.out.println("Ratio: value (" + value + ") out of bounds (0.0 - 1.0)");
		}
		else {
			this.value = value;
		}
	}
	
	private static boolean valueIsTooHigh(double value) {
		return value > 1.0;
	}
	
	private static boolean valueIsTooLow(double value) {
		return value < 0.0;
	}
	
	private static boolean valueIsOutOfBounds(double value) {
		return Ratio.valueIsTooHigh(value) || Ratio.valueIsTooLow(value);
	}
}