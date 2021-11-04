package generic;

abstract public class AbstractEnvironment<Populator> {
	abstract public double getFitness(Populator populator);
	
	protected static double sigmoid(double input, double strafe)
	{
		double x = input + strafe;
		
	    return 1 / (1 + Math.exp(-x));
	}
}