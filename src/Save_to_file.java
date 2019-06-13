import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
public abstract class Save_to_file {
    public static void save(String url, String filename)throws Exception {
        Writer save_to_file = new BufferedWriter(new FileWriter(filename,true));
        save_to_file.append(System.lineSeparator());
        save_to_file.append(url);
        save_to_file.close();
    }

}
