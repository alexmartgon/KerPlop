package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.util.Random;
public class Giant extends GamePiece{

	Random random = new Random(System.currentTimeMillis());

	public Giant(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) {
			int randInt = random.nextInt(2);
			if(randInt == 0) {
				return InteractionResult.KILL;
			}
			else {
				return InteractionResult.ADVANCE;
			}
		}
		return InteractionResult.NONE;
	}
	
}
