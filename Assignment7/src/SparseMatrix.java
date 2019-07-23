/*
 * Performs various operations on 2D Sparse Matrix.
 * For Space efficiency only non-zero elements of Sparse Matrix are stored.
 * @since 22-July-2019
 */
public final class SparseMatrix {
	final int[][] resMatrix;

	SparseMatrix(int[][] resMatrix){
		this.resMatrix = resMatrix;
	}

	public int[][] getMatrix(){
		return resMatrix;
	}
    
	/**
	 * Computes Transpose of the Sparse Matrix
	 * @param sparseMatrix is the input object of this class
	 * @return Transpose of the input matrix
	 */
	public SparseMatrix transpose(SparseMatrix sparseMatrix) {
		int k = 0;
		int swap;
		for(k = 0 ; k < resMatrix.length ; k++) {
			swap = sparseMatrix.resMatrix[k][0];
			sparseMatrix.resMatrix[k][0] = sparseMatrix.resMatrix[k][1];
			sparseMatrix.resMatrix[k][1] = swap;
		}
		
		return sparseMatrix;
	}
    
	/**
	 * Checks if the input matrix is Symmetric
	 * @param sparseMatrix is the input object of this class
	 * @return true or false accordingly
	 */
	public Boolean isSymmetric(SparseMatrix sparseMatrix) {
		for(int i = 0;i < resMatrix.length ; i++){
			for(int j = 0 ; j < resMatrix[0].length ; j++){
				if(sparseMatrix.resMatrix[i][j] != transpose(sparseMatrix).resMatrix[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
    
	/**
	 * Performs addition of two Sparse Matrices
	 * @param sparseMatrix1 is the first input object of this class
	 * @param sparseMatrix2 is the second input object of this class
	 * @return resultant object
	 */
	public SparseMatrix add(SparseMatrix sparseMatrix1, SparseMatrix sparseMatrix2) {
		int[][] matrix = new int[resMatrix.length][3];
		matrix = sparseMatrix2.resMatrix;
		int j = 0;
		int k= 0;
		boolean flag = false;
        
		for(k = 0 ; k < sparseMatrix1.resMatrix.length ; k++) {
			for(j = 0 ; j < sparseMatrix2.resMatrix.length ; j++) {
				if(sparseMatrix1.resMatrix[k][0] == sparseMatrix2.resMatrix[j][0]
						&& sparseMatrix1.resMatrix[k][1]==sparseMatrix2.resMatrix[j][1]) {
					flag = true;
					matrix[j][2] += sparseMatrix1.resMatrix[k][2];
					System.out.println(matrix[j][2]);
				}
			}
			
			if(!flag) {
				matrix[j][0] = sparseMatrix1.resMatrix[k][0];
				matrix[j][1] = sparseMatrix1.resMatrix[k][1];
				matrix[j][2] = sparseMatrix1.resMatrix[k][2];
				j++;
			}
		}
		
		SparseMatrix sparse = new SparseMatrix(matrix);
		return sparse;
	}
   
	/**
	 * Performs Multiplication of two Sparse Matrices
	 * @param sparseMatrix1 is the first input object of this class
	 * @param sparseMatrix2 is the second input object of this class
	 * @return resultant object
	 */
	/*public SparseMatrix multiply(SparseMatrix sparseMatrix1, SparseMatrix sparseMatrix2) {
		for(int i=0;i<sparseMatrix1.resMatrix.length;i++) {
			for(int j=0;j<sparseMatrix1.resMatrix[0].length;j++) {

			}
		}
	}*/
}