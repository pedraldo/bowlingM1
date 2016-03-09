package bowling.emar_ppei;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neness on 09/03/2016.
 */
public class UnePartieBowling {
    /*
    Nombre de jeux par partie
     */
    private static final int NB_JEUX = 10;

    private static final int NB_QUILLES = 10;

    /*

     */
    private List<InterfaceJoueur> lJoueur;

    /**
     *
     */
    public UnePartieBowling(){
        lJoueur = new ArrayList<>();
    }

    public void jouerLaPartie(){
        for (int i = 0; i < NB_JEUX; i++){
            for (InterfaceJoueur j: lJoueur){
                //premier essai
                int nbQ = j.premireBoule();
                //deuxieme essai
                nbQ += j.deuxiemeBoule();
                score(nbQ);
            }
        }
    }

    private int score(int nbQ) {

        return 0;
    }

    public int getNbQuilles() {
        return NB_QUILLES;
    }
}
