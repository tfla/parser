package parser;

public class Sub extends Expr {
	private final int prec = 1;
	private Expr expr1, expr2;

	/**
	 * Skapar ett subtraktionsobjekt.
	 * 
	 * @param e1
	 *            - första termen.
	 * @param e2
	 *            - andra termen.
	 */
	Sub(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	/**
	 * Returnerar differensen mellan termerna.
	 * 
	 * @param table
	 *            - lista med variablerna.
	 * @return differensen mellan termerna.
	 */
	public int value(Table table) {
		return expr1.value(table) - expr2.value(table);
	}

	/**
	 * Returnerar en sträng som illustrerar uttrycket.
	 * 
	 * @param prec
	 *            - rotoperatorns prioritet.
	 * @return en sträng som illustrerar uttrycket.
	 */
	@Override
	public String unparse(int prec) {
		if (prec > this.prec) {
			return "(" + expr1.unparse(this.prec) + "-"
					+ expr2.unparse(this.prec) + ")";
		}
		return expr1.unparse(this.prec) + "-" + expr2.unparse(this.prec + 1);
	}
}
