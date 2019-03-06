package NQueen;

public class Nqueen {

	
	private final int n = 8;
	
	private static int board[][] = {
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}};
	

	
	public void printBoard(int board[][]) {
		System.out.print("  ");
		for(int col = 1; col <= n ; col++) {
			System.out.print(" " + col+ " " );
		}
		System.out.println();

		for(int row = 0; row < n; row++) {
			System.out.print(row + 1 + "|");
			
			for (int col = 0 ; col < n ; col++) {

				System.out.print( " "+ board[row][col] + " " );
				
			}
			
				
			System.out.println();
		}
		
	}
	
	
	// ska kolla om den kan attakera andra damer
	public boolean attack(int board[][], int row , int col) {
		return false;
	}
	
	// ska lösa problemet rekursivt/backtracking
	public boolean placeQ(int board[][], int row, int col) {
		return true;
	}
	
	
	
	
	public static void main(String args[]) {
		
		Nqueen nQueen = new Nqueen();
		nQueen.printBoard(board);
		
		
		
	}
}
