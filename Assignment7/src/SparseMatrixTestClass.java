/*
 * Test class for negative test cases of methods of SparseMatrix class
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SparseMatrixTestClass {

	SparseMatrix sparseMatrixTranspose;
	SparseMatrix sparseMatrix1;
	SparseMatrix sparseMatrix2;
	private int[][] array1 = {{0, 1, 1},
			                 {1, 0, 2}};
	private int[][] array2 = {{1, 0, 6},
			                 {1, 1, 3}};
	private int[][] arrayAdd ={{0, 1, 1},
			{1, 0, 8},
			{1, 1, 3}};
	private int[][] arrayTranspose = {{1, 0, 1},
                                      {0, 1, 2}};
	
	@Before
	public void initialize() {
		sparseMatrix1 = new SparseMatrix(array1);
		sparseMatrix2 = new SparseMatrix(array2);
		sparseMatrixTranspose = new SparseMatrix(arrayTranspose);
	}

	@Test
	public void transposeTest() {
		int[][] array =  sparseMatrix1.transpose(sparseMatrix1).getMatrix();
		assertArrayEquals(arrayTranspose,array);
	}
	
	@Test
	public void isSymmetricTest(){
		assertEquals(false, sparseMatrix1.isSymmetric(sparseMatrix1));
			}
	
	@Test
	public void addTest(){
		int[][] array =  sparseMatrix1.add(sparseMatrix1, sparseMatrix2).getMatrix();
		assertArrayEquals(arrayAdd, array);
	}
	/*
	@Test
	public void multiplyTest(){
		assertEquals(polyMul, poly.multiply(poly, poly1));
	}*/
}
