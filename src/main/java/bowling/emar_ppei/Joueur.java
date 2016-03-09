package bowling.emar_ppei;

/**
 * Created by Neness on 09/03/2016.
 */
public class Joueur implements IPersonne {
    /*

     */
    private String mNom;

    /*

     */
    private String mPrenom;

    /**
     *
     * @param mNom
     * @param mPrenom
     */
    public Joueur(String mNom, String mPrenom) {
        this.mNom = mNom;
        this.mPrenom = mPrenom;
    }

    @Override
    public String getNom() {
        return this.mNom;
    }

    @Override
    public String getPrenom() {
        return this.mPrenom;
    }
}
