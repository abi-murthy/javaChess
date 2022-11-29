import java.util.Scanner;

public class Pawn extends Piece 
{
    public boolean firstMove;
    public Pawn(String name, int x, int y, boolean color) 
    {
        super(name, x, y, color);
        firstMove = false;
    }
    @Override
    public boolean viable(int endx, int endy, Chessboard board) {
        // TODO Auto-generated method stub
        if (x!= endx)
        {
            System.out.println("x diff");
            return false;
        }
        if (firstMove && Math.abs(endy-y)>1)
        {
            System.out.println("more tha 1");
            return false;
        }
        if (!firstMove && Math.abs(endy-y)>2)
        {
            System.out.println("More than 2");
            return false;
        }
        if (isWhite()&& endy>y)
        {
            System.out.println("backwards");
            return false;
        }
        if (!isWhite() && endy<y)
        {
            System.out.println("backwards");
            return false;
        }
        if (Math.abs(endy-y)==2 && !board.getPiece(x, (endy+y)/2).isEmpty())
        {
            System.out.println("blocked");
            return false;
        }
        else
        {
            firstMove=true;
            
            return true;
        }
    }
    @Override
    public boolean viableForKing(int endx, int endy, Chessboard board) {
        if (x!= endx)
        {
            return false;
        }
        if (firstMove && Math.abs(endy-y)>1)
        {
            return false;
        }
        if (!firstMove && Math.abs(endy-y)>2)
        {
            return false;
        }
        if (isWhite()&& endy>y)
        {
            return false;
        }
        if (!isWhite() && endy<y)
        {
            return false;
        }
        if (Math.abs(endy-y)==2 && !board.getPiece(x, (endy+y)/2).isEmpty())
        {
            return false;
        }
        else
        {       
            return true;
        }
    }
    
    @SuppressWarnings("resource")
    /*@param: coordiantes of destination and chessboard board
     *@return:void
     *purpose: special implementation of move specific to Paawn to account for transformation
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
        Scanner scan = new Scanner(System.in);
        if ((isWhite() && y == 0)||(!isWhite() && y==7))
        {
            String colorString;
            System.out.println("Select a piece: Queen(1) Rook(2) Bishop (3) Knight(4)");
            int option = scan.nextInt();
            boolean notRight = true;
            if (isWhite())
                colorString ="W ";
            else 
                colorString = "B ";
            while(notRight)
            {
		if (option == 1)
		{
			board.getBoard()[newy][newx] = new Queen(colorString+"Queen\t\t", newx, newy,color);
			notRight = false;
		}
		else if (option == 2)
		{
			board.getBoard()[newy][newx] = new Rook(colorString+"Rook\t\t", newx, newy,color);
			notRight = false;
		}
		else if (option == 3)
		{
			board.getBoard()[newy][newx] = new Bishop(colorString+"Bishop\t", newx, newy,color);
			notRight = false;
		}
		else if (option == 4)
		{
			board.getBoard()[newy][newx] = new Knight(colorString+"Knight\t", newx, newy,color);
			notRight = false;
		}
		else 
		{
		    System.out.println("Enter a number 1-4");
		    System.out.println("Select a piece: Queen(1) Rook(2) Bishop (3) Knight(4)");
		    option = scan.nextInt();
		}
            }
        }           
    }
}


