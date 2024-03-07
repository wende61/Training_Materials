import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileExample {

    public static void create() {
        // Using FileOutputStream() constructor
        // Using File.createNewFile() method
        // Using Files.write() method
        File file = new File("javadirectory/testFile1.txt");

        // Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            String data = "Test data";
            Files.write(Paths.get("javadirectory/testFile2.txt"), data.getBytes());

            List<String> lines = Arrays.asList("1st line", "2nd line");
            Files.write(Paths.get("file6.txt"), lines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write() {
        try {
            byte bWrite[] = { 65, 66, 67, 68, 69 };

            OutputStream os = new FileOutputStream("test.txt"); // creates a file
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.println((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

    public static void main(String[] args) {
        File f = null;
        String[] files = { "file1.txt", "file2.txt" };
        try {
            //create a file
            create();
            // write to file
            write();
            // for each string in string array
            for (String s : files) {
                // create new file
                f = new File(s);

                // true if the file is executable
                boolean bool = f.canExecute();

                // find the absolute path
                String a = f.getAbsolutePath();

                // prints absolute path
                System.out.print(a);

                // prints
                System.out.println(" is executable: " + bool);
            }
        } catch (Exception e) {
            // if any I/O error occurs
            e.printStackTrace();
        }
    }
}
