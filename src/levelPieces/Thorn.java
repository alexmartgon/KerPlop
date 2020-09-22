package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Thorn extends GamePiece{

	public Thorn(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
