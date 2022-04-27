package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;


public class ImageReader {
    public static int[][] BMPToArray(String BMPFileName, char b, char w) throws IOException {

        BufferedImage image = null;
        try {
            image = ImageIO.read(new FileInputStream(BMPFileName));
        } catch (IOException e) {
            System.err.println("Error: File not found!");
            System.exit(-1);
        }
        int arr[][] = new int[image.getWidth()][image.getHeight()];
        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    arr[xPixel][yPixel] = b;
                } else if (color == Color.WHITE.getRGB()) {
                    arr[xPixel][yPixel] = w;
                }
            }
        }
        return  arr;
    }
}
