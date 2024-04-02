import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    FileWriter fileWriter;


    public Writer() {
        try {
            fileWriter = new FileWriter("data/secLinks.txt");
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    public void write (String string){
        try {
            fileWriter.write(string.concat("\n"));
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
