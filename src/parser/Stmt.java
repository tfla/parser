package parser;

/** Abstrakt klass som beskriver en sats i ett programträd */
public abstract class Stmt {
	/**
	 * Abstrakt metod för att tolka satsen som programkod
	 * 
	 * @param level
	 *            - indenteringsnivån som skall användas.
	 */
	public abstract String unparse(int level);

	/**
	 * Abstrakt metod för att exekvera satsen.
	 * 
	 * @param table
	 *            - listan med alla uttryck.
	 */
	public abstract void exec(Table table);
}
