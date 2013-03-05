package parser;

import java.io.*;

public class Tokenizer extends StreamTokenizer {
	/**
	 * Skapar ett tokenizerobjekt.
	 * @param input - fill�saren.
	 */
	public Tokenizer(Reader input) {
		super(input);
		ordinaryChar('-');
		ordinaryChar('/');
	}

	/**  
	 * 
	 * @return Typen p� den l�st Token.
	 */
	public int next() {
		try {
			return nextToken();
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}
	
	/**
	 * Metod f�r att konstatera att en specifik Token l�sts.
	 *
	 * @throws RuntimeExeception om inte nuvarade Token �r samma som inparametern ch.
	 * @param ch
	 *			- tecknet f�r vilket ett fel inte skall kastas.
	 */
	public void accept(char ch) {
		if (ttype == ch) {
			next();
		} else {
			throw new RuntimeException("ERROR: Expected: " + ch + " found: " + found());
		}
	}

	/** 
	 * Metod f�r att konstatera att en specifik Token l�sts.
	 *
	 * @throws RuntimeException om inte nuvarande Token �r samma som inparametern s.
	 * @param s
	 *			- str�ngen f�r vilken ett fel inte skall kastas.
	 */
	public void accept(String s) {
		if (found().equals(s)) {
			next();
		} else {
			throw new RuntimeException("ERROR: Expected: " + s + " found: " + found());
		}
	}

	/**
	 * Returnerar en str�ng som representerar den senaste l�sta Token.
	 *
	 * @return senaste l�sta Token
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
	 * Returnerar true om nuvarande Token �r END_OF_FILE.
	 *
	 * @return true om nuvarande Token �r END_OF_FILE.
	 */
	public boolean atEOF() {
		return ttype == TT_EOF;
	}
}
