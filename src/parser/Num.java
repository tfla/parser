package parser;

public class Num extends Expr {
	private int value;

	/**
	 * Skapar ett nummerobjekt.
	 * 
	 * @param v
	 *            - numrets värde.
	 */
	public Num(int v) {
		value = v;
	}

	/**
	 * Returnerar numrets värde.
	 * 
	 * @param list
	 *            - listan med alla uttryck.
	 * @return numrets värde.
	 */
	public int value(Table vlist) {
		return value;
	}

	/**
	 * Returnerar en sträng som illustrerar numrets värde.
	 * 
	 * @param prec
	 *            - rotoperatorns priotitet (används ej).
	 * @return en sträng som illustrerar numrets värde.
	 */
	@Override
	public String unparse(int prec) {
		return new Integer(value).toString();
	}
}
