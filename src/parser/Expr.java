package parser;

/** Abstrakt klass som beskriver en nod i ett uttryckstr�d */
public abstract class Expr {
	/**
	 * Ber�kna v�rdet av uttrycket.
	 * 
	 * @param table
	 *            - lista med variablerna.
	 * @return Heltalsv�rdet av uttrycket.
	 */
	public abstract int value(Table table);

	/**
	 * Returnerar en str�ng som illustrerar uttrycket.
	 * 
	 * @param prec
	 *            - rotoperatorns prioritet.
	 * @return en str�ng som illustrerar uttrycket.
	 */
	public abstract String unparse(int prec);
}
