package bowling.emar_ppei;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pierrepeinado on 09/03/2016.
 */
public class PartieBowlingTest {

    PartieBowling partie, partie2, partie3, partie4, partie5, partie6;
    String sPartie = "XXXXXXXXXXXX";
    String sPartie2 = "XX";
    String sPartie3 = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
    String sPartie4 = "XXXXXXXXXXXX";
    String sPartie5 = "9_9_9_9_9_____9_9_9_";
    String sPartie6 = "5/5/5/5/5/5/5/5/5/5/5";

    @Before
    public void setUp() throws Exception {
        partie = new PartieBowling(sPartie);
        partie2 = new PartieBowling(sPartie2);
        partie3 = new PartieBowling(sPartie3);
        partie4 = new PartieBowling(sPartie4);
        partie5 = new PartieBowling(sPartie5);
        partie6 = new PartieBowling(sPartie6);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testNbLancersOK() throws Exception {
        assert partie.nbLancersOK();
        assert !partie2.nbLancersOK();
        assert !partie3.nbLancersOK();
    }

    @Test
    public void testCalculScoreStrike() throws Exception {
        char nextThrow1;
        char nextThrow2;
        int scoreResult;

        //Deux strikescalculerScorePartie
        nextThrow1 = 'X';
        nextThrow2 = 'X';

        scoreResult = partie.calculScoreStrike(nextThrow1, nextThrow2);
        assert scoreResult == 30;


        //1 strike + 7 quilles tombées
        nextThrow1 = 'X';
        nextThrow2 = '7';

        scoreResult = partie.calculScoreStrike(nextThrow1, nextThrow2);
        assert scoreResult == 27;


        //1 strike + 0 quilles tombées
        nextThrow1 = 'X';
        nextThrow2 = '_';

        scoreResult = partie.calculScoreStrike(nextThrow1, nextThrow2);
        assert scoreResult == 20;

        //7 quilles tombées + 1 strike
        nextThrow1 = '7';
        nextThrow2 = '/';

        scoreResult = partie.calculScoreStrike(nextThrow1, nextThrow2);
        assert scoreResult == 20;


        //3 quilles tombées + 5 quilles tombées
        nextThrow1 = '3';
        nextThrow2 = '5';

        scoreResult = partie.calculScoreStrike(nextThrow1, nextThrow2);
        assert scoreResult == 18;


        //3 quilles tombées + spare
        nextThrow1 = '3';
        nextThrow2 = '/';

        scoreResult = partie.calculScoreStrike(nextThrow1, nextThrow2);
        assert scoreResult == 20;

    }

    @Test
    public void testCalculScoreSpare() throws Exception {
        char lancer1 = 'X';
        char lancer2 = '_';
        char lancer3 = '5';

        assert partie.calculScoreSpare(lancer1) == 20;
        assert partie.calculScoreSpare(lancer2) == 10;
        assert partie.calculScoreSpare(lancer3) == 15;
    }

    @Test
    public void testCalculerScorePartie() throws Exception {

        System.out.println(partie4.calculerScorePartie());
        System.out.println(partie5.calculerScorePartie());
        System.out.println(partie6.calculerScorePartie());
        assert partie4.calculerScorePartie() == 300;
        assert partie5.calculerScorePartie() == 72;
        assert partie6.calculerScorePartie() == 150;
    }
}