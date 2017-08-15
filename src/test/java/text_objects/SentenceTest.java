package text_objects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maksym_Petrenko on 8/15/2017.
 */
public class SentenceTest {
    private Sentence sentence = new Sentence();

    @Test
    public void findMaxRepeatableSentencesWithSameWords(){
        String text = "This is the first sentence. " +
                "I add one more. Check if here word word repeat.";
        assertEquals(1,sentence.getMaxAmountSentencesWithRepeatableWords(text));
    }

    @Test
    public void getSentencesInAscOrderWords(){
        String text = "Second sentence. Third huge sentence. First.";
        assertEquals("First. Second sentence. Third huge sentence.",sentence.getSentencesInAscOrderWords(text));

    }
}
