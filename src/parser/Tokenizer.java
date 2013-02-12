package parser;
import java.io.*;

public class Tokenizer extends StreamTokenizer {
	public Tokenizer(Reader input) {
		super(input);
		ordinaryChar('-');
		ordinaryChar('/');
	}

	public int next() {
		try {
			return nextToken();
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}

	public void accept(char ch) {
		if (ttype == ch) {
			next();
		} else  {
			throw new RuntimeException("Expected: " + ch + " found: " + found());
		}
	}

	public String found() {
		switch (ttype) {
		case TT_WORD:
			return sval;
		case TT_NUMBER:
			return  Double.toString(nval);
		case TT_EOL:
			return  "end-of-line";
		case TT_EOF:
			return  "end-of-file";
		default:
			return  (new Character((char) ttype)).toString();
		}
	}

	public boolean atEOF() {
		return ttype == TT_EOF;
	}
}
