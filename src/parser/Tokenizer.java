package parser;

import java.io.*;

public class Tokenizer extends StreamTokenizer {
	/**
	 * Skapar ett tokenizerobjekt.
	 * @param input - filläsaren.
	 */
	public Tokenizer(Reader input) {
		super(input);
		ordinaryChar('-');
		ordinaryChar('/');
	}

/**  
 * 
 * @return Typen på den läst Token.
 */
	public int next() {
		try {
			return nextToken();
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}
	
	/**
	 * @throws RuntimeExeception Om inte nuvarade Token är samma som inparametern.
	 * @param ch
	 */
	public void accept(char ch) {
		if (ttype == ch) {
			next();
		} else {
			throw new RuntimeException("Expected: " + ch + " found: " + found());
		}
	}

/** Metod för att konstatera att en specifik token lästs.
 * @param s
 */
	public void accept(String s) {
		if (found().equals(s)) {
			next();
		} else {
			throw new RuntimeException("Expected: " + s + " found: " + found());
		}
	}
/**
 * 
 * @return Senaste lästa Token
 */
	public String found() {
		switch (ttype) {
		case TT_WORD:
			return sval;
		case TT_NUMBER:
			return Double.toString(nval);
		case TT_EOL:
			return "end-of-line";
		case TT_EOF:
			return "end-of-file";
		default:
			return (new Character((char) ttype)).toString();
		}
	}
/**
 * 
 * @return
 */
	public boolean atEOF() {
		return ttype == TT_EOF;
	}
}
