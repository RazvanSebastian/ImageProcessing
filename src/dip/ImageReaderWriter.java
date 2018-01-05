package dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReaderWriter {

	public static BufferedImage readimage(String filename) {
		File file = new File(filename);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
			return bufferedImage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedImage;
	}

	public static void writeImage(String filename, BufferedImage bufferedImage) {
		File ouptut = new File(filename);
		try {
			ImageIO.write(bufferedImage, "bmp", ouptut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeImage(String filename, int[][] image) {
		BufferedImage bufferedImage = new BufferedImage(image.length, image.length, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				Color c = new Color(image[i][j], image[i][j], image[i][j]);
				bufferedImage.setRGB(i, j, c.getRGB());
			}
		}
		File output = new File(filename);
		try {
			ImageIO.write(bufferedImage, "bmp", output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
