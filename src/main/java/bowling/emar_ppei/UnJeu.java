package bowling.emar_ppei;

/**
 * Created by Neness on 09/03/2016.
 *
 * Un jeu et composé de deux essais ou deux lancer
 */
public class UnJeu {

    /*
     Le nombre de quilles tombée lors du premier lancer
     */
    private int premierEssai;

    /*
     * Le nombre de quilles tombées lors du deuxieme lancer
     */
    private int deuxiemeEssai;

    /**
     *
     * @param premierEssai
     * @param deuxiemeEssai
     */
    public UnJeu(int premierEssai, int deuxiemeEssai) {
        this.premierEssai = premierEssai;
        this.deuxiemeEssai = deuxiemeEssai;
    }

    public UnJeu(String strike){
        this(UnePartieBowling.NB_QUILLES,0);
    }

    public UnJeu(int pEssai, String s){
        //Aucune quille n'est tombée au deuxieme lancer
        if (s.equals("_")){
            this.premierEssai = pEssai;
            this.deuxiemeEssai = 0;
        //Un spare
        } else if (s.equals("/")) {
            this.premierEssai = pEssai;
            this.deuxiemeEssai = UnePartieBowling.NB_QUILLES - this.premierEssai;
        }
    }

    public int getPremierEssai() {
        return premierEssai;
    }

    public int getDeuxiemeEssai() {
        return deuxiemeEssai;
    }

    public boolean estUnStrike() {
        return UnePartieBowling.NB_QUILLES == premierEssai;
    }

    public boolean estUnSpare() {
        return (premierEssai + deuxiemeEssai) == UnePartieBowling.NB_QUILLES;
    }
}
