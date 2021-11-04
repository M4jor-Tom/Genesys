package generic;

import java.util.Collection;

public class PopulationIterator<Populator> {
	private Collection<Populator> population;
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
			Collection<Populator> population,
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

	public Collection<Populator> getPopulation() {
		return population;
	}

	public void setPopulation(Collection<Populator> population) {
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