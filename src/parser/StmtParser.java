package parser;

import java.util.ArrayList;

public class StmtParser {
	private Tokenizer theTokenizer; // används för att hämta token från input
	private ExprParser parser;
	private ArrayList<Stmt> st;

	public StmtParser(Tokenizer theTokenizer, ExprParser parser) {
		this.theTokenizer = theTokenizer;
		this.parser = parser;
		st = new ArrayList<Stmt>();
	}

	public ArrayList<Stmt> Start() {
		while (theTokenizer.atEOF() == false) {
			st.add(execute());
		}
	
		return st;
	}
	
	public void Outprint(){
		while (st.size()>0){
			System.out.println(st.remove(0).unparse());
		}
	}

	public Stmt ifparse(){
		return execute();
	}
	
	private Stmt execute() {

		if (theTokenizer.ttype == Tokenizer.TT_WORD) {
			if (theTokenizer.sval.equals("output")) {
				theTokenizer.next();
				OutputStmt ostmt = new OutputStmt(parser.build());
				ostmt.print();
				return ostmt;
			} else if (theTokenizer.sval.equals("if")) {
				theTokenizer.next();
				IfStmt istmt = new IfStmt(parser.build(), theTokenizer,this);
				istmt.eval();
				return istmt;
			} else {
				AssignStmt astmt = new AssignStmt(parser.build());
				return astmt;
			}

		}

		return null;
	}
}