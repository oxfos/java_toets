package interfaces;

import java.util.List;

public interface WordFrequencyAnalyzer {
	public int calculateHighestFrequency(String text);
	public int calculateFrequencyForWord (String text, String word);
	public List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}
