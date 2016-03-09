package bowling.emar_ppei;

/**
 * Created by Neness on 09/03/2016.
 *
 * A chaque tour un joueur joue deux boules
 */
public interface InterfaceJoueur extends IPersonne {

    /**
     * Lancer la premire boule
     * @return renvoie le nombre de quilles tombées
     */
    public int premireBoule();

    /**
     * Lancer la deuxieme boule
     * @return le nombre de quilles tombées
     */
    public int deuxiemeBoule();
}
