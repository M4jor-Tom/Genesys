package genboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import boards.Board;
import generic.AbstractPopulationConstructor;
import generic.Ratio;

public class BoardConstructor extends AbstractPopulationConstructor<Board>{

	private static int populatioSize = 10;
	private static Random random = new Random();
	
	@Override
	public Board crossover(Board populator1, Board populator2) {
		Ratio meanWheelHardness = new Ratio(
			(
				populator1.getWheelHardness().getValue()
				+ populator2.getWheelHardness().getValue()
			) / 2,
			true
		);
		Ratio meanTurning = new Ratio(
			(
				populator1.getTurning().getValue()
				+ populator2.getTurning().getValue()
			) / 2,
			true
		);
		
		return new Board(meanWheelHardness, meanTurning);
	}

	@Override
	protected Board naiveMutation(Board populator) {
		Ratio randomizedRatio = new Ratio(random.nextDouble(), true);
		
		if(random.nextBoolean())
		{
			populator.setWheelHardness(randomizedRatio);
		}
		else
		{
			populator.setTurning(randomizedRatio);
		}
			
		return populator;
	}

	@Override
	protected Board closeMutation(Board populator) {
		Ratio ratioToRandomize = null;
		boolean hardnessNotTurning = random.nextBoolean();
		
		if(hardnessNotTurning) {
			ratioToRandomize = populator.getWheelHardness();
		}
		else {
			ratioToRandomize = populator.getTurning();
		}
		
		Double sign = random.nextBoolean()
			? 1.0
			: -1.0;
		
		ratioToRandomize.setValue(
				ratioToRandomize.getValue()
				+ sign * random.nextDouble() * 0.5
		);
		
		if(hardnessNotTurning) {
			populator.setWheelHardness(ratioToRandomize);
		}
		else {
			populator.setTurning(ratioToRandomize);
		}
		
		return populator;
	}

	@Override
	public List<Board> initalizePopulation() {
		ArrayList<Board> boardArrayList = new ArrayList<Board>();
		
		for(int i = 0; i < populatioSize; i++) {
			boardArrayList.add(
				new Board(
					new Ratio(random.nextDouble(), true),
					new Ratio(random.nextDouble(), true)
				)
			);
		}
		
		return boardArrayList;
	}
}