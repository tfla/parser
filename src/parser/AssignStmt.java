package parser;

public class AssignStmt extends Stmt {
	private Expr exp;

	AssignStmt(Expr exp) {
		this.exp = exp;
	}

}
