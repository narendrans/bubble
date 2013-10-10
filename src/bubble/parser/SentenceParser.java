package bubble.parser;

import com.aliasi.sentences.IndoEuropeanSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;
import java.util.ArrayList;
import java.util.List;

public class SentenceParser {

	public SentenceParser(String document) {
		detectSentences(document);
	}

	private void detectSentences(String document) {
		TokenizerFactory TOKENIZER_FACTORY = new IndoEuropeanTokenizerFactory();
		SentenceModel SENTENCE_MODEL = new IndoEuropeanSentenceModel();

		ArrayList tokenList = new ArrayList();
		ArrayList whiteList = new ArrayList();
		Tokenizer tokenizer = TOKENIZER_FACTORY.tokenizer(document
				.toCharArray(), 0, document.length());
		tokenizer.tokenize(tokenList, whiteList);

		String[] tokens = new String[tokenList.size()];
		String[] whites = new String[whiteList.size()];
		tokenList.toArray(tokens);
		whiteList.toArray(whites);
		int[] sentenceBoundaries = SENTENCE_MODEL.boundaryIndices(tokens,
				whites);

		this.numSentences = sentenceBoundaries.length;

		int sentStartTok = 0;
		int sentEndTok = 0;
		for (int i = 0; i < sentenceBoundaries.length; ++i) {
			sentEndTok = sentenceBoundaries[i];
			StringBuffer strbuf = new StringBuffer();
			for (int j = sentStartTok; j <= sentEndTok; ++j) {
				strbuf.append(tokens[j] + whites[(j + 1)]);
			}

			this.sentences.add(strbuf.toString().replace('\n', ' ').trim());
			sentStartTok = sentEndTok + 1;
		}
	}

	public List<String> getSentences() {
		return this.sentences;
	}

	public int getNumSentences() {
		return this.numSentences;
	}

	private int numSentences = 0;
	private List<String> sentences = new ArrayList();

}