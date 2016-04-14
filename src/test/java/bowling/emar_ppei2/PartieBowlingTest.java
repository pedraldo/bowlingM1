package bowling.emar_ppei2;

import bowling.emar_ppei.PartieBowling;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pierrepeinado on 09/03/2016.
 */
public class PartieBowlingTest {

    PartieBowling partie, partie2, partie3;
    String sPartie = "XXXXXXXXXXXX";
    String sPartie2 = "XX";
    String sPartie3 = "XXXXXXXXXXXXXXXXXXXXXXXXXX";

    @Before
    public void setUp() throws Exception {
        partie = new PartieBowling(sPartie);
        partie2 = new PartieBowling(sPartie2);
        partie3 = new PartieBowling(sPartie3);
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

    }
}