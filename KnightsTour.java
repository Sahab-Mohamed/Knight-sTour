package knightsTourPackage;

public class KnightsTour {


	public static void main(String[] args)
	  {
	    int[][] myGrid = new int[8][8];
//	    fillGrid(myGrid);
	    displayGrid(myGrid);
	    fillArea(myGrid,0,0,1);
	    displayGrid(myGrid);
	  }
	
	private static void displayGrid(int[][] myGrid)
	  {
	    int rowSize = myGrid.length;
	    int colSize = myGrid[0].length;
	    for(int row = 0; row < rowSize; row++)
	    {  for(int col = 0; col < colSize; col++)
	        System.out.printf(" %d ",myGrid[row][col]);//myGrid[row][col] = "";
	    System.out.println();
	    }
	    System.out.println();
	  }
	
	private static void fillGrid(String[][] myGrid)
	  {
	    int rowSize = myGrid.length;
	    int colSize = myGrid[0].length;
	    for(int row = 0; row < rowSize; row++)
	      for(int col = 0; col < colSize; col++)
	        myGrid[row][col] = "-";
	    
	  }
	static int counter = 0;
	static void fillArea( int[][] pBoardMatrix, int row, int col,int pCount)
	  {
		
	    int bottomRow = pBoardMatrix.length - 1;
	    int rightCol = pBoardMatrix[0].length - 1;
	    
	    // displayMatrix(pBoardMatrix);
	    if (row < 0 || row > bottomRow || col < 0 || col > rightCol)
	    	return;
	    if (pBoardMatrix[row][col] > 0)
	      return;

	    pBoardMatrix[row][col] = pCount;
//	    displayMatrix(pBoardMatrix);
	    if (pCount == 64) {
	    	counter ++;
	    	System.out.println("Solution " + counter +" :" );
	    displayGrid(pBoardMatrix);
	    }
	    	
	      fillArea(pBoardMatrix, row - 2, col + 1, pCount + 1); // call 5 go up-right
	      fillArea(pBoardMatrix, row - 1, col + 2, pCount + 1); // call 1 go right-up
	      fillArea(pBoardMatrix, row + 1, col + 2, pCount + 1); // call 2 go right-down
	      fillArea(pBoardMatrix, row + 2, col + 1, pCount + 1); // call 7 go down-right
	      fillArea(pBoardMatrix, row + 2, col - 1, pCount + 1); // call 8 go down-left
	      fillArea(pBoardMatrix, row + 1, col - 2, pCount + 1); // call 4 go left-down
	      fillArea(pBoardMatrix, row - 1, col - 2, pCount + 1); // call 3 go left-up
	      fillArea(pBoardMatrix, row - 2, col - 1, pCount + 1); // call 6 go up-left
	      
	      
	      
	    //backtrack and remove markers for knight's tour
	      pBoardMatrix[row][col] = 0;
	  }
}
