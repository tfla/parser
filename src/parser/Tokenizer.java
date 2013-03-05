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
	 * Metod för att konstatera att en specifik Token lästs.
	 *
	 * @throws RuntimeExeception om inte nuvarade Token är samma som inparametern ch.
	 * @param ch
	 *			- tecknet för vilket ett fel inte skall kastas.
	 */
	public void accept(char ch) {
		if (ttype == ch) {
			next();
		} else {
			throw new RuntimeException("ERROR: Expected: " + ch + " found: " + found());
		}
	}

	/** 
	 * Metod för att konstatera att en specifik Token lästs.
	 *
	 * @throws RuntimeException om inte nuvarande Token är samma som inparametern s.
	 * @param s
	 *			- strängen för vilken ett fel inte skall kastas.
	 */
	public void accept(String s) {
		if (found().equals(s)) {
			next();
		} else {
			throw new RuntimeException("ERROR: Expected: " + s + " found: " + found());
		}
	}

	/**
	 * Returnerar en sträng som representerar den senaste lästa Token.
	 *
	 * @return senaste lästa Token
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
	 * Returnerar true om nuvarande Token är END_OF_FILE.
	 *
	 * @return true om nuvarande Token är END_OF_FILE.
	 */
	public boolean atEOF() {
		return ttype == TT_EOF;
	}
}
