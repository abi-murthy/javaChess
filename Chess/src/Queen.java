
public class Queen extends Piece {

	public Queen(String name, int x, int y, boolean color) {
		super(name, x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean viable(int endx, int endy, Chessboard board) {
		if ((Math.abs(endy-y)!= Math.abs(endx-x)) && !(endy-y==0 ||endx-x==0))
		{
			System.out.println("Queen cannot move like this");
			return false;
		}
		if (Math.abs(endx-x)==Math.abs(endy-y))
		{
			if (diagonalBlocked(endx, endy, board))
			{
				System.out.println("Path is obstructed");
				return false;
			}
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
		if ((Math.abs(endy-y)!= Math.abs(endx-x)) && !(endy-y==0 ||endx-x==0))
		{
			return false;
		}
		if (Math.abs(endx-x)==Math.abs(endy-y))
		{
			if (diagonalBlocked(endx, endy, board))
			{
				return false;
			}
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
