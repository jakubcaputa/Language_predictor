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
                           /* for(Bigram k: polish_model.getBigram_word()){
                                System.out.print(k.getFirst_word());
                                System.out.print(" ");
                                System.out.println(k.getSecond_word());
                            }*/

                            break;
                        case 2:
                            System.out.println("Waiting for english URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();

                            english_model.Parse(url);
                            english_model.Train_unigram();
                            english_model.Train_bigram();
                            english_model.Train_bigram_words();
                         /*   for(Bigram k: english_model.getBigram_word()){
                                System.out.print(k.getFirst_word());
                                System.out.print(" ");
                                System.out.println(k.getSecond_word());
                            }*/
                            break;
                        case 3:
                            System.out.println("Waiting for german URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();

                            german_model.Parse(url);
                            german_model.Train_unigram();
                            german_model.Train_bigram();
                            german_model.Train_bigram_words();
                        /*    for(Bigram k: german_model.getBigram_word()) {
                                System.out.print(k.getFirst_word());
                                System.out.print(" ");
                                System.out.println(k.getSecond_word());
                            }*/
                    }break;
                case 2:

                    System.out.println("Waiting for URL in order to recognize using unigram:");
                    scan = new Scanner(System.in);
                    url = scan.nextLine();
                    String language = Language_recognizer.check_language_unigram(polish_model,english_model,german_model,url);
                    System.out.println(language);

                    break;
                case 3:

                    System.out.println("Waiting for URL in order to recognize using bigram:");
                    scan = new Scanner(System.in);
                    url = scan.nextLine();
                    String language2 = Language_recognizer.check_language_bigram(polish_model,english_model,german_model,url);
                    System.out.println(language2);

                    break;

                case 4:
                    System.out.println("Choose a language you want to use:");
                    System.out.println("1. Polish");
                    System.out.println("2. English");
                    System.out.println("3. German");
                    scan = new Scanner(System.in);
                    String sentence="";
                    int check = 0;
                switch(scan.nextInt()) {
                    case 1:
                        while (check != 5) {
                            System.out.print("Your sentence: ");
                            System.out.println(sentence);
                            System.out.println("Waiting for polish word:");
                            scan = new Scanner(System.in);
                            String current_word = scan.next();
                            sentence = current_word;
                            String[] predicted_words = Language_predictor.predict(current_word, polish_model.getBigram_word());
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
                            check = scan.nextInt();
                            if (check == 1) {
                                sentence += " " + predicted_words[0];

                            } else if (check == 2) {
                                sentence += " " + predicted_words[1];

                            } else if (check == 3) {
                                sentence += " " + predicted_words[2];

                            }
                        }
                        break;
                    case 2:
                        while (check != 5) {
                            System.out.println("Waiting for english word");
                            scan = new Scanner(System.in);
                            String current_word = scan.next();
                            String[] predicted_words = Language_predictor.predict(current_word, english_model.getBigram_word());
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
                            check = scan.nextInt();
                            if (check == 1) {
                                sentence += " " + predicted_words[0];

                            } else if (check == 2) {
                                sentence += " " + predicted_words[1];

                            } else if (check == 3) {
                                sentence += " " + predicted_words[2];

                            }

                            check = scan.nextInt();
                        }

                        break;
                    case 3:
                        while(check!=5){
                        System.out.println("Waiting for german word");
                        scan = new Scanner(System.in);
                        String current_word = scan.next();
                        String []predicted_words=Language_predictor.predict(current_word,german_model.getBigram_word());
                        System.out.println("Which word you want to choose?");
                        int p = 1;
                        for(String k: predicted_words){
                            System.out.print(p);
                            System.out.print(". ");
                            System.out.println(k);
                            p++;
                        }
                            System.out.print("4. ");
                            System.out.println("another word");
                            System.out.println("5. exit");
                            check = scan.nextInt();
                            if (check == 1) {
                                sentence += " " + predicted_words[0];

                            } else if (check == 2) {
                                sentence += " " + predicted_words[1];

                            } else if (check == 3) {
                                sentence += " " + predicted_words[2];

                            }
                        check = scan.nextInt();}

                        break;


                }
                case 5:
                    program_loop = false;
                    break;
            }


        }
    }
}
