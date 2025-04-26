package IOStreams;

import java.io.*;

public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4KB buffer

    public static void main(String[] args) {
        String source = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        try {
            // Buffered copy
            long bufferedTime = copyWithBufferedStreams(source, destBuffered);
            
            // Unbuffered copy
            long unbufferedTime = copyWithNormalStreams(source, destUnbuffered);

            System.out.println("\n** Results **");
            System.out.printf("Buffered copy time:   %,d ns%n", bufferedTime);
            System.out.printf("Unbuffered copy time: %,d ns%n", unbufferedTime);
            System.out.printf("Buffered version was %d%% faster%n", 
                (int) ((1 - (double) bufferedTime/unbufferedTime) * 100));

        } catch (IOException e) {
            System.err.println("Error during file copy: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static long copyWithBufferedStreams(String source, String dest) throws IOException {
        System.out.println("Starting buffered copy...");
        
        long start = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
             
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        
        return System.nanoTime() - start;
    }

    private static long copyWithNormalStreams(String source, String dest) throws IOException {
        System.out.println("Starting unbuffered copy...");
        
        long start = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
             
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        
        return System.nanoTime() - start;
    }
}

