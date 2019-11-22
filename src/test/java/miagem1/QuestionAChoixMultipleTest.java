package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple q;

    @Before
    public void setUp() throws Exception {
        ArrayList<Integer> choix = new ArrayList<Integer>();
        choix.add(3);
        choix.add(2);
        this.q = new QuestionAChoixMultiple("Who is Joe ?", choix);
    }

    @Test
    public void testGetEnonce() {
        // When : on demande son énoncé à la question
        String resEnonce = q.getEnonce();
        // Then : L'enoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("L'enoncé ne correspond pas !", "Who is Joe ?", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        // When : on demande le score pour un indice
        float resScore = q.getScoreForIndice(2);
        // then : Le socre retourné est 100 donc l'indice de la bonne réponse est bien celui fourni à la construction
        assertEquals("L'indice ne correspond pas !", 100/2.0, resScore, 0.0);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // When : on demande le score pour un indice
        float resScore = q.getScoreForIndice(1);
        // then : Le socre retourné est 0 donc l'indice de la réponse n'est pas l'un de ceux fournis à la construction
        assertEquals("L'indice ne correspond pas !", 0, resScore, 0.0);
    }
}