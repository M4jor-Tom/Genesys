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
	
	public void iterate() {
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