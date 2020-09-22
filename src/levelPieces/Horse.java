package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class Horse extends GamePiece implements Moveable{
	
	/*
	 * The goal of the Horse is to be reallyyyyy annoying, it can randomly teleport anywhere, and if the player moves to a square where the horse is, it will hurt them.
	 */
 
	Random random = new Random(System.currentTimeMillis()); // new random with a time based seed so it is always different
	
	
	public Horse(char symbol, String name, int location) { //constructor
		super(symbol, name, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) { // since the horse moves it gets a move method
		int randInt = random.nextInt(21); // random int between 0 and 20
		if(gameBoard[randInt] == null) {
			gameBoard[randInt] = gameBoard[getLocation()];
			gameBoard[getLocation()] = null;
			setLocation(randInt); //if the location randomly generated is empty, then the horse will move there
		}
		else {
			move(gameBoard, playerLocation); // recursive call so that the horse will check as may spaces as necessary to get a free one.
		}									 // this also guarantees that the player must  move into the horse to get injured, not the other way around.
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) return InteractionResult.HIT; //tests to see if the player and the Horse are occupying the same space
		else return InteractionResult.NONE; // base case
	}
}
