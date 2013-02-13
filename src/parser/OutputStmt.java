package parser;

public class OutputStmt extends Stmt {
	private Expr exp;

	OutputStmt(Expr exp) {
		this.exp = exp;
	}

	public void print() {
		System.out.println(exp.value());
	}

	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		return "output " + exp.unparse();
	}
}
