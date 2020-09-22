package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Thorn extends GamePiece{
	/*
	 * The goal of the Thorn is to not move and hurt the player if they step onto it
	 */
	public Thorn(char symbol, String name, int location) { // constructor
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) return InteractionResult.HIT; // if the player and the thorn are in the same space, hit the player
		return InteractionResult.NONE; // base case
	}
}
