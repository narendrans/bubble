package bubble.parser;

import Converter.ConvertToHtml;
import com.aliasi.util.Files;
import java.io.IOException;
import org.pdfbox.cos.COSDocument;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDDocumentInformation;
import java.io.File;
import org.pdfbox.util.PDFTextStripper;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class PreProcessor {

	public String preProcess(String filename, int mode) {

		switch (mode) {
		case 0:
			try {
				String str = Files.readFromFile(new File(filename));
				return str;
			} catch (IOException ex) {
				System.err.println(ex);
			}
			break;
		case 1:
			PDFTextParser myparser = new PDFTextParser();
			return myparser.pdftoText(filename);
		}
		return "";
	}

	public static String HTMLtotxt(String url) {
		return ConvertToHtml.toHtml(url);
	}

	public static String[] XMLtotxt(String xmlpath) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File(xmlpath));
		doc.getDocumentElement().normalize();
		NodeList listSummarizer = doc.getElementsByTagName("summarizer");
		Node node = listSummarizer.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element summarizerElement = (Element) node;
			NodeList summarizerNode = summarizerElement
					.getElementsByTagName("input_text");
			Element inputText = (Element) summarizerNode.item(0);
			NodeList text = inputText.getChildNodes();
			xmlText = ((Node) text.item(0)).getNodeValue().trim();
			NodeList percentage = summarizerElement
					.getElementsByTagName("percentage");
			Element percentageElement = (Element) percentage.item(0);
			NodeList percent = percentageElement.getChildNodes();
			xmlPercent = ((Node) percent.item(0)).getNodeValue().trim();
			NodeList keywords = summarizerElement
					.getElementsByTagName("keywords");
			Element keywordsElement = (Element) keywords.item(0);
			NodeList textkeywords = keywordsElement.getChildNodes();
			xmlKeywords = ((Node) textkeywords.item(0)).getNodeValue().trim();
			NodeList thesaurus = summarizerElement
					.getElementsByTagName("thesaurus");
			Element thesa = (Element) thesaurus.item(0);
			NodeList thesaurusList = thesa.getChildNodes();
			xmlThesaurus = ((Node) thesaurusList.item(0)).getNodeValue().trim();
			NodeList language = summarizerElement
					.getElementsByTagName("language");
			Element lang = (Element) language.item(0);
			NodeList langlist = lang.getChildNodes();
			xmlLang = ((Node) langlist.item(0)).getNodeValue().trim();
		}
		String[] ret = new String[5];
		ret[0] = xmlText;
		ret[1] = xmlPercent;
		ret[2] = xmlKeywords;
		ret[3] = xmlThesaurus;
		ret[4] = xmlLang;
		return ret;

	}

	public class PDFTextParser {

		PDFParser parser;
		String parsedText;
		PDFTextStripper pdfStripper;
		PDDocument pdDoc;
		COSDocument cosDoc;
		PDDocumentInformation pdDocInfo;


		String pdftoText(String fileName) {

			File f = new File(fileName);

			if (!f.isFile()) {
				return null;
			}

			try {
				parser = new PDFParser(new FileInputStream(f));
			} catch (Exception e) {
				return null;
			}

			try {
				parser.parse();
				cosDoc = parser.getDocument();
				pdfStripper = new PDFTextStripper();
				pdDoc = new PDDocument(cosDoc);
				parsedText = pdfStripper.getText(pdDoc);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					if (cosDoc != null) {
						cosDoc.close();
					}
					if (pdDoc != null) {
						pdDoc.close();
					}
				} catch (Exception e1) {
					e.printStackTrace();
				}
				return null;
			}
			return parsedText;
		}
	}

	private static String xmlKeywords, xmlText, xmlLang, xmlPercent,
			xmlThesaurus;
}
