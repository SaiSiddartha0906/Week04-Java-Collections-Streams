package IOStreams;

import java.io.*;

public class LargeFileErrorFilter {
    public static void main(String[] args) {
        String filePath = "large_log.txt";
        File file = new File(filePath);
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());
        System.out.println("Readable: " + file.canRead());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}