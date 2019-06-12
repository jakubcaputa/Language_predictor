public abstract class Language_predictor {

    public static String[] predict(String word, Bigram[] bigram_words){
        String []b = new String[3];
        String a ="";
        for(int i = 0; i < 3; i++) {
            for (Bigram k : bigram_words) {
                if (word.equals(k.getFirst_word())){
                    for (String w : k.getSecond_word().keySet()) {
                        a = w;
                        break;
                    }
                for (String w : k.getSecond_word().keySet()) {
                    if (k.getSecond_word().get(w) > k.getSecond_word().get(a)) {
                        a = w;
                    }

                    }
                k.getSecond_word().remove(a);
                    b[i] = a;
                }
             }
        }
        if (b[0] == b[1] && b[1] == b[2]){
            b[0] = "EMPTY!";
            b[1] = "EMPTY!";
            b[2] = "EMPTY!";
        }
        if (b[1]==b[2]) b[2] = "EMPTY!";
        return b;
    }
}
