package dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Import image and convert every pixel into gray-scale (values : 0-255)
 * 
 * @author Razvan
 *
 */

public class ImageHandler {

	/**
	 * Check if the image from buffer has a square format. If the clause is passed
	 * every pixel is converted from RGB to Gray-Scale using the formula :
	 * read*0.299 + green*0.587 + blue*0.114. The matrix values are in interval
	 * [0,255] where 0 = black, 255 = white and 128 = gray
	 * 
	 * @param bufferedImage
	 * @return an image as matrix in gray scale
	 * @throws Exception
	 */
	public static int[][] grayScaleConversion(BufferedImage bufferedImage) throws Exception {
		int n = bufferedImage.getWidth();
		if (bufferedImage.getHeight() != n)
			throw new Exception("The image is not a square!");

		int[][] image = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Color c = new Color(bufferedImage.getRGB(i, j));

				// to convert the pixel to gray-scale
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				int sum = red + green + blue;
				
				// save in matrix
				image[i][j] = sum;
			}
		}
		return image;
	}

	/**
	 * Split the image stored as matrix in blocks of dimensions of 10 x 10
	 * 
	 * @return get a matrix of cells divided on block of 10 x 10 pixels
	 */
	public static Cell[][] convertMatrixToBlocks(int[][] image) {
		Cell[][] blocks = new Cell[image.length / 10][image.length / 10];
		for (int i = 0; i < image.length; i += 10) {
			for (int j = 0; j < image[0].length; j += 10) {
				blocks[i / 10][j / 10] = generateCell(image, i, j);
			}
		}
		return blocks;
	}

	/**
	 * Generate a matrix representing the image sticking the matrix of blocks
	 * 
	 * @param cells
	 * @return
	 */
	public static int[][] convertBlocksToMatrix(Cell[][] cells) {
		int n = cells.length * cells[0][0].getMatrix().length;
		int[][] matrix = new int[n][n];

		for (int i = 0; i < cells.length; i++)
			for (int j = 0; j < cells.length; j++)
				matrix = generateMatrix(i, j, cells[i][j].getMatrix(), matrix);
		return matrix;
	}

	/**
	 * 
	 * @param cellRow
	 * @param cellCol
	 * @param cellMatrix
	 * @param matrix
	 * @return
	 */
	private static int[][] generateMatrix(int cellRow, int cellCol, int[][] cellMatrix, int[][] matrix) {
		for (int i = 0; i < cellMatrix.length; i++)
			for (int j = 0; j < cellMatrix.length; j++)
				matrix[cellRow * 10 + i][cellCol * 10 + j] = cellMatrix[i][j];
		return matrix;
	}

	/**
	 * @param starRow
	 * @param startCol
	 * @return a cell with a matrix of 10x10 rows and columns
	 */
	private static Cell generateCell(int[][] image, int starRow, int startCol) {
		int[][] matrix = new int[10][10];

		for (int i = starRow; i < starRow + 10; i++)
			for (int j = startCol; j < startCol + 10; j++)
				matrix[i - starRow][j - startCol] = image[i][j];

		return new Cell(matrix);
	}

}
