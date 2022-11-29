


public class Rook extends Piece {

	public Rook(String name, int x, int y, boolean color) {
		super(name, x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean viable(int endx, int endy, Chessboard board) {
		if (!(Math.abs(endx-x)==0||Math.abs(endy-y)==0))
		{
			System.out.println("Rook can only move in rows and columns");
			return false;
		}
		if (endx==x)
		{
			if(columnBlocked(endx, endy, board))
			{
				System.out.println("Path is obstructed");
				return false;
			}
		}
		if (endy==y)
		{
			if(rowBlocked(endx,endy,board))
			{
				System.out.println("Path is obstructed");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean viableForKing(int endx, int endy, Chessboard board) {
		if (!(Math.abs(endx-x)==0||Math.abs(endy-y)==0))
		{
			return false;
		}
		if (endx==x)
		{
			if(columnBlocked(endx, endy, board))
			{
				return false;
			}
		}
		if (endy==y)
		{
			if(rowBlocked(endx,endy,board))
			{
				return false;
			}
		}
		return true;
	}
	
}
