package miagem1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {
    private QuestionAChoixExclusif q;

    @Before
    public void setUp() throws Exception{
        //Given : Une instantce de question à choix exclusif
        this.q = new QuestionAChoixExclusif("Who is Joe ?", 2);
    }

    @Test
    public void testGetEnonce() {
        // When : on demande son énoncé à la question
        String resEnonce = q.getEnonce();
        // Then : L'enoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("L'enoncé ne correspond pas !", "Who is Joe ?", resEnonce);
    }

    @Test
    public void testGetScoreForIndice() {
        // When : on demande le score pour un indice
        float resScore = q.getScoreForIndice(2);
        // then : Le socre retourné est 100 donc l'indice de la bonne réponse est bien celui fourni à la construction
        assertEquals("L'indice ne correspond pas !", 100, resScore, 0.0);
        assertNotEquals("L'indice ne devrait pas correspondre", 100, q.getScoreForIndice(1), 0.0);
    }
}
