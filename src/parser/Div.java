package parser;

public class Div extends Expr {
	private Expr expr1, expr2;
	
	Div(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	public int value() {
		return expr1.value() / expr2.value();
	}
}
