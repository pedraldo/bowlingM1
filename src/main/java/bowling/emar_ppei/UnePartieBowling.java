package bowling.emar_ppei;

/**
 * Created by Neness on 09/03/2016.
 *
 * On ne calculera pas les scores intermediaires.
 * Donc on fournit à chaque fois une sequence complete.
 */
public class UnePartieBowling {
    /*
    Nombre de jeux par partie
     */
    public static final int NB_JEUX = 10;

    /*

     */
    public static final int NB_QUILLES = 10;

    /*
     *
     */
    private Joueur joueur;

    /**
     *
     */
    private UnJeu[] sequence;

    /**
     *
     */
    public UnePartieBowling(Joueur j, UnJeu[] uneSequence){
        joueur = j;
        this.sequence = uneSequence;
    }

    public boolean estUneSequenceValide(){
        return NB_JEUX <= sequence.length && sequence.length <= 12;
    }

    private boolean tousLesQuillesSontTombées(UnJeu jeu){
        return (jeu.getPremierEssai() + jeu.getDeuxiemeEssai()) == NB_QUILLES;
    }

    public int calculerScore() throws Exception {
        int score = 0;
        if (!estUneSequenceValide())
            throw new Exception("Sequence non valide. Taille: "+ sequence.length);
        for(int i = 0; i < NB_JEUX; i++){
            UnJeu j = sequence[i];
            if (tousLesQuillesSontTombées(j)){
                if (j.estUnStrike()) {
                    score += (10
                            + sequence[i + 1].getPremierEssai()
                            + sequence[i + 1].getDeuxiemeEssai());
                } else {
                    score += (10 + sequence[i + 1].getPremierEssai());
                }
            } else {
                score += (j.getPremierEssai() + j.getDeuxiemeEssai());
            }
        }
        joueur.setScore(score);
        return score;
    }
}
