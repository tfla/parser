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

	@Override
	public String unparse() {
		if (expr1 instanceof Sub || expr1 instanceof Add) {
			return "(" + expr1.unparse() +")/" + expr2.unparse();
		}
		else if (expr2 instanceof Sub || expr2 instanceof Add) {
			return expr1.unparse() + "/("  + expr2.unparse() + ")";
		}
		else {
			return expr1.unparse() + "/" + expr2.unparse();
		}
	}
}
