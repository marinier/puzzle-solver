package org.marinier.dumb_ai.snakes_and_ladders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.marinier.dumb_ai.Puzzle;

public class SnakesAndLadders implements Puzzle {

	private final Random rand = new Random();
	private final Board board = new Board();
	private final List<Integer> solution = new ArrayList<>(1000);
	
	@Override
	public void initialize() {
		board.reset();
		solution.clear();
	}
	
	@Override
	public boolean playOnce() {
		
		// roll a number between 1 and 6
		final int roll = rand.nextInt(6) + 1;
		solution.add(roll);
		return board.move(roll);
	}
	
	@Override
	public double getSolutionQuality() {
		if(board.isSolved()) return 1.0 / solution.size();
		return 0;
	}
	
	@Override
	public String toString() {
		return solution.toString();
	}

}
