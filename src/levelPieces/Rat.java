package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Rat extends GamePiece implements Moveable, Drawable{
	/*
	 * The goal of the Rat is to be annoying, bite the player, and move to the right into unoccupied spaces
	 */
	public Rat(char symbol, String name, int location) { // constructor
		super(symbol, name, location);
	}


	@Override
	public void move(Drawable[] gameBoard, int playerLocation) { //very complicated rat movement
		for (int i = 0; i < gameBoard.length; i++){
			if(i == getLocation()) { // if the loop is looking at the rat's location

				if ((i+1) != 21 && gameBoard[i+1] == null){ // if the rat isn't going to go off of the board and if the next space is empty
					gameBoard[i+1] = gameBoard[i];
					setLocation(getLocation()+1);
					gameBoard[i] = null; // move the rat to that new spot
					break; // break to ensure that the for loop iterates 
				}
				else if(i == 20) { // if the rat is at the end of the board, find a new spot starting from zero, finding the first empty spot
					for(int x = 0; x < gameBoard.length; x++) {
						if(gameBoard[x] == null) {
							gameBoard[x] = gameBoard[i];
							setLocation(x);
							gameBoard[i] = null;  // move the rat to that new spot
							break; // break to ensure that the for loop iterates 
						}
					}
				}
				else if(gameBoard[i+1] != null) { // if the next space is full, go to the one after that
					for (int x = i+1; x < 21; x++) {
						if(gameBoard[x] == null) {
							gameBoard[x] = gameBoard[i];
							setLocation(x);
							gameBoard[i] = null;  // move the rat to that new spot
							break; // break to ensure that the for loop iterates 
						}
						if(x == 20) {
							for(int y = 0; y < gameBoard.length; y++) {
								if(gameBoard[y] == null) {
									gameBoard[y] = gameBoard[i];
									setLocation(y);
									gameBoard[i] = null;  // move the rat to that new spot
									break; // break to ensure that the for loop iterates 
								}
							}
						}
					}break; // break to ensure that the for loop iterates 
				}
			}
		}
	}


	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation == getLocation()) return InteractionResult.HIT; //if the players location is the same as the prize, award a point
		else return InteractionResult.NONE; // base case
	}
}
