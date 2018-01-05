package dip.fingerprint;

public class Mean {

	public static final int MEAN0 = 100;

	/**
	 * Compute the matrix mean
	 * 
	 * @param matrix
	 * @return
	 */
	public static double getMatrixMean(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];
			}
		return (sum / matrix.length) / matrix.length;
	}

}
