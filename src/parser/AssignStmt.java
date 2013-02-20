package parser;

public class AssignStmt extends Stmt {
	private Expr exp;

	AssignStmt(Expr exp) {
		this.exp = exp;
	}

	@Override
	public String unparse() {
		if (exp instanceof Var){
		Var v = (Var)exp;
		return v.GetName() + " = " + v.value();
		}
		else return "Fel";
	}
}
