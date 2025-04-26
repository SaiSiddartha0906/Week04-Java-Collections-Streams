package IOStreams;

import java.io.*;

public class PipedStreamCommunication {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {

            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos, BUFFER_SIZE);

            Thread writerThread = new Thread(() -> {
                try (pos) {
                    String[] messages = {
                        "First message",
                        "Second message",
                        "Third message"
                    };
                    
                    for (String msg : messages) {
                        byte[] data = msg.getBytes();
                        pos.write(data, 0, data.length);
                        pos.flush();
                        System.out.println("Sent: " + msg);
                        Thread.sleep(500); 
                    }
                } catch (IOException | InterruptedException e) {
                    System.err.println("Writer error: " + e.getMessage());
                }
            });

            Thread readerThread = new Thread(() -> {
                try (pis) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead;
                    
                    while ((bytesRead = pis.read(buffer)) != -1) {
                        String received = new String(buffer, 0, bytesRead);
                        System.out.println("Received: " + received);
                    }
                } catch (IOException e) {
                    System.err.println("Reader error: " + e.getMessage());
                }
            });

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Main error: " + e.getMessage());
        }
    }
}

