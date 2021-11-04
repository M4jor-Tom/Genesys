package mainpackage;

import boards.Board;
import genboard.BoardConstructor;
import genboard.SlickRoadEnvironment;
import generic.PopulationIterator;

public class MainClass {
	
	public static void main(String[] args) {

		PopulationIterator<Board, BoardConstructor> populationIterator =
			new PopulationIterator<Board, BoardConstructor>(new BoardConstructor(), new SlickRoadEnvironment());
		

	}
}