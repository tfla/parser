package parser;

public class Mult extends Expr {
	private final int prec = 3;
	private Expr expr1, expr2;

	/**
	 * Skapar ett multiplikationsobjekt.
	 * 
	 * @param e1
	 *            - f�rsta faktorn.
	 * @param e2
	 *            - andra faktorn.
	 */
	Mult(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	/**
	 * Ber�kna v�rdet av uttrycket.
	 * 
	 * @param table
	 *            - lista med variablerna.
	 * @return Heltalsv�rdet av uttrycket.
	 */
	public int value(Table table) {
		return expr1.value(table) * expr2.value(table);
	}

	/**
	 * Returnerar en str�ng som illustrerar uttrycket.
	 * 
	 * @param prec
	 *            - rotoperatorns prioritet.
	 * @return en str�ng som illustrerar uttrycket.
	 */
	@Override
	public String unparse(int prec) {
		if (prec > this.prec) {
			return "(" + expr1.unparse(this.prec) + "*"
					+ expr2.unparse(this.prec) + ")";
		}
		return expr1.unparse(this.prec) + "*" + expr2.unparse(this.prec);
	}
}
