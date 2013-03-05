package parser;

public class AssignStmt extends Stmt {
	private Expr var;
	private Expr exp;

	/**
	 * Skapar en tilldelningssats.
	 * 
	 * @param var
	 *            - variabeln som skall tilldelas ett v�rde.
	 * @param exp
	 *            - v�rdet som variabeln skall tilldelas.
	 */
	AssignStmt(Expr var, Expr exp) {
		this.var = var;
		this.exp = exp;
	}

	/**
	 * Returnerar en str�ng som illustrerar uttrycket
	 * 
	 * @param level
	 *            - indenteringsniv�n som skall anv�ndas, ifall
	 *            tilldelningssatsen utf�rs inuti en if-sats.
	 * @return en str�ng som illustrerar uttrycket.
	 */
	@Override
	public String unparse(int level) {
		return var.unparse(0) + " = " + exp.unparse(0);
	}

	/**
	 * Exekverar tilldelningssatsen.
	 * 
	 * @param table
	 *            - listan med alla uttryck.
	 */
	@Override
	public void exec(Table table) {
		table.add(var.unparse(0), exp.value(table));

	}
}
