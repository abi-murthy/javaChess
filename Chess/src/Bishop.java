
public class Bishop extends Piece {

	public Bishop(String name, int x, int y, boolean color) {
		super(name, x, y, color);
	}

	@Override
	public boolean viable(int endx, int endy, Chessboard board) {
		if (Math.abs(endx-x)!=Math.abs(endy-y))
		{
			System.out.println("Bishops can only move in diagonals");
			return false;
		}
		if (diagonalBlocked(endx, endy, board))
		{
			System.out.println("Path is obstructed");
			return false;
		}		
		return true;
	}

	@Override
	public boolean viableForKing(int endx, int endy, Chessboard board) {
		if (Math.abs(endx-x)!=Math.abs(endy-y))
		{
			return false;
		}
		if (diagonalBlocked(endx, endy, board))
		{
			return false;
		}		
		return true;
	}
}
