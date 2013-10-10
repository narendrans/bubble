package bubble.summarizer;

import Jama.Matrix;
import Jama.SingularValueDecomposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import bubble.parser.Parser;

public class BubbleSummarizer {

    public int[] Summarize(Parser documentParser, int k) {

        List<String> sentences = documentParser.getSentences();
        List<Map<String, Double>> sparseSentences = documentParser.getSparseSentences();
        Map<String, Double> dictionary = documentParser.getDictionary();
        if ((k > documentParser.getNumUsefulSentences()) || (k <= 0)) {
            return null;
        }
        return getSummary(sentences, sparseSentences, dictionary, k);
    }

    private int[] getSummary(List<String> sentences,
            List<Map<String, Double>> sparseSentences,
            Map<String, Double> dictionary, int k) {
        Set<Integer> usefulSentencesID = new HashSet<Integer>();

        int numUselessSentences = 0;
        for (int i = 0; i < sparseSentences.size(); ++i) {
            if (((Map<?, ?>) sparseSentences.get(i)).size() == 0) {
                ++numUselessSentences;
            } else {
                usefulSentencesID.add(Integer.valueOf(i));
            }
        }
        int numMatrixRows = sparseSentences.size();// sparseSentences.size() - numUselessSentences;

        int numMatrixColumns = dictionary.size();
        Matrix denseDocument = new Matrix(numMatrixRows, numMatrixColumns);

        int rowIndex = 0;
        Object[] dictionaryWords = dictionary.keySet().toArray();

        for (int i = 0; i < sparseSentences.size(); ++i) {
            Map<?, ?> singleSentence = (Map<?, ?>) sparseSentences.get(i);
            if (singleSentence.size() != 0) {
                int j = 0;
                for (String key : dictionary.keySet()) {
                    if (singleSentence.containsKey(key)) {
                        denseDocument.set(rowIndex, j++,
                                ((Double) singleSentence.get(key)).doubleValue());
                    } else {
                        denseDocument.set(rowIndex, j++, 0.0D);
                    }
                }
                ++rowIndex;
            }

        }

        SingularValueDecomposition svd = denseDocument.svd();

        Matrix rightSingularVectors = svd.getV().transpose();

        List<Map<String, Double>> topkRightSingularVectors = new ArrayList<Map<String, Double>>();

        for (int i = 0; i < k; ++i) {
            Map<String, Double> tmpmap = new HashMap<String, Double>();
            for (int j = 0; j < numMatrixColumns; ++j) {
                if (rightSingularVectors.get(i, j) == 0.0D) {
                    continue;
                }
                tmpmap.put(dictionaryWords[j].toString(), Double.valueOf(rightSingularVectors.get(i, j)));
            }
            topkRightSingularVectors.add(tmpmap);
        }

        int[] resultsID = new int[k];
        for (int i = 0; i < k; ++i) {
            Map<String, Double> reference = (Map<String, Double>) topkRightSingularVectors.get(i);

            resultsID[i] = mostSimilarSentence(usefulSentencesID,
                    sparseSentences, reference);
            usefulSentencesID.remove(Integer.valueOf(resultsID[i]));
        }

        Arrays.sort(resultsID);

        return resultsID;
    }

    private int mostSimilarSentence(
            Set<Integer> usefulSentenceID,
            List<Map<String, Double>> sparseSentences,
            Map<String, Double> reference) {

        double dist = (-1.0D / 0.0D);
        Integer MostSimilarSentenceID = null;

        for (Integer id : usefulSentenceID) {
            double ndist = Similarity((Map<String, Double>) sparseSentences.get(id.intValue()), reference);
            if (dist < ndist) {
                dist = ndist;
                MostSimilarSentenceID = id;
            }
        }
        return MostSimilarSentenceID.intValue();
    }

    private double Similarity(Map<String, Double> m1, Map<String, Double> m2) {

        if ((m1.size() == 0) || (m2.size() == 0)) {
            return 0;
        }

        double numerator = 0, denom1 = 0, denom2 = 0, denominator;

        if (m1.size() < m2.size()) {
            for (Entry<String, Double> e : m1.entrySet()) {
                String str = e.getKey();
                if (m2.containsKey(str)) {
                    numerator += ((Double) m1.get(str)).doubleValue() * ((Double) m2.get(str)).doubleValue();
                }
                denom1 += Math.pow(e.getValue(), 2);
            }
            if ((numerator == 0) || (denom1 == 0)) {
                return 0;
            }
            for (Double d : m2.values()) {
                denom2 += Math.pow(d, 2);
            }
            if (denom2 == 0) {
                return 0;
            }
        } else {
            for (Entry<String, Double> e : m2.entrySet()) {
                String str = e.getKey();
                if (m1.containsKey(str)) {
                    numerator += ((Double) m1.get(str)).doubleValue() * ((Double) m2.get(str)).doubleValue();
                }
                denom2 += Math.pow(e.getValue(), 2);
            }
            if ((numerator == 0) || (denom2 == 0)) {
                return 0;
            }
            for (Double d : m1.values()) {
                denom1 += Math.pow(d, 2);
            }
            if (denom1 == 0) {
                return 0;
            }
        }
        denominator = Math.sqrt(denom1) * Math.sqrt(denom2);
        return numerator / denominator;
    }
}
