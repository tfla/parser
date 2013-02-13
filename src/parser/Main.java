package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) {
		Reader reader = null;
		if (args.length == 0) {
			System.out.println("Use: java filename");
			System.exit(-1);
		}
		try {
			reader = new FileReader(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		Tokenizer theTokenizer = new Tokenizer(reader);
		ExprParser parser = new ExprParser(theTokenizer);
		StmtParser sparser = new StmtParser(theTokenizer, parser);
		varList.VarIn();
		theTokenizer.next();
		while (theTokenizer.atEOF() == false) {
			sparser.Start();
		}
		sparser.Outprint();
	}
}
