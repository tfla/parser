package parser;

import java.util.LinkedList;

public class IfStmt extends Stmt {
	private Expr exp;
	private Tokenizer theTokenizer;
	private StmtParser sparser;
	private LinkedList<String> list;
	private LinkedList<Stmt> slist;

	IfStmt(Expr exp, Tokenizer theTokenizer, StmtParser sparser) {
		this.exp = exp;
		this.theTokenizer = theTokenizer;
		list = new LinkedList<String>();
		this.sparser = sparser;
		slist = new LinkedList<Stmt>();
	}

	public void eval() {
		if (exp.value() == 0) {
			while (!theTokenizer.sval.equals("endif")
					&& !theTokenizer.sval.equals("else")) {
				theTokenizer.next();
			}
			if (theTokenizer.sval.equals("endif")) {
				list.add("endif");
			} else {
				list.add("else");
				theTokenizer.next();
				while (!theTokenizer.sval.equals("endif")){
					slist.add(sparser.ifparse());
				}
				
			}
		} else {
			theTokenizer.next();
		}
	}

	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("if " + exp.unparse() + " then");
		while (list.size() > 0) {
			sb.append('\n');
			String s = list.remove();
			if (s.equals("else")) {
				theTokenizer.next();
				sb.append(s);
				while (slist.size() != 0){
				sb.append("\n" + slist.remove().unparse());
				}
			} else {
				sb.append(s);
			}
		}
		return sb.toString();
	}
}