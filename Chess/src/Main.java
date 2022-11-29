import java.util.ArrayList;
import java.util.Scanner;
public class Main 
{
	/*@param: String input form player 
	 *@return: coordinate corresponding to letter or number
	 *purpose: converting string to integer coordinates
	 */
	public static int conversion(String i)
	{
		if (i.equals("1")||i.contentEquals("A"))
		{
			return 0;
		}
		else if(i.equals("2")||i.contentEquals("B"))
		{
			return 1;
		}
		else if(i.equals("3")||i.contentEquals("C"))
		{
			return 2;
		}
		else if(i.equals("4")||i.contentEquals("D"))
		{
			return 3;
		}
		else if(i.equals("5")||i.contentEquals("E"))
		{
			return 4;
		}
		else if(i.equals("6")||i.contentEquals("F"))
		{
			return 5;
		}
		else if(i.equals("7")||i.contentEquals("G"))
		{
			return 6;
		}
		else if(i.equals("8")||i.contentEquals("H"))
		{
			return 7;
		}
		else 
		{
			return 8;
		}
	}
	public static void main(String[] args) 
	{		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Chessboard board = new Chessboard(); // this is the chessboard
		int round = 0; // counter to determine round number
		boolean playing = true; //keeps rounds going
		ArrayList<Piece> blackHasCaptured = new ArrayList<Piece>(); // self explanatory
		ArrayList<Piece> whiteHasCaptured = new ArrayList<Piece>(); //^^
		boolean whiteRound = true;// variable to see whose round it is
		while (playing) // this is where the diagnostic loop that dictates each round starts
		{
			board.bMove();//determines which round it is
			if (round % 2 == 0) {
				whiteRound = true;System.out.println("White Moves");}
			else {
				whiteRound = false;System.out.println("Black Moves");}
			Piece selected = null; // this is the piece that is going to move
			//prints whose round for reference
			int newx = 0,newy = 0; //this is for the destination
			boolean input = true; // this is a boolean to dictate a diagnostic loop that checks move viability
			while (input)
			{
				System.out.println("Select your piece (letter/number, eg A1)");
				String startPlace = scan.nextLine() + "  ";		
				//conversion of input into coordinates
				int startx = conversion(startPlace.substring(0,1));
				int starty = conversion(startPlace.substring(1,2));
				if (startx == 8 || starty == 8) // checks if selected piece is out of bounds
				{
					System.out.println("Invalid Input, use capital letters and number such as A1");
				}
				else if (board.getPiece(startx, starty) instanceof Empty) // checks that u r actually selecting a piece
				{
					System.out.println("Select a piece please");
				}
				else
				{
					selected = board.getPiece(startx, starty);
					System.out.println("Select move location");
					String location = scan.nextLine() + "  ";
					//conversion of input into coordinates
					newx = conversion(location.substring(0,1));
					newy = conversion(location.substring(1,2));
					if (newx == 8 || newy == 8) // checks if selected piece is out of bounds
					{
						System.out.println("Invalid destination, use capital letters and number such as A1");
					}
					else
					{
						input = !selected.ableToMove(newx, newy, board, whiteRound);
					}
				}
				
			}
			//adds to captured piles, but i didnt get to dp anything with them because i dont have a gui, didnt want to print them out every round
			if (!board.getPiece(newx,newy).isEmpty())
			{
				if (whiteRound)
					whiteHasCaptured.add(board.getPiece(newx, newy));
				else
					blackHasCaptured.add(board.getPiece(newx, newy));
			}
					
			selected.move(newx, newy, board);
//			System.out.println("moved");
			
			System.out.println("Next Turn");
//			board.flip(); This was an attempt to flip the board every time a turn happened
//			but i realized it was useless 
			round ++;
		}
	}

}
