package parser;

/** Abstrakt klass som beskriver en nod i ett uttrycksträd */
public abstract class Expr {
	/**
	 * Beräkna värdet av uttrycket.
	 * 
	 * @param table
	 *            - lista med variablerna.
	 * @return Heltalsvärdet av uttrycket.
	 */
	public abstract int value(Table table);

	/**
	 * Returnerar en sträng som illustrerar uttrycket.
	 * 
	 * @param prec
	 *            - rotoperatorns prioritet.
	 * @return en sträng som illustrerar uttrycket.
	 */
	public abstract String unparse(int prec);
}
