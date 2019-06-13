import java.io.*;
import java.util.Scanner;
public abstract class Scan_from_file {
    public static void scan(Language_model model, String filename)throws Exception{
        Scanner scan_from_file = new Scanner(new FileReader(filename));
        while(scan_from_file.hasNextLine()) {
            model.Parse(scan_from_file.nextLine());
            model.Train_unigram();
            model.Train_bigram();
            model.Train_bigram_words();
        }
    }
}
