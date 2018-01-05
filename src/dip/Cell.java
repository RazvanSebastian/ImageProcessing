package dip;

/**
 * 
 * @author Razvan
 *
 *         In a cell object is stored a matrix representing a block(cell) of n x
 *         n pixels
 */

public class Cell {

	private int[][] matrix;

	/**
	 * Store a matrix representing a block of pixels
	 * @param matrix
	 */
	public Cell(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void display() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
