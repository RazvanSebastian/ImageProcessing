package dip.fingerprint;

public class Variance {

	public static final int VAR0 = 100;

	/**
	 * Compute the matrix variance
	 * 
	 * @param matrix
	 * @param mean
	 * @return
	 */
	public static double getMatrixVariance(int[][] matrix, double mean) {
		double sum = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				sum += (matrix[i][j] - mean) * (matrix[i][j] - mean);
		return (sum / matrix.length) / matrix.length;
	}

}
