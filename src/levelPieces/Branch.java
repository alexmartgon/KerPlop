package levelPieces;

import gameEngine.Drawable;

public class Branch implements Drawable{
	
	private final char SYMBOL = '/';
	public Branch() {
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print('/');
	}

}
