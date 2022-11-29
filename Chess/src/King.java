
public class King extends Piece {
	@SuppressWarnings("unused")
	private boolean underAttack;
	public King(String name, int x, int y, boolean color) 
	{
		super(name, x, y, color);
		@SuppressWarnings("unused")
		boolean underAttack = false;
	}
	@Override
	public boolean viable(int endx, int endy, Chessboard board) {
		// TODO Auto-generated method stub
		if (Math.abs(endx-x)>1 || Math.abs(endy-y)>1)
		{
			System.out.println("King cannot move that far");
			return false;
		}
		if (board.getPiece(endx,endy).underAttack(board, !color))
		{
			System.out.println("Destination is underattack");
			return false;
		}
		return true;
	}
	@Override
	public boolean viableForKing(int endx, int endy, Chessboard board) {
		if (Math.abs(endx-x)>1 || Math.abs(endy-y)>1)
		{
			return false;
		}
		if (board.getPiece(endx,endy).underAttack(board, !color))
		{
			return false;
		}
		return true;
	}
}
