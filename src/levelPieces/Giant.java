package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.Random;
public class Giant extends GamePiece{
	
	/*
	 * The goal of the Giant is to be a gamble; either the Giant kills the player, or it moves them forward to the next level.
	 */

	Random random = new Random(System.currentTimeMillis()); // new random with a time based seed so it is always different

	public Giant(char symbol, String name, int location) { //constructor
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) { //tests to see if the player and the Giant are occupying the same space
			int randInt = random.nextInt(2); // random int between 0 and 1 inclusive
			if(randInt == 0) {
				return InteractionResult.KILL; // kill case
			}
			else {
				return InteractionResult.ADVANCE; // advance case
			}
		}
		return InteractionResult.NONE; // base case (no interaction)
	}
}
