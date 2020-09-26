package levelPieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;

class TestMovingPieces {

	@Test
	public void testRandomMovement() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Branch();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Branch();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Branch();

		Horse Brad = new Horse('H', "Brad", 6);
		gameBoard[6] = Brad;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			Brad.move(gameBoard, 13);
			int loc = Brad.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 1);
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);	
	}


	@Test
	public void testRightwardMovement() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Branch();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Branch();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Branch();

		Rat Chad = new Rat('H', "Brad", 6);
		gameBoard[6] = Chad;


		for(int i = 0; i < 200; i++) {

			Chad.move(gameBoard, 13);
			int loc = Chad.getLocation();
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20 && loc != 13)
				fail("Invalid square selected");
		} 		
	}

}
