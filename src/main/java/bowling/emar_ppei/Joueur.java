package bowling.emar_ppei;

/**
 * Created by Neness on 09/03/2016.
 */
public class Joueur{
    /*

     */
    private String mNom;

    /*

     */
    private String mPrenom;

    /*
     *
     */
    private int mScore;

    /**
     *
     * @param mNom
     * @param mPrenom
     */
    public Joueur(String mNom, String mPrenom) {
        this.mNom = mNom;
        this.mPrenom = mPrenom;
        this.mScore = 0;
    }

    public String getNom() {
        return this.mNom;
    }


    public String getPrenom() {
        return this.mPrenom;
    }

    public void setScore(int score){
        this.mScore = score;
    }

    @Override
    public String toString() {
        return "Le joueur " + getNom() + " " + getPrenom() + " a fait un score de " + mScore;
    }
}
