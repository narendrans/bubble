package bubble.summarizer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.aliasi.util.Files;

import bubble.parser.Parser;

public class Wrapper {

	public static String content;
	public static String[] sentences;
	public static Parser myParser;
	public static int[] sentenceIndex;

	public static int[] getSentenceIndex() {
		return sentenceIndex;
	}

	public static String getContent() {
		return content;
	}

	public static Parser getParser() {
		return myParser;
	}

	public static String[] getSentences() {
		return sentences;
	}

	public static void main(String[] args) {
		String Kword = "";
		if (args.length > 2) {
			Kword = args[2];
		}

		String input;
		if (args.length > 3) {
			input = args[3];
			if (input.equals("")) {
				return;
			}
		} else {
			try {
				input = Files.readFromFile(new File(args[0]));
			} catch (IOException ex) {
				System.err.println(ex);
				content = "";
				return;
			}
		}

		myParser = new Parser(input, Kword.toLowerCase(), args.length == 5);

		int percent = Integer.parseInt(args[1]); // Argument 2 -> Percent to

		StringBuilder summary = new StringBuilder();

		BubbleSummarizer mySummariser = new BubbleSummarizer();

		int numberofsentences = Math.round(myParser.getNumUsefulSentences()
				* percent / 100.0F);

		if (numberofsentences < 1) {
			numberofsentences = 1;
		}
		sentenceIndex = mySummariser.Summarize(myParser, numberofsentences);
		if (sentenceIndex!=null) {
			sentences = new String[sentenceIndex.length];
			List mysentences = myParser.getSentences();
			for (int i = 0; i < sentenceIndex.length; i++) {
				summary.append(mysentences.get(sentenceIndex[i]).toString()
						+ " ");
				sentences[i] = mysentences.get(sentenceIndex[i]).toString();
			}
			content = summary.toString();
		} else {
			content = input;
		}

	}
}
