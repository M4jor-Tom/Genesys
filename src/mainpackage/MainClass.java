package mainpackage;

import boards.Board;
import genboard.BoardConstructor;
import genboard.SlickRoadEnvironment;
import generic.PopulationIterator;
import generic.Ratio;

public class MainClass {
	
	public static void main(String[] args) {

		PopulationIterator<Board> populationIterator = new PopulationIterator<Board>(
					new BoardConstructor(10),
					new SlickRoadEnvironment(),
					new Ratio(0.1, true)
		);
		
		while(true) {
			populationIterator.iterate();
			
			cleanConsole();
			System.out.println(populationIterator.populationToString());
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void cleanConsole() {
		for(int i = 0; i < 30; i ++) {
			System.out.println("\n");
		}
	}
}