package mainpackage;

import boards.Board;
import genboard.BoardConstructor;
import genboard.SlickRoadEnvironment;
import generic.PopulationIterator;

public class MainClass {
	
	public static void main(String[] args) {

		PopulationIterator<Board> populationIterator =
			new PopulationIterator<Board>(new BoardConstructor(), new SlickRoadEnvironment());
		

	}
}