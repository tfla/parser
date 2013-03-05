package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {
	/**
	 * Main-metoden. Startar parsning och eventuellt exekvering av program.
	 * 
	 * @param args
	 *            - argument till main-metoden (skall i detta fall bestå av ett
	 *            filnamn).
	 */
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
		StmtParser sparser = new StmtParser(theTokenizer);
		theTokenizer.next();
		System.out.print(sparser.Build().unparse(0));
		sparser.exec();
	}
}
