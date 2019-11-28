package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur s;
    private QuestionAChoixMultiple qm;
    private QuestionAChoixExclusif qe;
    private ArrayList<Integer> choixMultiple;

    @Before
    public void setUp() throws Exception {
        ArrayList<Integer> choix = new ArrayList<Integer>(Arrays.asList(2,3, 5));
        this.qm = new QuestionAChoixMultiple("Who is Javier ?", choix);
        this.s = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScoreQuestionChoixMultipleBonneReponsePartielle(){
        this.choixMultiple = new ArrayList<Integer>(Arrays.asList(2,3));
        float scoreAttendu = 2*100/3;
        float scoreTest = Math.round(this.s.calculeScore(choixMultiple, this.qm)*10)/10;
        assertEquals("Le score n'est pas correct", scoreAttendu, scoreTest, 0.01);
    }

    @Test
    public void testCalculeScoreQuestionChoixMultipleBonneReponseComplete(){
        this.choixMultiple = new ArrayList<Integer>(Arrays.asList(2,3, 5));
        float scoreAttendu = 100;
        float scoreTest = this.s.calculeScore(choixMultiple, qm);
        assertEquals("Le score n'est pas correct", scoreAttendu, scoreTest, 0.01);
    }

    @Test
    public void testCalculeScoreQuestionChoixMultipleMauvaiseReponse(){
        this.choixMultiple = new ArrayList<Integer>(Arrays.asList(1,4));
        float scoreAttendu = 0;
        float scoreTest = this.s.calculeScore(choixMultiple, qm);
        assertEquals("Le score n'est pas correct", scoreAttendu, scoreTest, 0.0);
    }

    @Test
    public void testCalculeScoreQuestionChoixMultipleMauvaiseReponseEnTrop(){
        this.choixMultiple = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        float scoreAttendu = 0;
        float scoreTest = this.s.calculeScore(choixMultiple, qm);
        assertEquals("Le score n'est pas correct", scoreAttendu, scoreTest, 0.01);
    }

    @Test
    public void testCalculeScoreQuestionChoixMultipleBonneEtMauvaiseReponse(){
        this.choixMultiple = new ArrayList<>(Arrays.asList(1, 2, 3));
        double scoreAttendu = 16.66;
        float scoreTest = this.s.calculeScore(choixMultiple, qm);
        assertEquals("Le score n'est pas correct", scoreAttendu, scoreTest, 0.01);
    }
}