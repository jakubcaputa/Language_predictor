import java.util.Scanner;

// Main executive class
// User provides text
// The app recognizes language and allows to predict next words based on previous
public class Main {
    private Main() {
    };

    public static void main(String[] args) throws Exception {

        boolean program_loop = true;
        Language_model polish_model = new Language_model();
        Language_model english_model = new Language_model();
        Language_model german_model = new Language_model();


        while (program_loop) {

            System.out.println("1. Train algorithm");
            System.out.println("2. Recognize language using unigram");
            System.out.println("3. Recognize language using bigram");
            System.out.println("4. Word prediction using bigram");
            System.out.println("5. Exit");

            String url;
            Scanner scan = new Scanner(System.in);
            switch (scan.nextInt()){
                case 1:
                    System.out.println("Set a language you want to train:");
                    System.out.println("1. Polish");
                    System.out.println("2. English");
                    System.out.println("3. German");
                    scan = new Scanner(System.in);
                    switch(scan.nextInt()){
                        case 1:
                            System.out.println("Waiting for polish URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();

                            polish_model.Parse(url);
                            polish_model.Train_unigram();
                            polish_model.Train_bigram();
                            polish_model.Train_bigram_words();
                            for(Bigram k: polish_model.getBigram_word()){
                                System.out.print(k.getFirst_word());
                                System.out.print(" ");
                                System.out.println(k.getSecond_word());
                            }

                            break;
                        case 2:
                            System.out.println("Waiting for english URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();

                            english_model.Parse(url);
                            english_model.Train_unigram();
                            english_model.Train_bigram();
                            english_model.Train_bigram_words();
                            for(Bigram k: english_model.getBigram_word()){
                                System.out.print(k.getFirst_word());
                                System.out.print(" ");
                                System.out.println(k.getSecond_word());
                            }
                            break;
                        case 3:
                            System.out.println("Waiting for german URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();

                            german_model.Parse(url);
                            german_model.Train_unigram();
                            german_model.Train_bigram();
                            german_model.Train_bigram_words();
                            for(Bigram k: german_model.getBigram_word()) {
                                System.out.print(k.getFirst_word());
                                System.out.print(" ");
                                System.out.println(k.getSecond_word());
                            }
                    }break;
                case 2:

                    System.out.println("Waiting for URL in order to recognize using unigram:");
                    scan = new Scanner(System.in);
                    url = scan.nextLine();
                    String language = Language_recognizer.check_language(polish_model,english_model,german_model,url);
                    System.out.println(language);

                    break;
                case 3:

                    System.out.println("Waiting for URL5:");
                    scan = new Scanner(System.in);
                    url = scan.nextLine();
                    break;

                case 4:

                    System.out.println("Waiting for a word:");
                    break;

                case 5:
                    program_loop = false;
            }


        }
    }
}
