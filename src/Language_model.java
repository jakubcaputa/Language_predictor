import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.LinkedHashMap;

public class Language_model {
    private char[] signs = "aąbcdeęfghijklłmnńoóprsśtuwyzźżqxväößü".toCharArray();
    private LinkedHashMap<Integer, Float> unigrams = new LinkedHashMap<>();
    private LinkedHashMap<String, Float> bigrams = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> unigram_words = new LinkedHashMap<>();
    private String text;
    private Bigram [] bigram_word;
    public Language_model(){

   }
    public void Parse(String url) throws Exception{
        url = url.substring(0,url.length()-1);
        Document doc = Jsoup.connect(url).get();
        text += doc.body().text().toLowerCase();
    }

    public void Train_unigram(){
        int j = 0;
        for (char i : signs) {
            unigrams.put((int) signs[j], (float) text.chars().filter(ch -> ch == i).count());
            j++;
        }
        float sum=0;
        for (float  f: unigrams.values()) {
            sum += f;
        }
        int jj=0;
        for (float  f: unigrams.values()) {

            unigrams.put((int) signs[jj],  f*100/sum);
            jj++;
        }
    }
    public void Train_bigram(){
        String[] bigramArray = new String[signs.length*signs.length];
        int counter = 0;
        for (int i = 0; i <signs.length ; i++) {
            for (int k = 0; k <signs.length ; k++) {
                bigramArray[counter]= ""+signs[i]+""+signs[k];
                counter++;
            }
        }
        for (String tt : bigramArray) {
            bigrams.put(tt,(float) 0);
        }
        String CurrentBigram;
        for (int i = 0; i <text.length()-1 ; i++) {
            CurrentBigram=""+text.charAt(i)+text.charAt(i+1);
            if ( bigrams.containsKey(CurrentBigram))
            {
                bigrams.put( CurrentBigram,bigrams.get(CurrentBigram)+1);
            }
        }
         float sum=0;
        for (float  f: bigrams.values()) {
            sum += f;
        }
        counter = 0;
        for (float  f: bigrams.values()) {
            bigrams.put(bigramArray[counter],  f*100/sum);
            counter++;
        }
    }

    public void Train_bigram_words(){
        String[] words= text.split(" ");
        int j = 0;
        for(String k: words){
            unigram_words.put(k,j);
        }
        Bigram [] bigram_words = new Bigram[unigram_words.size()];
        for(String k: unigram_words.keySet()){
            bigram_words[j] = new Bigram(k);
            for(int i = 0; i < words.length-1; i++){
                if(k.equals(words[i])){
                    if(bigram_words[j].second_word.containsKey(words[i+1])){
                        bigram_words[j].second_word.put(words[i+1],bigram_words[j].second_word.get(words[i+1])+1);
                    }
                    else bigram_words[j].second_word.put(words[i+1],1);
                }
            }
            j++;
        }

        bigram_word = bigram_words;
    }




    public LinkedHashMap<Integer, Float> getUnigrams() {
        return unigrams;
    }

    public LinkedHashMap<String, Float> getBigrams() {
        return bigrams;
    }

    public LinkedHashMap<String, Integer> getUnigram_words() {
        return unigram_words;
    }

    public Bigram[] getBigram_word() {
        return bigram_word;
    }

}
