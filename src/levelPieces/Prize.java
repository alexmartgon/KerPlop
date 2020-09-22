package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Prize extends GamePiece{
	
	private boolean collected = false;
	
	public Prize(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation && !collected) {
			collected = true;
			gameBoard[getLocation()] = null;
			return InteractionResult.GET_POINT;
		}
		else return InteractionResult.NONE;
	}
}