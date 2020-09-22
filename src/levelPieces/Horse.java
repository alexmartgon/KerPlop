package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class Horse extends GamePiece implements Moveable{

	Random random = new Random(System.currentTimeMillis());
	
	
	public Horse(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int randInt = random.nextInt(21);
		if(gameBoard[randInt] == null ) {
			gameBoard[randInt] = gameBoard[getLocation()];
			gameBoard[getLocation()] = null;
			setLocation(randInt);
		}
		else {
			move(gameBoard, playerLocation);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) return InteractionResult.HIT;
		else return InteractionResult.NONE;
	}

}
