package bubble.parser;

import java.util.ResourceBundle;
import java.util.Vector;

public class Stemmer {

	public Stemmer() {
		this.ruleTable = new Vector<String>();
		this.ruleIndex = new int[26];
		this.preStrip = false;
		this.preStrip = true;
		ReadRules();
	}

	private void ReadRules() {
		int ruleCount = 0;
		int j = 0;
		try {
			ResourceBundle res = ResourceBundle
					.getBundle("bubble.resources.stemrules");
			String line = " ";
			for (int i = 1; i <= 116; i++) {
				line = res.getString("" + i + ".");
				++ruleCount;
				j = 0;
				String rule = new String();
				rule = "";
				while ((j < line.length()) && (line.charAt(j) != ' ')) {
					rule = rule + line.charAt(j);
					++j;
				}
				this.ruleTable.addElement(rule);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		char ch = 'a';
		for (j = 0; j < 26; ++j) {
			this.ruleIndex[j] = 0;
		}

		for (j = 0; j < ruleCount - 1; ++j) {
			while (((String) this.ruleTable.elementAt(j)).charAt(0) != ch) {
				ch = (char) (ch + '\1');
				this.ruleIndex[charCode(ch)] = j;
			}
		}
	}

	private int FirstVowel(String word, int last) {
		int i = 0;
		if ((i < last) && (!(vowel(word.charAt(i), 'a')))) {
			++i;
		}
		while ((i != 0) && (i < last)
				&& (!(vowel(word.charAt(i), word.charAt(i - 1))))) {
			++i;
		}

		if (i < last) {
			return i;
		}
		return last;
	}

	private String stripSuffixes(String word) {
		int prt;
		char ll;
		int ruleok = 0;
		int Continue = 0;

		int pll = 0;

		String rule = "";
		String stem = "";

		boolean intact = true;

		stem = Clean(word.toLowerCase());

		pll = 0;

		while ((pll + 1 < stem.length()) && (stem.charAt(pll + 1) >= 'a')
				&& (stem.charAt(pll + 1) <= 'z')) {
			++pll;
		}

		if (pll < 1) {
			Continue = -1;
		}

		int pfv = FirstVowel(stem, pll);

		int iw = stem.length() - 1;
		do {
			if (Continue == -1) {
				return stem;
			}
			Continue = 0;
			ll = stem.charAt(pll);

			if ((ll >= 'a') && (ll <= 'z')) {
				prt = this.ruleIndex[charCode(ll)];
			} else {
				prt = -1;
			}
			if (prt == -1) {
				Continue = -1;
			}
		} while (Continue != 0);

		rule = (String) this.ruleTable.elementAt(prt);
		while (true) {
			if (Continue == 0)
				;
			ruleok = 0;
			if (rule.charAt(0) != ll) {
				Continue = -1;
				ruleok = -1;
			}
			int ir = 1;
			iw = pll - 1;

			while (ruleok == 0) {
				if ((rule.charAt(ir) >= '0') && (rule.charAt(ir) <= '9')) {
					ruleok = 1;
				}
				if (rule.charAt(ir) == '*') {
					if (intact) {
						ir += 1;
						ruleok = 1;
					}
					ruleok = -1;
				}
				if (rule.charAt(ir) != stem.charAt(iw)) {
					ruleok = -1;
				}
				if (iw <= pfv) {
					ruleok = -1;
				}

				ir += 1;
				iw -= 1;
			}

			if (ruleok == 1) {
				int xl = 0;
				while ((rule.charAt(ir + xl + 1) < '.')
						|| (rule.charAt(ir + xl + 1) > '>')) {
					++xl;
				}
				xl = pll + xl + 48 - rule.charAt(ir);

				if (pfv == 0) {
					if (xl < 1) {
						ruleok = -1;
					}

				} else if ((((xl < 2) ? 1 : 0) | ((xl < pfv) ? 1 : 0)) != 0) {
					ruleok = -1;
				}

			}

			if (ruleok == 1) {
				intact = false;

				pll = pll + 48 - rule.charAt(ir);
				++ir;
				stem = stem.substring(0, pll + 1);

				while ((ir < rule.length()) && ('a' <= rule.charAt(ir))
						&& (rule.charAt(ir) <= 'z')) {
					stem = stem + rule.charAt(ir);
					++ir;
					++pll;
				}

				if (rule.charAt(ir) == '.') {
					Continue = -1;
				}

				Continue = 1;
			}

			prt += 1;
			try {
				rule = (String) this.ruleTable.elementAt(prt);
			} catch (Exception ex) {
				return stem;
			}
			if (rule.charAt(0) == ll) {
				continue;
			}
			Continue = -1;
		}
	}

	private boolean vowel(char ch, char prev) {
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		case 'y':
			switch (prev) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return false;
			}
			return true;
		}

		return false;
	}

	private int charCode(char ch) {
		return (ch - 'a');
	}

	private String stripPrefixes(String str) {
		String[] prefixes = { "kilo", "micro", "milli", "intra", "ultra",
				"mega", "nano", "pico", "pseudo" };

		int last = prefixes.length;

		for (int i = 0; i < last; ++i) {
			if ((str.startsWith(prefixes[i]))
					&& (str.length() > prefixes[i].length())) {
				str = str.substring(prefixes[i].length());
				return str;
			}
		}
		return str;
	}

	public String stem(String str) {
		if ((str.length() > 3) && (this.preStrip)) {
			str = stripPrefixes(str);
		}
		if (str.length() > 3) {
			str = stripSuffixes(str);
		}
		return str;
	}

	private String Clean(String str) {
		int last = str.length();
		String temp = "";
		for (int i = 0; i < last; ++i) {
			if ((((str.charAt(i) >= 'a') ? 1 : 0) & ((str.charAt(i) <= 'z') ? 1
					: 0)) != 0) {
				temp = temp + str.charAt(i);
			}
		}
		return temp;

	}

	private Vector<String> ruleTable;
	private int[] ruleIndex;
	private boolean preStrip;
}
