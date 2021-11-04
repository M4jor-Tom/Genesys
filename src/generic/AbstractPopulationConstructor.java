package generic;

import java.util.List;
import java.util.Random;

abstract public class AbstractPopulationConstructor<Populator> {
	private int defaultPopulationSize;

	public AbstractPopulationConstructor(int defaultPopulationSize) {
		super();
		
		setDefaultPopulationSize(defaultPopulationSize);
	}

	//Creates a new Population object from 2 others
	abstract public Populator crossover(Populator populator1, Populator populator2);
	
	//Randomly mutates populator
	abstract protected Populator naiveMutation(Populator populator);
	
	//Closely mutates populator
	abstract protected Populator closeMutation(Populator populator);
	
	//Changes a Population object's characteristic
	public Populator mutation(Populator populator, Ratio mutationProbability)
	{
		Random random = new Random();
		
		if(mutationProbability.getValue() > random.nextDouble()) {
			switch(random.nextInt(2)) {
				case 0:
					populator = naiveMutation(populator);
					break;
				
				case 1:
					populator = closeMutation(populator);
					break;
			}
		}
		
		return populator;
	}
	
	//Initializes a new population
	abstract public List<Populator> initalizePopulation();

	protected int getDefaultPopulationSize() {
		return defaultPopulationSize;
	}

	private void setDefaultPopulationSize(int defaultPopulationSize) {
		this.defaultPopulationSize = defaultPopulationSize;
	}
}