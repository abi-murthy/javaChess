import java.util.ArrayList;
public abstract class Piece 
{
	protected String name;
	protected int y;
	protected int x;
	protected boolean color;
	public Piece (String name, int x, int y, boolean color) 
	{
		this.name = name;
		this.x = x;
		this.y = y;
		this.color = color;
		
	}
	
	/*@param: int x and y coordinates of destination, and Chessboard board
	 *@return: void
	 *purpose: move piece to a different spot
	 */
	public void move(int newx, int newy, Chessboard board)
	{
		int oldx = x;
		int oldy = y;
		x = newx;
		y = newy;
		Piece moved = board.getPiece(oldx, oldy);
		board.getBoard()[newy][newx] = moved;
		board.getBoard()[oldy][oldx] = new Empty(oldx, oldy);
	}
	public String getName()
	{
		return name;
	}
	/*@param: nothing
	 *@return: boolean that indicates color of piece
	 *purpose: white or black piece
	 */
	public boolean isWhite()
	{
		if (color)
			return true;
		else 
			return false;
	}
	/*@param: destinations int x and y coordinates, Chessboard board, and whether it is white or black move
	 *@return: true or false whether piece can move to specified destination
	 *purpose: to see if selected location has a piece that is correct color and can be moved to selected destination
	 */
	public boolean ableToMove(int endx, int endy, Chessboard board, boolean whiteRound)
	{
		Piece destination = board.getPiece(endx, endy);
		System.out.println(this.getName());
		System.out.println(destination.name);
		if ((whiteRound && !isWhite()) || (!whiteRound && isWhite()))
		{
			System.out.println("Invalid Piece, pick a piece that is your color");
			return false;
		}
		if((this.color == destination.color) && !destination.isEmpty())
		{
			System.out.println("Invalid move, cannot capture own piece");
			return false;
		}
		if(x == endx && y == endy)
		{
			System.out.println("Cannot stay in same place");
			return false;
		}
		if (destination instanceof King)
		{
			System.out.println("Cannot capture a king");
			return false;
		}
		if (viable(endx, endy, board))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	/*@param: nothing
	 *@return: boolean that indicates color ( true is white false is black)
	 *purpose: to indicate empty space
	 */
	public boolean isEmpty()
	{
		return false;
	}
//	public void switcheroo()
//	{
//		x = 7-x;
//		y= 7-y;
//	}
	/*@param: destination's cooordinates, chessboard board
	 *@return: boolean true or false indicating whether diagonal path is blocked
	 *purpose: if there are pieces between piece and destination in a diagonal
	 */
	public boolean diagonalBlocked(int endx,int endy,Chessboard board)
	{
		ArrayList<Integer> xvalues =new ArrayList<>();
		ArrayList<Integer> yvalues =new ArrayList<>();
		if (endx>x)
		{
			for (int j = x+1; j<endx;j++)
			{
				xvalues.add(j);
			}
		}
		else 
		{
			for (int k = x-1; k>endx;k--)
			{
				xvalues.add(k);
			}
		}
		if (endy>y)
		{
			for (int l = y+1; l<endy;l++)
			{
				yvalues.add(l);
			}
		}
		else 
		{
			for (int m = y-1; m>endy;m--)
			{
				yvalues.add(m);
			}
		}
		for (int o = 0; o < xvalues.size(); o++)
		{
			Piece between = board.getPiece(xvalues.get(o), yvalues.get(o));
//			System.out.println(between.name);
			if (!between.isEmpty())
				return true;
		}
		return false;
		
	}
	/*@param: destination's cooordinates, chessboard board
	 *@return: boolean true or false indicatig whether horizontal path is blocked
	 *purpose: if there are pieces between piece and destination in a horizontal path
	 */
	public boolean rowBlocked(int endx, int endy, Chessboard board)
	{
		ArrayList<Integer> xvalues =new ArrayList<>();
		if (endx>x)
		{
			for (int j = x+1; j<endx;j++)
			{
				xvalues.add(j);
			}
		}
		else 
		{
			for (int k = x-1; k>endx;k--)
			{
				xvalues.add(k);
			}
		}
		for (int o = 0; o < xvalues.size(); o++)
		{
			Piece between = board.getPiece(xvalues.get(o),endy);
//			System.out.println(between.name);
			if (!between.isEmpty())
				return true;
		}
		return false;
	}
	/*@param: destination's cooordinates, chessboard board
	 *@return: boolean true or false indicatig whether vertical path is blocked
	 *purpose: if there are pieces between piece and destination in a vertical path
	 */
	public boolean columnBlocked(int endx, int endy, Chessboard board)
	{
		ArrayList<Integer> yvalues =new ArrayList<>();
		if (endy>y)
		{
			for (int l = y+1; l<endy;l++)
			{
				yvalues.add(l);
			}
		}
		else 
		{
			for (int m = y-1; m>endy;m--)
			{
				yvalues.add(m);
			}
		}
		for (int o = 0; o < yvalues.size(); o++)
		{
			Piece between = board.getPiece(endx, yvalues.get(o));
//			System.out.println(between.name);
			if (!between.isEmpty())
				return true;
		}
		return false;
	}
	/*@param: chessboard and boolean enemy color
	 *@return: boolean that indicates whether or not certain position is under attack by enemy piece
	 *purpose: to see if certain position on board is under enemy line of fire to see if king can move there
	 */
	public boolean underAttack(Chessboard board, boolean enemy)
	{
		for (Piece[] rows: board.getBoard())
		{
			for (Piece piece: rows)
			{
				if (!piece.isEmpty() && !piece.equals(board.getPiece(x,y)) && piece.color==enemy && piece.viableForKing(x, y, board))
				{
					return true;
				}
			}
		}
		return false;
	}
	
		
	
	/*@param: destination coordinates, chessboard board
	 *@return: boolean indicating whether or not piece is able to move to specified location based on rules specific to piece
	 *purpose: to see if specfic piece can move to specified location based on rules specific to piece
	 */
	public abstract boolean viable(int endx, int endy, Chessboard board);
	/*@param: destination coordinates, chessboard boardd
	 *@return: boolean true or false
	 *purpose: to seee whther specififc piece can move to specified location based on rules specific to piece but this one is used for determinign whether a positionis underattack and has no prinat statmeents
	 */
	public abstract boolean viableForKing(int endx, int endy, Chessboard board);
}
	


