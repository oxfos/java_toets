package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import interfaces.WordFrequency;
import ordina_java_toets.WordAnalyzer;


public class WordAnalyzerTest {
	
    private WordAnalyzer wordAnalyzer;

    @Before
    public void setUp() {
        wordAnalyzer = new WordAnalyzer();
    }

    @Test
    public void testCalculateHighestFrequency() {
    	// Test return correct highest frequency
        String text = "This is a test. Test this sentence.";
        int highestFrequency = wordAnalyzer.calculateHighestFrequency(text);
        assertEquals(2, highestFrequency);
    }

    @Test
    public void testCalculateFrequencyForWord() {
    	// Test empty string
        String text = "";
        int frequency = wordAnalyzer.calculateFrequencyForWord(text, "test");
        assertEquals(0, frequency);
    	// Test missing word
        text = "This is a test. Test this sentence.";
        frequency = wordAnalyzer.calculateFrequencyForWord(text, "abba");
        assertEquals(0, frequency);
        // Test non string
        text = "# 02 ; &$";
        frequency = wordAnalyzer.calculateFrequencyForWord(text, "test");
        assertEquals(0, frequency);
        text = "# 02As ; &$";
        frequency = wordAnalyzer.calculateFrequencyForWord(text, "test");
        assertEquals(0, frequency);
        text = "# As02 ; &$";
        frequency = wordAnalyzer.calculateFrequencyForWord(text, "test");
        assertEquals(0, frequency);
        // Test valid string
        text = "This is a test. Test this sentence.";
        frequency = wordAnalyzer.calculateFrequencyForWord(text, "test");
        assertEquals(2, frequency);
    }

    @Test
    public void testCalculateMostFrequentNWords() {
    	// Test that the correct words and amount is returned.
        String text = "The sun shines over the lake";
        List<WordFrequency> wordFrequencies = wordAnalyzer.calculateMostFrequentNWords(text, 3);
        assertEquals(3, wordFrequencies.size());
        assertEquals("the", wordFrequencies.get(0).getWord());
        assertEquals(2, wordFrequencies.get(0).getFrequency());
        assertEquals("lake", wordFrequencies.get(1).getWord());
        assertEquals(1, wordFrequencies.get(1).getFrequency());
        assertEquals("over", wordFrequencies.get(2).getWord());
        assertEquals(1, wordFrequencies.get(2).getFrequency());
    }

    @Test
    public void testCalculateMostFrequentNWordsWithNGreaterThanAvailableWords() {
    	// Test that less n words are returned even if more are asked.
        String text = "The sun shines over the lake";
        List<WordFrequency> wordFrequencies = wordAnalyzer.calculateMostFrequentNWords(text, 10);
        assertEquals(5, wordFrequencies.size());
    }

}
