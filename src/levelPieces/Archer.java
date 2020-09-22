package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.lang.Math;

public class Archer extends GamePiece {
	/*
	 * The goal of the Archer is to shoot at the player if they are two spaces away in either direction, no more, no less
	 */
	public Archer(char symbol, String name, int location) { //constructor
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(playerLocation - getLocation()) == 2)return InteractionResult.KILL; //code that checks to see if the player is in range
		return InteractionResult.NONE; // base case
	}
}
