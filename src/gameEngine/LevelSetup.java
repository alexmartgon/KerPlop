package gameEngine;

import java.util.ArrayList;

import levelPieces.Archer;
import levelPieces.Branch;
import levelPieces.GamePiece;
import levelPieces.Giant;
import levelPieces.Horse;
import levelPieces.Prize;
import levelPieces.Rat;
import levelPieces.Thorn;

public class LevelSetup{
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	private Drawable[] Board = new Drawable[21];
	private final int PLAYER_START_LOCATION = 10;
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
	public LevelSetup() {

	}

	public void createLevel(int levelNum) {
		// TODO Auto-generated method stub
		for(int i = 0; i < Board.length; i++) {
			if (Board[i] != null) {
				Board[i] = null;
			}
		}
		for(int i = 0; i < interactingPieces.size(); i++) {
			interactingPieces.remove(0);
		}
		switch(levelNum) {
		case 1:
			Board[1] = new Thorn('T', "Thorn", 1);
			Board[3] = new Horse('H', "Horse", 3);
			Board[6] = new Archer('A', "Archer", 6);
			Board[7] = new Prize('X', "Prize", 7);
			Board[11] = new Branch();
			Board[14] = new Giant('G', "Giant", 14);
			Board[16] = new Rat('R', "Rat", 16);
			Board[19] = new Thorn('T',"Thorn", 19);
			Board[20] = new Prize('X', "Prize", 20);
			break;

		case 2:
			Board[0] = new Prize('X', "Prize", 0);
			Board[1] = new Thorn('T', "Thorn", 1);
			Board[2] = new Horse('H', "Horse", 2);
			Board[3] = new Giant('G', "Giant", 3);
			Board[7] = new Archer('A', "Archer", 7);
			Board[9] = new Rat('R', "Rat", 9);
			Board[11] = new Branch();
			Board[14] = new Thorn('T',"Thorn", 14);
			Board[16] = new Rat('R', "Rat", 16);
			Board[18] = new Thorn('T',"Thorn", 18);
			Board[19] = new Thorn('T',"Thorn", 19);
			Board[20] = new Prize('X', "Prize", 20);
			break;
		}
		System.out.println("Level Legend:");
		System.out.println(" P - Player (you)");
		System.out.println(" X - Prize (awards 1 point!)");
		System.out.println(" R - Rat (Bites you if it hits you.)");
		System.out.println(" H - Horse (Randomly moves and kicks you.)");
		System.out.println(" T - Thorn (Hits you if you step on it.");
		System.out.println(" A - Archer (Kills you from two spots away.)");
		System.out.println(" G - Giant (Might be a happy giant or a mad giant.)");
		System.out.println(" / - Branch (Just a branch.)");
	}

	public Drawable[] getBoard() {
		// TODO Auto-generated method stub
		return Board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		for(int i = 0; i < Board.length; i++) {

			if (Board[i] != null && (Board[i].toString().equals("H - Horse") || Board[i].toString().equals("R - Rat"))){
				Moveable Temp = (Moveable) Board[i];
				movingPieces.add(Temp);
			}
		}
		return movingPieces;
	}


	public ArrayList<GamePiece> getInteractingPieces() {
		for(int i = 0; i < Board.length; i++) {
			if(Board[i] != null && i != PLAYER_START_LOCATION && i != 11) {
				interactingPieces.add((GamePiece) Board[i]);
			}
		}
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return PLAYER_START_LOCATION;
	}
}
