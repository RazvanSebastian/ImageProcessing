package dip;

import java.awt.image.BufferedImage;
import java.io.IOException;

import dip.fingerprint.FingerPrintImageSegmentation;

public class TestMain {

	public static void main(String[] args) throws IOException {
		BufferedImage image = ImageReaderWriter.readimage("sample1.bmp");
		try {
			int[][] imageInGrayScale = ImageHandler.grayScaleConversion(image);
			Cell[][] cells = ImageHandler.convertMatrixToBlocks(imageInGrayScale);
			Cell[][] cellSegmented = FingerPrintImageSegmentation.imageSegmentation(cells);
			int[][] matrixSegmented = ImageHandler.convertBlocksToMatrix(cellSegmented);
			ImageReaderWriter.writeImage("segmetedSample.bmp", matrixSegmented);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
