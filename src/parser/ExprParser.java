package parser;

public class ExprParser {
	private Tokenizer theTokenizer; // används för att hämta token från input

	/** Konstruktor. Skapar en uttrycksparser knuten till en Tokenizer t */
	public ExprParser(Tokenizer t) {
		theTokenizer = t;
	}

	/** Returnerar ett uttrycksträd som representerar det uttryck som parsras */
	public Expr build() {
		return expr();
	}

	/* Metod som motsvarar startproduktionen */
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

	/* Metod motsvarande term-produktionen */
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

	private Expr var() {
		String n = theTokenizer.sval;
		theTokenizer.next();
		int i = 0;
		Var res;
		if (theTokenizer.ttype == '=') {
			theTokenizer.next();
			theTokenizer.next();
			i = (int) theTokenizer.nval;
			res = varList.new_nbr(n, i);
			if (theTokenizer.ttype == ';') {
				theTokenizer.next();
				//res = new Var("",0);
			}

		} else if (theTokenizer.ttype != '=') {
			;
			res = varList.getNum(n);
		} else {
			throw new RuntimeException("\nExprParser.TT_NUMBER: found:  "
					+ theTokenizer.found());
		}
		return res;
	}



	/* Metod motsvarande factor-produktionen. */
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
		} else if (theTokenizer.ttype == Tokenizer.TT_WORD) {

			Var varb = (Var) var();
			return varb;
			// throw new RuntimeException("\nExprParser.VAR: found:  " +
			// theTokenizer.found());
		} else {
			throw new RuntimeException("\nExprParser.factor: found:  "
					+ theTokenizer.found());
		}
	}
}
