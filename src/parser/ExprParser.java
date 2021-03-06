package parser;

public class ExprParser {
	private Tokenizer theTokenizer; // anv�nds f�r att h�mta token fr�n input

	/**
	 * Konstruktor. Skapar en uttrycksparser knuten till en Tokenizer t.
	 * 
	 * @param t
	 *            - tokenizer-objekt knuten till indatan.
	 */
	public ExprParser(Tokenizer t) {
		theTokenizer = t;
	}

	/**
	 * Returnerar ett uttryck som representerar det uttryckstr�d som parsras.
	 * 
	 * @return ett uttryck som motsvarar hela uttryckstr�det.
	 */
	public Expr build() {
		return expr();
	}

	/**
	 * Metod som motsvarar startproduktionen.
	 * 
	 * @return uttrycket som parsats.
	 */
	private Expr expr() {
		Expr res, nextTerm;
		res = term();
		while (theTokenizer.ttype == '+' || theTokenizer.ttype == '-') {
			char op = (char) theTokenizer.ttype;
			theTokenizer.next();
			nextTerm = term();
			if (op == '+') {
				res = new Add(res, nextTerm);
			} else {
				res = new Sub(res, nextTerm);
			}
		}
		return res;
	}

	/**
	 * Metod motsvarande term-produktionen.
	 * 
	 * @return uttrycket (motsvarande en term) som parsats.
	 */
	private Expr term() {
		Expr res, nextFactor;
		res = factor();
		while (theTokenizer.ttype == '*' || theTokenizer.ttype == '/') {
			char op = (char) theTokenizer.ttype;
			theTokenizer.next();
			nextFactor = factor();
			if (op == '*') {
				res = new Mult(res, nextFactor);
			} else {
				res = new Div(res, nextFactor);
			}
		}
		return res;
	}

	/**
	 * Metod motsvarande factor-produktionen.
	 * 
	 * @return uttrycket (motsvarande an factor) som parsats.
	 */
	private Expr factor() {
		if (theTokenizer.ttype == '(') {
			theTokenizer.next();
			Expr exp = expr();
			theTokenizer.accept(')');
			return exp;
		} else if (theTokenizer.ttype == Tokenizer.TT_NUMBER) {
			int x = (int) theTokenizer.nval;
			theTokenizer.next();
			return new Num(x);
		} else if (theTokenizer.ttype == Tokenizer.TT_WORD
				&& (theTokenizer.sval.matches("\\w*?"))) {
			Var var = new Var(theTokenizer.sval);
			theTokenizer.next();
			return var;
		} else {
			throw new RuntimeException("\nExprParser.factor: found:  "
					+ theTokenizer.found());
		}
	}
}
