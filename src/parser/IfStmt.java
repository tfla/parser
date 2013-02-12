package parser;

public class IfStmt extends Stmt {
	private Expr exp;
	private Tokenizer theTokenizer;

	IfStmt(Expr exp, Tokenizer theTokenizer) {
		this.exp = exp;
		this.theTokenizer = theTokenizer;
	}

	public void eval() {
		if (exp.value() == 0){
			while(!theTokenizer.sval.equals("endif") && !theTokenizer.sval.equals("else") ){
			theTokenizer.next();
			}
		}else {
			theTokenizer.next();
		}
	}
} 