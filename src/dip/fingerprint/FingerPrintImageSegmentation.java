package dip.fingerprint;

import dip.Cell;

public class FingerPrintImageSegmentation {

	/**
	 * For every block the variance is compute and if the result is less than 200,
	 * means that the square is a background. and every value will be set to 0(black
	 * pixel)
	 * 
	 * @param cells
	 * @return
	 */
	public static Cell[][] imageSegmentation(Cell[][] cells) {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				// compute the variance of matrix at cell (i,j)
				double mean = Mean.getMatrixMean(cells[i][j].getMatrix());
				double variance = Variance.getMatrixVariance(cells[i][j].getMatrix(), mean);
				// if the variance of the block is less then 10 then the block is a background part
				if (variance <= 200)
					cells[i][j] = getBlackCell(cells[i][j]);
			}
		}
		return cells;
	}

	private static Cell getBlackCell(Cell cell) {
		for (int i = 0; i < cell.getMatrix().length; i++)
			for (int j = 0; j < cell.getMatrix().length; j++)
				cell.getMatrix()[i][j] = 0;
		return cell;
	}

}
