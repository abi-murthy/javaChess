
public class Empty extends Piece {

	public Empty(int x, int y) {
		super("_____\t\t", x, y, false);
	}
	
	public boolean isEmpty()
	{
		return true;
	}
	public boolean viable(int endx, int endy, Chessboard board) {
		return false;
	}
	public boolean viableForKing(int endx, int endy, Chessboard board) {
		return false;
	}
}
