
public class Knight extends Piece {

	public Knight(String name, int x, int y, boolean color) {
		super(name, x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean viable(int endx, int endy, Chessboard board) {
		// TODO Auto-generated method stub
		if (Math.abs(endx-x)==2 && Math.abs(endy-y)==1)
		{
			return true;
		}
		if (Math.abs(endy-y)==2 && Math.abs(endx-x)==1)
		{
			return true;
		}
		System.out.println("Invalid move");
		return false;
	}

	@Override
	public boolean viableForKing(int endx, int endy, Chessboard board) {
		// TODO Auto-generated method stub
		if (Math.abs(endx-x)==2 && Math.abs(endy-y)==1)
		{
			return true;
		}
		if (Math.abs(endy-y)==2 && Math.abs(endx-x)==1)
		{
			return true;
		}
		return false;
	}

}
