package parser;

public class Num extends Expr {
	private int value;

	/**
	 * Skapar ett nummerobjekt.
	 * 
	 * @param v
	 *            - numrets v�rde.
	 */
	public Num(int v) {
		value = v;
	}

	/**
	 * Returnerar numrets v�rde.
	 * 
	 * @param list
	 *            - listan med alla uttryck.
	 * @return numrets v�rde.
	 */
	public int value(Table vlist) {
		return value;
	}

	/**
	 * Returnerar en str�ng som illustrerar numrets v�rde.
	 * 
	 * @param prec
	 *            - rotoperatorns priotitet (anv�nds ej).
	 * @return en str�ng som illustrerar numrets v�rde.
	 */
	@Override
	public String unparse(int prec) {
		return new Integer(value).toString();
	}
}
