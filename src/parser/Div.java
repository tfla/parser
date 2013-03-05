package parser;

public class Div extends Expr {
	private final int prec = 3; // Prioritetskonstant (+, -) = 1 , (*, /) = 3.
	private Expr expr1, expr2;

	/**
	 * Skapar ett (heltals-)divisionuttryck.
	 * 
	 * @param e1
	 *            - täljaren.
	 * @param e2
	 *            - nämnaren.
	 */
	Div(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	/**
	 * Returnerar värdet av heltalsdivisionen.
	 * 
	 * @param table
	 *            - listan med alla uttryck.
	 * @return värder av heltalsdivisionen.
	 */
	public int value(Table table) {
		return expr1.value(table) / expr2.value(table);
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
			return "(" + expr1.unparse(this.prec) + "/"
					+ expr2.unparse(this.prec) + ")";
		}
		return expr1.unparse(this.prec) + "/" + expr2.unparse(this.prec + 1);
	}
}
