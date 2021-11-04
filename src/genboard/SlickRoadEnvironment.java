package genboard;

import boards.Board;
import generic.AbstractEnvironment;

public class SlickRoadEnvironment extends AbstractEnvironment<Board> {

	@Override
	public double getFitness(Board populator) {
		return
			(1.0 - populator.getTurning().getValue())
			* (1.0 - populator.getWheelHardness().getValue());
	}

}