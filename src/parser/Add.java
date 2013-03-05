package parser;

public class Add extends Expr {
	private final int prec = 1;
	private Expr expr1, expr2;

	/**
	 * Skapar ett additionsuttryck.
	 * 
	 * @param e1
	 *            - uttryck 1 som ska ingå i additionen.
	 * @param e2
	 *            - uttryck 2 som ska ingå i additionen.
	 */
	Add(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	/**
	 * Returnerar summan av termerna i uttrycket.
	 * 
	 * @param table
	 *            - listan med alla variabler.
	 * @return Summan av termerna i uttrycket.
	 */
	public int value(Table table) {
		return expr1.value(table) + expr2.value(table);
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
			return "(" + expr1.unparse(this.prec) + "+"
					+ expr2.unparse(this.prec) + ")";
		}
		return expr1.unparse(this.prec) + "+" + expr2.unparse(this.prec);
	}
}
