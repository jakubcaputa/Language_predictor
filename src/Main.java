import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
// Main executive class
// User provides text
// The app recognizes language and allows to predict next words based on previous
public class Main  {
    private Main() {
    };

    public static void main(String[] args) throws Exception {

        boolean program_loop = true;
        Language_model polish_model = new Language_model();
        Language_model english_model = new Language_model();
        Language_model german_model = new Language_model();
        Scan_from_file.scan(polish_model,"POLISH_URLS.txt");
        Scan_from_file.scan(english_model,"ENGLISH_URLS.txt");
        Scan_from_file.scan(german_model,"GERMAN_URLS.txt");
        while (program_loop) {
            Console_printer.print_menu();
            String url;
            Scanner scan = new Scanner(System.in);
            switch (scan.nextInt()){
                case 1:
                    Console_printer.print_set_to_train();
                    scan = new Scanner(System.in);
                    switch(scan.nextInt()){
                        case 1:
                            System.out.println("Waiting for polish URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();
                            Save_to_file.save(url,"POLISH_URLS.txt");
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
                            Save_to_file.save(url,"ENGLISH_URLS.txt");
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
                            Save_to_file.save(url,"GERMAN_URLS.txt");
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
                    Console_printer.print_set_to_use();
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
                            sentence = sentence + " " + current_word;
                            String[] predicted_words = Language_predictor.predict(current_word, polish_model.getBigram_word());
                            Console_printer.print_predicted_words(predicted_words);
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
                            System.out.print("Your sentence: ");
                            System.out.println(sentence);
                            System.out.println("Waiting for english word:");
                            scan = new Scanner(System.in);
                            String current_word = scan.next();
                            sentence = sentence + " " + current_word;
                            String[] predicted_words = Language_predictor.predict(current_word, english_model.getBigram_word());
                            Console_printer.print_predicted_words(predicted_words);
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
                    case 3:
                        while(check!=5){
                            System.out.print("Your sentence: ");
                            System.out.println(sentence);
                            System.out.println("Waiting for german word:");
                            scan = new Scanner(System.in);
                            String current_word = scan.next();
                            sentence = sentence + " " + current_word;
                            String[] predicted_words = Language_predictor.predict(current_word, english_model.getBigram_word());
                            Console_printer.print_predicted_words(predicted_words);
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
                }
                case 5:
                    program_loop = false;
                    break;
            }
        }
    }
}
