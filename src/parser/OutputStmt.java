package parser;

public class OutputStmt extends Stmt {
	private Expr exp;

	/**
	 * Skapar ett output-statementobjekt.
	 * 
	 * @param exp
	 *            - uttrycket som skall skrivas ut.
	 */
	OutputStmt(Expr exp) {
		this.exp = exp;
	}

	/**
	 * Skriver ut uttrycket på stdout.
	 */
	public void print() {
		System.out.println(exp.value(null));
	}

	/**
	 * Returnerar en sträng som representerar output-uttrycket.
	 * 
	 * @param level
	 *            - indenteringsnivån som skall användas.
	 * @return en sträng som representerar output-uttrycket.
	 */
	@Override
	public String unparse(int level) {
		return "output " + exp.unparse(0);
	}

	/**
	 * Exekverar output-uttrycket.
	 * 
	 * @param table
	 *            - listan med alla uttryck.
	 */
	@Override
	public void exec(Table table) {
		System.out.println(exp.value(table));
	}
}
