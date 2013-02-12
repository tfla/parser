package parser;

public class Mult extends Expr{
	private Expr expr1, expr2;

	Mult(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	public int value() {
		return expr1.value() * expr2.value();
	}
}