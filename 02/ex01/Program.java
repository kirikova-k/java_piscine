package ex01;

import java.io.*;
import java.util.*;

public class Program {
    private static final int ERROR_EXIT_CODE = -1;
    private static final int DEFAULT_EXIT_CODE = 0;
    public static double getSimilarity(String file1, String file2) throws IOException {

        BufferedReader myBufferedReader = null;
        String lineA = null;
        String lineB = null;

        try {

            myBufferedReader = new BufferedReader(new FileReader(System.getenv("PWD") + "/" + file1), 10000000);
            lineA = myBufferedReader.readLine();
            myBufferedReader = new BufferedReader(new FileReader(System.getenv("PWD") + "/" + file2), 10000000);
            lineB = myBufferedReader.readLine();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(ERROR_EXIT_CODE);

        } finally {
            myBufferedReader.close();
        }

        Set<String> dict = new HashSet<>();
        List<String> fileArrA = null;
        List<String> fileArrB = null;

        try {

            fileArrA = Arrays.asList(lineA.split("\\s+"));
            fileArrB = Arrays.asList(lineB.split("\\s+"));

        } catch (NullPointerException e ) {
            System.out.println("Empty file");
            System.exit(ERROR_EXIT_CODE);
        }

        dict.addAll(fileArrA);
        dict.addAll(fileArrB);

        List<Integer> fileFrequencyA = new ArrayList<>(dict.size());
        List<Integer> fileFrequencyB = new ArrayList<>(dict.size());

        for (String word : dict) {

            fileFrequencyA.add(Collections.frequency(fileArrA, word));
            fileFrequencyB.add(Collections.frequency(fileArrB, word));
        }

        int numerator = 0;
        for (int i = 0; i < dict.size(); i++)
            numerator += (fileFrequencyA.get(i) * fileFrequencyB.get(i));

        double denominator;
        int denominatorA = 0;
        int denominatorB = 0;

        for (Integer n : fileFrequencyA) {
            denominatorA += n * n;
        }

        for (Integer n : fileFrequencyB) {
            denominatorB += n * n;
        }

        denominator = Math.sqrt(denominatorA) * Math.sqrt(denominatorB);

        if (denominator == 0)
            return (DEFAULT_EXIT_CODE);

        return numerator / denominator;
    }
    public static void main(String[] args) throws IOException {

        if (args.length < 2) {

            System.exit(ERROR_EXIT_CODE);
        }

        String result = String.format("%.3f", getSimilarity(args[0], args[1]));
        System.out.print("Similarity = ");
        System.out.printf("%.4s\n", result);

    }
}