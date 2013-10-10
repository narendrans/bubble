package bubble.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class Parser {

	public Parser(String content, String Kword, boolean thesaurus) {
		initComponents();
		loadStopwords();
		loadStemmer();
		this.Kword = Kword;
		this.thesaurus = thesaurus;
		System.out.print(Kword);
		this.document = content;
		detectSentences();
		parseSentence();
	}

	private void initComponents() {
		this.sentences = new ArrayList<String>();
		this.sparseSentences = new ArrayList<Map<String, Double>>();
		this.stopwords = new HashSet<String>();
		this.dictionary = new HashMap<String, Double>();
	}

	private void detectSentences() {
		SentenceParser sd = new SentenceParser(this.document);
		this.numSentences = sd.getNumSentences();
		this.sentences = sd.getSentences();
	}

	private void loadStopwords() {
		try {
			ResourceBundle res = ResourceBundle
					.getBundle("bubble.resources.stopword");
			Iterator itr = res.keySet().iterator();
			String line;
			while (itr.hasNext()) {
				line = itr.next().toString();
				if (line.length() == 0) {
					continue;
				}
				if (line.trim().length() == 0) {
					continue;
				}
				this.stopwords.add(line.trim());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void loadStemmer() {
		this.stemmer = new Stemmer();
	}

	private void parseSentence() {
		String str;
		if ((this.sentences == null) || (this.sentences.isEmpty())) {
			return;
		}

		String splitRegex = "[\\_\\(\\)\\[\\]\\-\\'\\`\\;\\|\\{\\}\\:\\,\\\"\\s]+";

		for (Iterator<String> itr = this.sentences.iterator(); itr.hasNext();) {
			str = (String) itr.next();

			str = str.trim();

			if ((str.endsWith(".")) || (str.endsWith("?"))
					|| (str.endsWith("!"))) {
				str = str.substring(0, str.length() - 1);
			}
			if (str.endsWith("...")) {
				str = str.substring(0, str.length() - 3);
			}
			String[] words = str.split(splitRegex);
			for (String word : words) {
				word = word.trim().toLowerCase();

				if ((this.stopwords.contains(word)) || (word.length() == 0)) {
					continue;
				}
				this.numTotalWords += 1;

				Double count = (Double) this.dictionary.get(word);
				this.dictionary.put(word, Double
						.valueOf((count == null) ? -1.0D
								: -count.doubleValue() - 1.0D));
			}
		}

		if (!Kword.equals("")) {
			double max = 0;
			for (Double d : dictionary.values()) {
				if (-d > max) {
					max = -d;

				}
			}
			String KW[] = Kword.split("[ ,]");
			for (int i = 0; i < KW.length; i++) {
				String word = KW[i];
				if ((this.stopwords.contains(word)) || (word.length() == 0)) {
					continue;
				}
				this.dictionary.put(word, -max * dictionary.size());
			}

			if (thesaurus) {
				try {
					int j = 0;

					String ur = ("http://words.bighugelabs.com/api/1/38164e5a552f7d231fcf7e0c48ac30ba/");
					for (int i = 0; (i < KW.length) && (j < 5); i++) {
						URL url = new URL(ur + KW[i] + "/");
						BufferedReader in = new BufferedReader(
								new InputStreamReader(url.openStream()));
						while ((str = in.readLine()) != null) {
							j++;
							this.dictionary.put(str, -max * dictionary.size());
						}
					}

				} catch (Exception ex) {
				}
			}
		}

		this.numUniqueWords = this.dictionary.size();

		for (Object element : this.sentences) {
			str = (String) element;
			if ((str.endsWith(".")) || (str.endsWith("?"))
					|| (str.endsWith("!"))) {
				str = str.substring(0, str.length() - 1);
			}
			if (str.endsWith("...")) {
				str = str.substring(0, str.length() - 3);
			}
			Map<String, Double> hm = new HashMap<String, Double>();
			String[] words = str.split(splitRegex);
			for (String word : words) {
				word = word.trim().toLowerCase();

				if ((this.stopwords.contains(word))
						|| (!(this.dictionary.containsKey(this.stemmer
								.stem(word))))) {
					continue;
				}
				Double count = (Double) hm.get(word);
				Double weit = (Double) dictionary.get(word);
				weit = (weit == null) ? 1 : weit;
				hm.put(word, Double.valueOf((count == null) ? weit : -count
						.doubleValue()
						+ weit));
			}

			this.sparseSentences.add(hm);
			if (hm.size() == 0) {
				this.numUselessSentences += 1;
			}
		}

	}

	public String getDocument() {
		return this.document;
	}

	public List<String> getSentences() {
		return this.sentences;
	}

	public List<Map<String, Double>> getSparseSentences() {
		return this.sparseSentences;
	}

	public Map<String, Double> getDictionary() {
		return this.dictionary;
	}

	public int getNumSentences() {
		return this.numSentences;
	}

	public int getNumTotalWords() {
		return this.numTotalWords;
	}

	public int getNumUniqueWords() {
		return this.numUniqueWords;
	}

	public int getNumUsefulSentences() {
		return (this.numSentences - this.numUselessSentences);
	}

	public Stemmer getPaiceStemmer() {
		return this.stemmer;
	}

	public Set<String> getStopWords() {
		return this.stopwords;
	}

	private String document, Kword;
	private boolean thesaurus;
	private List<String> sentences;
	private int numSentences, numUselessSentences, numTotalWords,
			numUniqueWords;
	private List<Map<String, Double>> sparseSentences;
	private Set<String> stopwords;
	private Map<String, Double> dictionary;
	private Stemmer stemmer;
}
