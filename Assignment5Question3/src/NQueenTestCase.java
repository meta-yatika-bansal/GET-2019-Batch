/*
 * Test Class for NQueen's Problem 
 */
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class NQueenTestCase {

	private int startRow;
	private int dimensionOfMatrix;
	private NQueenProblem nQueen;

	@Before
	public void initialize() {
		nQueen = new NQueenProblem();
	}
    
	int[][]expectedResult = {{ 0 , 0 , 0},
			                 { 0 , 0 , 0},
			                 { 0 , 0 , 0}};
	
	@Test
	public void NQueenTestCase() {
		startRow = 0;
		dimensionOfMatrix = 3;
		assertArrayEquals(expectedResult, nQueen.showBoard(startRow, dimensionOfMatrix));
	}
	int[][]expectedResult1 = {{ 0 , 1 , 0 , 0}, 
			                 { 0 , 0 , 0 , 1}, 
			                 { 1 , 0 , 0 , 0},
			                 { 0 , 0 , 1 , 0}}; 

	@Test
	public void NQueenTestCase1() {
		startRow = 0;
		dimensionOfMatrix = 4;
		assertArrayEquals(expectedResult1, nQueen.showBoard(startRow, dimensionOfMatrix));
	}
	int[][]expectedResult2 = {{ 1 , 0 , 0 , 0 , 0 , 0 , 0,  0 },
	                        {0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 },
	                        {0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 },
	                        {0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 },
	                        {0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 },
	                        {0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 },
	                        {0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 },
	                        {0 , 0 , 0 , 1 , 0 , 0 , 0 , 0}}; 

	@Test
	public void NQueenTestCase2() {
		startRow = 0;
		dimensionOfMatrix = 8;
		assertArrayEquals(expectedResult2, nQueen.showBoard(startRow, dimensionOfMatrix));
	
	}
	int[][]expectedResult3 = {{1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
			                 {0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
			                 {0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
			                 {0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 },
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 },
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 },
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 },
			                 {0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1},
			                 {0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			                 {0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0},
			                 {0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
                             {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0}}; 
	
	@Test
	public void NQueenTestCase3() {
		startRow = 0;
		dimensionOfMatrix = 16;
		assertArrayEquals(expectedResult3, nQueen.showBoard(startRow, dimensionOfMatrix));
	}
}