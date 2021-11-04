package generic;

import java.util.List;

public class PopulationIterator<Populator> {
	private List<Populator> population;
	private AbstractPopulationConstructor<Populator> populationConstructor;
	private AbstractEnvironment<Populator> environment;
	
	public PopulationIterator(
			AbstractPopulationConstructor<Populator> populationConstructor,
			AbstractEnvironment<Populator> environment
		) {
		this(null, populationConstructor, environment);
		
		setPopulation(getPopulationConstructor().initalizePopulation());
	}

	public PopulationIterator(
			List<Populator> population,
			AbstractPopulationConstructor<Populator> populationConstructor,
			AbstractEnvironment<Populator> environment
		) {
		super();
		
		setPopulation(population);
		setPopulationConstructor(populationConstructor);
		setEnvironment(environment);
	}
	
	public void iterate() {
		
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
}