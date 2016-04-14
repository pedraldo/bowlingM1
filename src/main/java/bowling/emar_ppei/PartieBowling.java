package bowling.emar_ppei;

/**
 * Created by pierrepeinado on 09/03/2016.
 */

/**
 *  TP noté le 15 avril 2016 à 13h30
 *
 *  Pour le projet Bowling :
 *  - mettre l'accent sur :
 *      - CheckStyle : 0 violation des règles par défaut
 *      - Cobertura : 100% couverture / tests
 *
 *  Remarque : si ce n'est pas déjà fait, supprimer les classes inutiles App et AppTest après avoir créer vos fichiers
 *
 *  Liens utiles pour les raccourcis clavier :
 *      - http://tinyurl.com/intellij-refcard
 *      - http://tinyurl.com/intellij-refcard/mac
 *
 */

public class PartieBowling {

    //private static final int NB_QUILLES = 10;
    private static final int NB_MIN_LANCERS = 11;
    private static final int NB_MAX_LANCERS = 21;
    //private static final int NB_FRAMES = 10;

    public String sLancers;

    public PartieBowling(String partie) {
        sLancers = partie;
    }

    /**
     *
     * @return
     */
    public boolean nbLancersOK() {
        int nbLancers = sLancers.length();
        return (nbLancers >= NB_MIN_LANCERS && nbLancers <= NB_MAX_LANCERS);
    }

    /**
     *
     * @param premier
     * @param deuxieme
     * @return
     */
    public int calculScoreStrike(char premier, char deuxieme) {
        int score = 10;

        //Traitement du premier lancer à suivre
        //Si strike
        if (premier == 'X') {
            score += 10;

            //Si deuxième strike consécutif
            if (deuxieme == 'X') {
                score = 30;
                return score;
            }

            //Si deuxieme aucune quille tombée
            else if (deuxieme == '_') return score;

            //Si deuxieme quelques quilles tombées
            else {
                score += Integer.parseInt(""+deuxieme);
                return score;
            }
        }

        //Si aucune quille tombée
        else if (premier == '_') {
             score = score;
        }

        //Si quilles tombées mais pas toutes
        else score += Integer.parseInt(""+premier);


        //Traitement du deuxième lancer à suivre
        //Si spare
        if (deuxieme == '/') {
            score = 20;
            return score;
        }

        //Si aucune quille tombée
        else if (deuxieme == '_') return score;

        //Si quilles tombées mais pas toutes
        else score += Integer.parseInt(""+deuxieme);


        return score;
    }

    /**
     *
     * @param premier
     * @return
     */
    public int calculScoreSpare(char premier) {
        int score = 10;

        //Traitement du prochain lancer
        //Si strike
        if (premier == 'X') {
            score += 10;
            return score;
        }

        else if (premier == '_') return score;

        else score += Integer.parseInt(""+premier);


        return score;
    }

    /**
     *
     * @return
     */
    public int calculerScorePartie() {

        char lancers [] = sLancers.toCharArray();
        int lancer = 0;
        int iFrame = 0;

        int nbLancers;
        int nbLancersFrame = 0;

        int scoreTotal = 0;
        //int scoreFrame [] = {0,0,0,0,0,0,0,0,0,0};

        boolean lancersSupp = false;


        if (nbLancersOK()) {
            nbLancers = sLancers.length();

            for (int i=0; i<nbLancers; i++) {

                nbLancersFrame++;

                //Si on lance les derniers lancers supplémentaires grâce à un strike ou spare sur la dernière frame
                if (iFrame > 9) {
                    lancersSupp = true;
                    lancer = ((int) lancers[i]);
                }

                //Strike
                if (lancers[i] == 'X') {
                    if (lancersSupp) {
                        //scoreFrame[9] += lancer;
                        scoreTotal += lancer;
                    }

                    else {
                        //scoreFrame[iFrame] = calculScoreStrike(lancers[i+1], lancers[i+2]);
                        scoreTotal = calculScoreStrike(lancers[i+1], lancers[i+2]);
                        iFrame++;
                        continue;
                     }
                }

                //Spare
                if (lancers[i] == '/') {
                    if (lancersSupp) {
                        //scoreFrame[9] += lancer;
                        scoreTotal += lancer;
                    }

                    //scoreFrame[iFrame] = calculScoreSpare(lancers[i+1]);
                    scoreTotal = calculScoreSpare(lancers[i+1]);
                    nbLancersFrame = 0;
                    iFrame++;
                    continue;
                }

                //Aucune quille tombée sur le lancer
                if (lancers[i] == '_') {
                    if (nbLancersFrame < 2) {
                        continue;
                    }

                    else {
                        iFrame++;
                        nbLancersFrame = 0;
                    }
                }

                if (!lancersSupp) lancer = ((int) lancers[i]);

                //Lancer ayant fait tomber une ou des quilles mais pas toutes
                if (lancer > 0 && lancer < 9) {
                    if (lancersSupp) {
                        //scoreFrame[9] += lancer;
                        scoreTotal += lancer;
                        continue;
                    }

                    //scoreFrame[iFrame] += lancer;
                    scoreTotal +=lancer;

                    if (nbLancersFrame == 2) {
                        iFrame++;
                        nbLancersFrame = 0;
                    }
                }
            }

            return scoreTotal;
        }

        else {
            System.out.println("Chaine de caractère incorrecte: représente une partie de Bowling impossible ou incomplète");
        }

        return -1;
    }

}
