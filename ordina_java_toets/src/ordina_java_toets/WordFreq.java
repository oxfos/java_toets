package ordina_java_toets;


import interfaces.WordFrequency;

/**
 * Class to represent a WordFrequency.
 * A word is saved with its string representation and frequency in a text.
 * @author Rinaldo Bertossa
 */
public class WordFreq implements WordFrequency {
	
	private String word;
	private Integer frequency;
	


  /**
   * Creates a WordFreq with an input word and 0 frequency.
   * @param word
   *          the word as a string
   */
	public WordFreq(String word) {
		this.word = word;
		this.frequency = 0;
	}


  /**
   * Creates a WordFreq with an input word and frequency.
   * @param word
   *          the word as a string
   * @param frequency
   *          the frequency of this word
   */
	public WordFreq(String word, Integer frequency) {
		this.word = word;
		this.frequency = frequency;
	}


  /**
   * Returns the word.
   * @return word
   */
	public String getWord() {
		return word;
	}

  /**
   * Returns the frequency of this word.
   * @return frequency
   */
	public int getFrequency() {
		return frequency;
	}

  /**
   * Returns this word as string representation.
   * @return this word as string representation
   */
	@Override
	public String toString() {
	    return "(\"" + word + "\", " + frequency + ")";
	}

}
