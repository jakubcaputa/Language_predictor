import java.util.LinkedHashMap;

public class Bigram {

    public String first_word;
    public LinkedHashMap<String, Integer> second_word = new LinkedHashMap<>();
    public Bigram(){};
    public Bigram(String first_word){
        this.first_word = first_word;
    }

    public String getFirst_word() {
        return first_word;
    }

    public LinkedHashMap<String, Integer> getSecond_word() {
        return second_word;
    }
}