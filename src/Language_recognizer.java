public abstract class Language_recognizer {
    private static Language_model unigram_recognize_model = new Language_model();
    public static String check_language(Language_model polish_model, Language_model english_model, Language_model german_model, String url)throws Exception{
        unigram_recognize_model.Parse(url);
        unigram_recognize_model.Train_unigram();
        float [] polish_difference = new float[unigram_recognize_model.getUnigrams().values().size()];
        float [] english_difference = new float[unigram_recognize_model.getUnigrams().values().size()];
        float [] german_difference = new float[unigram_recognize_model.getUnigrams().values().size()];
        int j = 0;
        for(Integer k: polish_model.getUnigrams().keySet()){
            polish_difference[j] = Math.abs(polish_model.getUnigrams().get(k)-unigram_recognize_model.getUnigrams().get(k));
            j++;
        }
        j = 0;
        for(Integer k: english_model.getUnigrams().keySet()){
            english_difference[j] = Math.abs(english_model.getUnigrams().get(k)-unigram_recognize_model.getUnigrams().get(k));
            j++;
        }
        j = 0;
        for(Integer k: german_model.getUnigrams().keySet()){
            german_difference[j] = Math.abs(german_model.getUnigrams().get(k)-unigram_recognize_model.getUnigrams().get(k));
            j++;
        }
        float total_polish_diff = 0;
        float total_english_diff = 0;
        float total_german_diff = 0;

        for(float k: polish_difference) total_polish_diff += k;
        for(float k: english_difference) total_english_diff += k;
        for(float k: german_difference) total_german_diff += k;

        String language;

        if(total_polish_diff<total_english_diff && total_polish_diff < total_german_diff) language = "It is polish";
        else if (total_english_diff < total_polish_diff && total_english_diff < total_german_diff) language = "It is english";
        else language = "It is german";

        return language;
    }
}
