package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.lang.Math;

public class Archer extends GamePiece {

	public Archer(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(playerLocation - getLocation()) == 2)return InteractionResult.KILL; 
		return InteractionResult.NONE;
	}

}
