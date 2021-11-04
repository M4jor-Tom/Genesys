package generic;

import java.util.List;
import java.util.Random;

public class PopulationIterator<Populator> {
	private static Random random = new Random();
	
	private List<Populator> population;
	private AbstractPopulationConstructor<Populator> populationConstructor;
	private AbstractEnvironment<Populator> environment;
	private Ratio mutationProbability;

	public PopulationIterator(
			AbstractPopulationConstructor<Populator> populationConstructor,
			AbstractEnvironment<Populator> environment,
			Ratio mutationProbability
		) {
		this(null, populationConstructor, environment, mutationProbability);
		
		setPopulation(getPopulationConstructor().initalizePopulation());
	}

	public PopulationIterator(
			List<Populator> population,
			AbstractPopulationConstructor<Populator> populationConstructor,
			AbstractEnvironment<Populator> environment,
			Ratio mutationProbability
		) {
		super();
		
		setPopulation(population);
		setPopulationConstructor(populationConstructor);
		setEnvironment(environment);
		setMutationProbability(mutationProbability);
	}
	
	private Populator pickPopulator(Populator otherThanPopulator) {
		Double totalFitness = 0.0;
		
		//Summing all fitnesses
		for(Populator populator: getPopulation()) {
			totalFitness += getEnvironment().getFitness(populator);
		}
		
		//Selecting a fitness cursor smaller than the sum of all of them
		Double fitnessCursor = totalFitness * random.nextDouble();
		
		//Selecting a fitness wheighted random populator
		for(Populator populator: getPopulation()) {
			fitnessCursor -= getEnvironment().getFitness(populator);
			
			if(fitnessCursor < 0.0) {
				if(populator.equals(otherThanPopulator)) {
					//Picked preselected parent, have to find another instead so searches again
					return pickPopulator(otherThanPopulator);
				}
				else {
					return populator;
				}
			}
		}
		
		(new Exception("Error finding a parent")).printStackTrace();
		
		return null;
	}
	
	private void removeLowestFittedPopulator() {
		Populator lowestFitnessPopulator = null;
		
		for(Populator populator: getPopulation()) {
			
			if(lowestFitnessPopulator == null) {
				//Selecting first populator
				lowestFitnessPopulator = populator;
			}
			else {
				//Selecting lowest fitted populator
				if(
					getEnvironment().getFitness(lowestFitnessPopulator)
					> getEnvironment().getFitness(populator)
				) {
					//Lowest fitness populator changes to the current one
					lowestFitnessPopulator = populator;
				}
			}
		}
		
		//Removing lowest fitness populator from population
		getPopulation().remove(lowestFitnessPopulator);
	}
	
	public void iterate() {
		//Picking different parents
		Populator parent1 = pickPopulator(null);
		Populator parent2 = pickPopulator(parent1);
		
		//Borning a new populator from two others
		Populator populator = getPopulationConstructor().crossover(parent1, parent2);

		//Replacing the lowest fitted populator in list
		addPopulator(populator);
		removeLowestFittedPopulator();
		
		//Randomly mutating populators
		for(Populator iterationPopulator: getPopulation()) {
			getPopulationConstructor().mutation(iterationPopulator, getMutationProbability());
		}
	}
	
	public String populationToString()
	{
		String ret = "";
		
		for(Populator populator: getPopulation()) {
			ret += populator.toString() + "\n";
		}
		
		return ret;
	}
	
	public void addPopulator(Populator populator) {
		List<Populator> population = getPopulation();
		population.add(populator);
		setPopulation(population);
	}

	public List<Populator> getPopulation() {
		return population;
	}

	public void setPopulation(List<Populator> population) {
		this.population = population;
	}

	public AbstractPopulationConstructor<Populator> getPopulationConstructor() {
		return populationConstructor;
	}

	private void setPopulationConstructor(AbstractPopulationConstructor<Populator> populationConstructor) {
		this.populationConstructor = populationConstructor;
	}

	public AbstractEnvironment<Populator> getEnvironment() {
		return environment;
	}

	public void setEnvironment(AbstractEnvironment<Populator> environment) {
		this.environment = environment;
	}
	
	public Ratio getMutationProbability() {
		return mutationProbability;
	}

	public void setMutationProbability(Ratio mutationProbability) {
		this.mutationProbability = mutationProbability;
	}
}