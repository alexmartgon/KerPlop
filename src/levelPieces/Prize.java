package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Prize extends GamePiece{
	/*
	 * The goal of the Prize be collected by the player and awards points
	 */
	private boolean collected = false; //boolean to see if the prize has been collected
	
	public Prize(char symbol, String name, int location) { // constructor
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation && !collected) {
			collected = true;
			gameBoard[getLocation()] = null;
			return InteractionResult.GET_POINT; // award a point if the player comes into contact with the prize
		}
		else return InteractionResult.NONE; // base case
	}
}