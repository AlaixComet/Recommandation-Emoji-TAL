import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String separateur[] = new String[4];
        separateur[0] = "?";
        separateur[1] = "!";
        separateur[2] = "...";
        separateur[3] = ".";
        ArrayList<String> negatif = new ArrayList<>();
        negatif.add("ne");
        negatif.add("non");
        negatif.add("n'");
        negatif.add("peu");
        negatif.add("pas");
        negatif.add("triste");
        negatif.add("pas");
        ArrayList<String> positif = new ArrayList<>();
        positif.add("oui");
        positif.add("merci");
        positif.add("bien");
        positif.add("content");
        positif.add("bien");
        int quitter = 0;

        while (quitter == 0){
            int score = 0;
            int scorePrecedent = 0;
            System.out.println("Entrez votre phrase");
            Scanner sc = new Scanner (System.in);
            String phrase = sc.nextLine();
            // detection d'un separateur de phrase
            for(String sep : separateur){

            }
            if(phrase.contains(".")){
                // découpage de toutes les phrases.
                String phraseS[] = phrase.split("\\.");
                for (String ph : phraseS){
                    // découpage de la phrase en focntion des caractère d'espacement
                    String motS[] = ph.split(" ");
                    for (String mot : motS){
                        if (positif.contains(mot)){
                            scorePrecedent = 1 ;
                            score += scorePrecedent;
                        } else if (negatif.contains(mot)){
                            scorePrecedent = -1;
                            score += scorePrecedent;
                        }
                    }

                }
            } else {
                // découpage de la phrase en focntion des caractère d'espacement
                String motS[] = phrase.split(" ");
                for (String mot : motS){
                    if (positif.contains(mot)){
                        scorePrecedent = 1 ;
                        score += scorePrecedent;
                    } else if (negatif.contains(mot)){
                        scorePrecedent = -1;
                        score += scorePrecedent;
                    }
                }
            }
            if (score == 0)System.out.println(":|");
            if (score > 0)System.out.println(":)");
            if (score < 0)System.out.println(":(");

            // condition d'arret
            System.out.println("Voulez-vous quitter le programme ? Y pour oui, N pour non");
            String quit = sc.next();
            if (quit.equals("Y")) quitter = 1;
        }


    }
}
