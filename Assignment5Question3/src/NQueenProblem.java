
/*
 * Computes Solution of N Queen's Problem for a given NxN chess board.
 * Input is the start row and dimension of chess board.
 * Output is a binary matrix with 1 as Queen and everything else as 0.
 * @since 18-July-2019.
 */
public class NQueenProblem {

	int [][] board;
    
	/**
	 * Initializes the board with value 0
	 * @param dimensionOfMatrix is the dimension of the board
	 */
    void initializeBoard(int dimensionOfMatrix) {
    	board = new int[dimensionOfMatrix][dimensionOfMatrix];
    	for(int i = 0 ; i < dimensionOfMatrix ; i++) {
			for(int j = 0 ; j < dimensionOfMatrix ; j++) {
				board[i][j] = 0;
			}
		}
	}
    
    /**
     * Computes the Solution for N Queen's Problem
     * @param startRow is the starting row of board
     * @param dimensionOfMatrix is the dimension of the board
     * @return true or false indicating whether a solution exists
     */
	Boolean nQueen(int startRow, int dimensionOfMatrix){ 
		if(startRow == dimensionOfMatrix){
			return true;  
		}
		for(int j = 0 ; j < dimensionOfMatrix ; j++){
			if(board[startRow][j] == 0){
				board[startRow][j] = 1; 
				blockBoxes(startRow, j, dimensionOfMatrix);
				startRow++;
				if(!nQueen(startRow, dimensionOfMatrix)){
					startRow--;
					board[startRow][j] = 0;
					unblockBoxes(startRow , j, dimensionOfMatrix); 
					continue;
				}else{
					return true;
				}
			}
		}
		
		return false;
	}
    
	/**
	 * Blocks the boxes where a placed queen can attack
	 * @param a is the row coordinate of board
	 * @param b is the column coordinate of board
	 * @param dimensionOfMatrix is the dimension of board
	 */
	void blockBoxes(int a, int b , int dimensionOfMatrix){
		for(int i = 1 ; i < dimensionOfMatrix ; i++) {
			if((a+i) < dimensionOfMatrix) {
				board[a+i][b] += -1;
				if((b+i) < dimensionOfMatrix) {
					board[a+i][b+i] += -1;
				}
				if((b-i) >= 0) {
					board[a+i][b-i] += -1;
				}
			}
		}
	}
    
	/**
	 * Unblocks the boxes blocked by placed queen if that place doesn't lead to solution
	 * @param a is the row coordinate of board
	 * @param b is the column coordinate of board
	 * @param dimensionOfMatrix is the dimension of board
	 */
	void unblockBoxes(int a, int b, int dimensionOfMatrix){
		for(int i = 1 ; i < dimensionOfMatrix ; i++) {
			if((a+i) < dimensionOfMatrix) {
				board[a+i][b] += 1;
				if((b+i) < dimensionOfMatrix) {
					board[a+i][b+i] += 1;
				}
				if((b-i) >= 0) {
					board[a+i][b-i] += 1;
				}
			}
		}
	}
	
	/**
	 * When all the Queens are placed it assigns every other box to 0
	 * @param dimensionOfMatrix is the dimension of board
	 */
	void makeNegValuesZero(int dimensionOfMatrix) {
		for(int i = 0 ; i < dimensionOfMatrix ; i++) {
			for(int j = 0; j< dimensionOfMatrix ; j++) {
				if(board[i][j] < 0) {
					board[i][j] = 0;
				}
			}
		}
	}
    
	/**
	 * Prints the binary matrix i.e board 
	 * @param startRow is the starting row of board
	 * @param dimensionOfMatrix i the dimension of board
	 */
	int[][] showBoard(int startRow, int dimensionOfMatrix) {
		initializeBoard(dimensionOfMatrix);
		boolean result =nQueen(startRow, dimensionOfMatrix);
		if (!result) {
			initializeBoard(dimensionOfMatrix);
			return board;
		}else {
			makeNegValuesZero(dimensionOfMatrix);
			return board;
		}
	}
}
