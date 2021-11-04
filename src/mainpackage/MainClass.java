package mainpackage;

import java.util.InputMismatchException;
import java.util.Scanner;

import boards.Board;
import genboard.BoardConstructor;
import genboard.SkateParkEnvironment;
import genboard.SlickRoadEnvironment;
import generic.AbstractEnvironment;
import generic.PopulationIterator;
import generic.Ratio;

public class MainClass {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Population size: ");
		int populationSize = scanner.nextInt();
		
		System.out.println("Environment:\n1.SkatePark\n2(or any).Slick road");
		int environmentChoice = 0;
		try{
			environmentChoice = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			
		}
		
		AbstractEnvironment<Board> environment = environmentChoice == 1
			? new SkateParkEnvironment()
			: new SlickRoadEnvironment();

		PopulationIterator<Board> populationIterator = new PopulationIterator<Board>(
					new BoardConstructor(populationSize),
					environment,
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