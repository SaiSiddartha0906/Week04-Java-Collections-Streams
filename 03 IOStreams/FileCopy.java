package IOStreams;
import java.io.*;
public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "input.txt";     
        String destPath = "output.txt";    

        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist: " + sourcePath);
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from " + sourcePath + " to " + destPath);

        } catch (IOException e) {
            System.out.println("An error occurred during file I/O: " + e.getMessage());
        }
    }
}
	