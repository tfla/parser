package parser;

public class Sub extends Expr {
	private Expr expr1, expr2;

	Sub(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	public int value() {
		return expr1.value() - expr2.value();
	}

	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		return expr1.unparse() + "-" + expr2.unparse();
	}
}
