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
	 * Skriver ut uttrycket p� stdout.
	 */
	public void print() {
		System.out.println(exp.value(null));
	}

	/**
	 * Returnerar en str�ng som representerar output-uttrycket.
	 * 
	 * @param level
	 *            - indenteringsniv�n som skall anv�ndas.
	 * @return en str�ng som representerar output-uttrycket.
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
