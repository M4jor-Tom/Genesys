package genboard;

import java.util.ArrayList;
import java.util.Collection;

import boards.Board;
import generic.AbstractPopulationConstructor;

public class BoardConstructor extends AbstractPopulationConstructor<Board>{

	@Override
	public Board crossover(Board populator1, Board populator2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Board naiveMutation(Board populator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Board closeMutation(Board populator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Board> initalizePopulation() {
		ArrayList<Board> boardArrayList = new ArrayList<Board>();
		
		
		
		return boardArrayList;
	}
}