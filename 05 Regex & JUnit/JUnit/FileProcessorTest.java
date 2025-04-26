package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;

public class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    String testFile = "testfile.txt";

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit!";
        processor.writeToFile(testFile, content);

        File file = new File(testFile);
        assertTrue(file.exists());
        assertEquals(content, processor.readFromFile(testFile));
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> processor.readFromFile("nonexistent.txt"));
    }

    @AfterEach
    void cleanup() {
        new File(testFile).delete();
    }
}
