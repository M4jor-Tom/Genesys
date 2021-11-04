package genboard;

import boards.Board;
import generic.AbstractEnvironment;

public class SkateParkEnvironment extends AbstractEnvironment<Board>{

	@Override
	public double getFitness(Board populator) {
		return
			populator.getTurning().getValue()
			* populator.getWheelHardness().getValue();
	}

}