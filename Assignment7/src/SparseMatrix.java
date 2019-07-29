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
		int size = sparseMatrix1.resMatrix.length + sparseMatrix2.resMatrix.length;
		int[][] matrix = new int[size][3];

		for(int i = 0 ; i < sparseMatrix2.resMatrix.length ; i++){
			for(int a = 0 ; a< sparseMatrix2.resMatrix[0].length ; a++){
				matrix[i][a] = sparseMatrix2.resMatrix[i][a];
			}
		}

		int j = 0;
		int k = 0;
		boolean flag = false;

		for(k = 0 ; k < sparseMatrix1.resMatrix.length ; k++) {
			for(j = 0 ; j < sparseMatrix2.resMatrix.length ; j++) {
				if(sparseMatrix1.resMatrix[k][0] == sparseMatrix2.resMatrix[j][0]
						&& sparseMatrix1.resMatrix[k][1]==sparseMatrix2.resMatrix[j][1]) {
					flag = true;
					matrix[j][2] += sparseMatrix1.resMatrix[k][2];
				}
			}

			if(!flag) {
				matrix[j][0] = sparseMatrix1.resMatrix[k][0];
				matrix[j][1] = sparseMatrix1.resMatrix[k][1];
				matrix[j][2] = sparseMatrix1.resMatrix[k][2];
			}
		}

		int[][] matrix1 = new int[j+1][3];
		for(int i = 0 ; i < j+1 ; i++){
			for(int a = 0 ; a < 3 ; a++){
				matrix1[i][a] = matrix[i][a];
			}
		}

		SparseMatrix sparse = new SparseMatrix(matrix1);
		return sparse;
	}

	/**
	 * Performs Multiplication of two Sparse Matrices
	 * @param sparseMatrix1 is the first input object of this class
	 * @param sparseMatrix2 is the second input object of this class
	 * @return resultant object
	 */
	public SparseMatrix multiply(SparseMatrix sparseMatrix1, SparseMatrix sparseMatrix2) {
		sparseMatrix2 = sparseMatrix2.transpose(sparseMatrix2);
		int i, j;
		int k = 0;

		int[][] resMatrix1 = new int[sparseMatrix1.resMatrix.length][sparseMatrix2.resMatrix.length];
		SparseMatrix multiply = new SparseMatrix(resMatrix1);
		for (i = 0; i < sparseMatrix1.resMatrix.length;) {
			int row = sparseMatrix1.resMatrix[i][0];
			for (j = 0; j < sparseMatrix2.resMatrix.length;) {
				int col = sparseMatrix2.resMatrix[j][0];
				int sum = 0;
				while (i < sparseMatrix1.resMatrix.length && resMatrix[i][0] == row
						&& j < sparseMatrix2.resMatrix.length && sparseMatrix2.resMatrix[j][0] == col) {

					if (sparseMatrix1.resMatrix[i][1] < sparseMatrix2.resMatrix[j][1]) {
						i++;
					} else if (sparseMatrix1.resMatrix[i][1] > sparseMatrix2.resMatrix[j][1]) {
						j++;
					} else {
						sum += sparseMatrix1.resMatrix[i++][2] * sparseMatrix2.resMatrix[j++][2];
					}
				}

				if (sum != 0) {
					multiply.resMatrix[k][0] = row;
					multiply.resMatrix[k][1] = col;
					multiply.resMatrix[k][2] = sum;
					k++;
				}
			}			
		}

		return multiply;
	}
}