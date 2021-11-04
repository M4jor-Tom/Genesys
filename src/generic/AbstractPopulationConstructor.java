package generic;

import java.util.Collection;
import java.util.Random;

abstract public class AbstractPopulationConstructor<Populator> {
	
	//Creates a new Population object from 2 others
	abstract public Populator crossover(Populator populator1, Populator populator2);
	
	//Randomly mutates populator
	abstract protected Populator naiveMutation(Populator populator);
	
	//Closely mutates populator
	abstract protected Populator closeMutation(Populator populator);
	
	//Changes a Population object's characteristic
	public Populator mutation(Populator populator, int muationProbability)
	{
		Random random = new Random();
		
		switch(random.nextInt(muationProbability)) {
			case 0:
				
				break;
			
			case 1:
				break;
		}
		
		return populator;
	}
	
	//Initializes a new population
	abstract public Collection<Populator> initalizePopulation();
}