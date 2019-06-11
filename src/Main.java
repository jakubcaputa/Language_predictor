import java.util.Scanner;

// Main executive class
// User provides text
// The app recognizes language and allows to predict next words based on previous
public class Main {
    private Main() {
    };

    public static void main(String[] args) throws Exception {

        boolean program_loop = true;

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
                            System.out.println("Waiting for URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();
                            Language_model polish_model = new Language_model();
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
                            System.out.println("Waiting for URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();
                            break;
                        case 3:
                            System.out.println("Waiting for URL:");
                            scan = new Scanner(System.in);
                            url = scan.nextLine();
                            break;
                    }
                case 2:

                    System.out.println("Waiting for URL:");
                    scan = new Scanner(System.in);
                    url = scan.nextLine();
                    break;
                case 3:

                    System.out.println("Waiting for URL:");
                    scan = new Scanner(System.in);
                    url = scan.nextLine();
                    break;

                case 4:

                    System.out.println("Waiting for a word:");
                    break;

                case 5:
                    program_loop = false;
            }

            break;
        }
    }
}
