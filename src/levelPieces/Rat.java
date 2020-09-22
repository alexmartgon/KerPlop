package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Rat extends GamePiece implements Moveable, Drawable{

	public Rat(char symbol, String name, int location) {
		super(symbol, name, location);
	}


	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		for (int i = 0; i < gameBoard.length; i++){
			if(i == getLocation()) {

				if ((i+1) != 21 && gameBoard[i+1] == null){
					gameBoard[i+1] = gameBoard[i];
					setLocation(getLocation()+1);
					gameBoard[i] = null;
					break;
				}
				else if(i == 20) {
					for(int x = 0; x < gameBoard.length; x++) {
						if(gameBoard[x] == null) {
							gameBoard[x] = gameBoard[i];
							setLocation(x);
							gameBoard[i] = null;
							break;
						}
					}
				}
				else if(gameBoard[i+1] != null) {
					for (int x = i+1; x < 21; x++) {
						if(gameBoard[x] == null) {
							gameBoard[x] = gameBoard[i];
							setLocation(x);
							gameBoard[i] = null;
							break;
						}
						if(x == 20) {
							for(int y = 0; y < gameBoard.length; y++) {
								if(gameBoard[y] == null) {
									gameBoard[y] = gameBoard[i];
									setLocation(y);
									gameBoard[i] = null;
									break;
								}
							}
						}
					}break;
				}
			}
		}
	}


	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation == getLocation()) return InteractionResult.HIT;
		else return InteractionResult.NONE;
	}
}
