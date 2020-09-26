package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Archer;
import levelPieces.Branch;
import levelPieces.Giant;
import levelPieces.Horse;
import levelPieces.Prize;
import levelPieces.Rat;
import levelPieces.Thorn;

class TestInteractions {

	@Test
	public void testArcher() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Archer Bob = new Archer('A', "Bob",10);
		gameBoard[10] = Bob;
		// Hit points if player on same space
		assertEquals(InteractionResult.KILL, Bob.interact(gameBoard, 8));
		assertEquals(InteractionResult.KILL, Bob.interact(gameBoard, 12));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<8; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=9; i<12; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
	}		

	//No interactions for Branch class

	@Test
	public void testGiant() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Giant Bob = new Giant('G', "Bob",10);
		gameBoard[10] = Bob;
		// Hit points if player on same space
		if(Bob.interact(gameBoard, 10)== InteractionResult.KILL) {
			assertEquals(InteractionResult.KILL, Bob.interact(gameBoard, 10));
		}
		if(Bob.interact(gameBoard, 10)== InteractionResult.ADVANCE) {
			assertEquals(InteractionResult.ADVANCE, Bob.interact(gameBoard, 10));
		}
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
	}		

	@Test
	public void testHorse() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Horse Bob = new Horse('H', "Bob",10);
		gameBoard[10] = Bob;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, Bob.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
	}		

	@Test
	public void testPrize() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize Bob = new Prize('P', "Bob",10);
		gameBoard[10] = Bob;
		// Hit points if player on same space
		assertEquals(InteractionResult.GET_POINT, Bob.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
	}		

	@Test
	public void testRat() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Rat Bob = new Rat('R', "Bob",10);
		gameBoard[10] = Bob;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, Bob.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
	}	
	
	@Test
	public void testThorn() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Thorn Bob = new Thorn('T', "Bob",10);
		gameBoard[10] = Bob;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, Bob.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, Bob.interact(gameBoard, i));
	}	


}
