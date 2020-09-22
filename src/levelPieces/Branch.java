package levelPieces;

import gameEngine.Drawable;

public class Branch implements Drawable{
	/*
	 * The goal of the Branch is to exist or something
	 */
	private final char SYMBOL = '/'; //since this does not extend GamePiece, it needed a symbol not assigned traditionally
	
	public Branch() { // constructor
	}
	
	@Override
	public void draw() { // basically a ToString method
		System.out.print(SYMBOL);
	}
}
