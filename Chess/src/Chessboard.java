
public class Chessboard 
{
	private Piece[][] board;
	
	public Chessboard()
	{
		board = new Piece[8][8];
		for (int i = 0; i < 8; i ++)
		{
			for (int j = 0; j < 8; j++)
			{
				board[i][j] = new Empty(j, i);
			}
		}
		for (int x = 0; x < 8; x++)
		{
			board[1][x] = new Pawn("B Pawn\t\t", x, 1, false);
			board[6][x] = new Pawn("W Pawn\t\t", x, 6, true);
			if (x==0||x==7)
			{
				board[0][x]= new Rook("B Rook\t\t", x, 0, false);
				board[7][x]= new Rook("W Rook\t\t", x, 7, true);
				
			}
			if (x==1||x==6)
			{
				board[0][x]= new Knight("B Knight\t", x, 0, false);
				board[7][x]= new Knight("W Knight\t", x, 7, true);
				
			}
			if (x==2||x==5)
			{
				board[0][x]= new Bishop("B Bishop\t", x, 0, false);
				board[7][x]= new Bishop("W Bishop\t", x, 7, true);
			}
			if (x==3)
			{
				board[0][3] = new Queen("B Queen\t\t", 3, 0, false);
				board[0][4] = new King("B King\t\t", 4, 0, false);
				board[7][3] = new Queen("W Queen\t\t", 3, 7, true);
				board[7][4] = new King("W King\t\t", 4, 7, true);
			}
			
		}
		
	}
	public Piece[][] getBoard()
	{
		return board;
	}
	/*@param: void
	 *@return: void
	 *purpose: prints out board
	 */
	public void bMove()
	{
		for (int y = 0; y < 8; y++)
		{
			System.out.print(y+1+"\t");
			for (int x = 0; x < 8; x++)
			{
				System.out.print(board[y][x].getName());
			}
			System.out.println("\n\n\n\n\n");
		}
		System.out.println("\tA\t\tB\t\tC\t\tD\t\tE\t\tF\t\tG\t\tH");
	}
	/*@param: coorindates of piece
	 *@return: piece at location
	 *purpose: to get piece at certain location of board
	 */
	public Piece getPiece(int x, int y)
	{
		return board[y][x];
	}
	/*@param: void
	 *@return: void
	 *purpose: part of my plan to flip the board that was ultimately stupid
	 */
//	public void flip()
//	{
//		Piece[][] temp = new Piece[8][8];
//		for (int k = 0; k<8; k++)
//		{
//			for (int l = 0; l<8; l++)
//			{
//				temp[7-k][7-l]= board[k][l];
//				temp[7-k][7-l].switcheroo();
//			}
//		}
//		board = temp;
//		
//	}
}
