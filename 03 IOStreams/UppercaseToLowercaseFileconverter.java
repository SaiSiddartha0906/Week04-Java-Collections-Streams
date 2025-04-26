package IOStreams;

import java.io.*;
import java.nio.charset.Charset;

public class UppercaseToLowercaseFileConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        Charset charset = Charset.forName("UTF-8"); // or your desired encoding

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), charset));
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), charset))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("Conversion completed. Check " + outputFile);
        } catch (IOException e) {
            System.err.println("Error during file processing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

