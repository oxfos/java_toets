package ordina_java_toets;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import interfaces.WordFrequency;
import interfaces.WordFrequencyAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class to analyze word frequencies in an input text.
 * @author Rinaldo Bertossa
 */
public class WordAnalyzer implements WordFrequencyAnalyzer {
	
	private HashMap<String, Integer> frequencyMap = new HashMap<>();
	private List<Map.Entry<String, Integer>> frequencyList;
	

  /**
   * Creates and stores a HashMap containing the text strings as keys 
   * and their frequency in the input text as values.
   * @param text
   *          the text to be analyzed
   */
	private void createFrequencyMap(String text) {
		
		try(Scanner textScanner = new Scanner(text).useDelimiter("[^a-zA-Z]+")){
			while(textScanner.hasNext()) {
				String nextString = textScanner.next().toLowerCase();
				Integer freq = frequencyMap.get(nextString);
				if(freq == null) {
					freq = 0;
				}
				frequencyMap.put(nextString, ++freq);
			}
		}
	}
	
	/**
	 * Sorts the HashMap frequencyMap according to:
	 * 1. values
	 * 2. if two entries have the same value: ascending alphabetical order
	 * Stores the sorted map entries in the list frequencyList.
	 * @param frequencyMap
	 *            the frequencyMap containing the entries to be sorted
	 */
	private void sortFrequencyMap(HashMap<String, Integer> frequencyMap) {
        frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
    }
	
	/**
	 * Calculates the highest word frequency in the input text.
	 * @param text
	 *         the input text to be analyzed 
	 * @return
	 *          the highest frequency found in the input text
	 */
	public int calculateHighestFrequency(String text) {
		
		createFrequencyMap(text);		
		sortFrequencyMap(frequencyMap);
		frequencyMap.clear();
		if (frequencyList.isEmpty()) {
			return 0;
		}
		else {
			return frequencyList.get(0).getValue();
		}
		
	}
	
	/**
	 * Calculates the frequency of an input word in the input text.
	 * @param text
	 *          the input text to be analyzed
	 * @param word
	 *          the word whose frequency has to be returned
	 * @return found
	 *          the frequency of the input word if found,
	 *          0 otherwise.
	 */
	public int calculateFrequencyForWord (String text, String word) {
		
		createFrequencyMap(text);
		if (frequencyMap.get(word) == null) {
			frequencyMap.clear();
			return 0;
		}
		else {
			int found = frequencyMap.get(word);
			frequencyMap.clear();
			return found;
		}
		
	}
	
	/**
	 * Returns n words with the highest frequency in the input text.
	 * @param text
	 *          the input text to be analyzed
	 * @param n
	 *          the amount of words to be returned
	 * @return
	 *          a list containing n WordFrequency objects (string representation)
	 *          or an empty list depending on the input text and n.
	 */
	public List<WordFrequency> calculateMostFrequentNWords (String text, int n){
		
		createFrequencyMap(text);		
		sortFrequencyMap(frequencyMap);
		frequencyMap.clear();
		List<WordFrequency> list = new ArrayList<>();
		for (int i = 0; i < n && i < frequencyList.size(); i++) {
			Map.Entry<String, Integer> e = frequencyList.get(i);
			WordFrequency w = new WordFreq(e.getKey(), e.getValue());
            list.add(w);
        }
		return list;
	}

}
