package edu.school21.printer.app;
import edu.school21.printer.logic.ImageReader;
import java.io.*;

public class Program {
    private static final int ERROR_EXIT_CODE = -1;
    public static void main(String[] args) throws IOException{

        if (args.length != 2) {
            System.err.println("Error: Wrong number of arguments\n");
            System.exit(ERROR_EXIT_CODE);
        }
        char w = args[0].charAt(0);
        char b = args[1].charAt(0);

        int[][] arr = ImageReader.BMPToArray("/resources/image.bmp", b, w);

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y ++) {
                System.out.print((char)arr[y][x]);
            }
            System.out.println();
        }
    }
}
