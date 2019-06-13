public abstract class Console_printer {
    public static void print_menu(){
        System.out.println("1. Train algorithm");
        System.out.println("2. Recognize language using unigram");
        System.out.println("3. Recognize language using bigram");
        System.out.println("4. Word prediction using bigram");
        System.out.println("5. Exit");
    }

    public static void print_set_to_train() {
        System.out.println("Set a language you want to train:");
        System.out.println("1. Polish");
        System.out.println("2. English");
        System.out.println("3. German");
    }
    public static void print_set_to_use() {
        System.out.println("Set a language you want to use:");
        System.out.println("1. Polish");
        System.out.println("2. English");
        System.out.println("3. German");
    }
    public static void print_predicted_words(String[] predicted_words){
        System.out.println("Which word you want to choose?");
        int p = 1;
        for (String k : predicted_words) {
            System.out.print(p);
            System.out.print(". ");
            System.out.println(k);
            p++;
        }
        System.out.print("4. ");
        System.out.println("another word");
        System.out.println("5. exit");
    }

}
