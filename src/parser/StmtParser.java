package parser;

public class StmtParser {
	private Tokenizer t;
	private ExprParser parser;
	private StatementSeq st;

	/**
	 * Skapar en parser för programmets satser.
	 * 
	 * @param t
	 *            - tokenizer-objekt knuten till indatan.
	 */
	public StmtParser(Tokenizer t) {
		this.t = t;
		this.parser = new ExprParser(t);
		st = new StatementSeq();
	}

	/**
	 * Parsar programmets satser.
	 * 
	 * @return satsföljden som representerar programmet.
	 */
	public StatementSeq Build() {
		StatementAdd(st);
		while (t.atEOF() == false) {
			t.accept(';');
			StatementAdd(st);
		}

		return st;
	}

	/**
	 * Exekverar programmet.
	 */
	public void exec() {
		st.exec(new Table());
	}

	/**
	 * Hjälpmetod för att lägga in satser i satsföljden seq.
	 * 
	 * @param seq
	 *            - den satsföljd där satserna skall lagras.
	 */
	private void StatementAdd(StatementSeq seq) {
		Stmt s = Statement();
		if (s != null) {
			seq.add(s);
		} else {
			throw new RuntimeException(t.found()
					+ " ERROR: Not a statement (at line: " + t.lineno() + ").");
		}
	}

	/**
	 * Parsar en sats.
	 * 
	 * @return den parsade satsen.
	 */
	private Stmt Statement() {
		if (t.ttype == Tokenizer.TT_WORD) {
			if (t.sval.equals("output")) {
				t.next();
				OutputStmt ostmt = new OutputStmt(parser.build());
				return ostmt;
			} else if (t.sval.equals("if")) {
				t.next();
				return ifStatement(parser.build());
			} else {
				Expr Expr1 = parser.build();
				t.accept('=');
				AssignStmt astmt = new AssignStmt(Expr1, parser.build());
				return astmt;
			}

		}

		throw new RuntimeException(t.found()
				+ " ERROR: Not a statement (at line: " + t.lineno() + ").");
	}

	/**
	 * Parsar en ifsats enligt språkets regler.
	 * 
	 * @param exp
	 *            - if-satsens villkor.
	 * @return den resulterande if-satsen.
	 */
	private IfStmt ifStatement(Expr exp) {
		t.accept("then");
		StatementSeq list = new StatementSeq();
		StatementSeq slist = new StatementSeq();
		if (!t.found().equals("else")) {
			StatementAdd(list);
		}
		while (!t.found().equals("else") && !t.found().equals("endif")) {
			t.accept(';');
			StatementAdd(list);
		}
		if (t.found().equals("else")) {
			t.accept("else");
			StatementAdd(slist);
		}
		while (!t.found().equals("endif")) {
			t.accept(';');
			StatementAdd(slist);
		}
		t.next();
		return new IfStmt(exp, list, slist);
	}
}