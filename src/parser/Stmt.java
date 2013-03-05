package parser;

/** Abstrakt klass som beskriver en sats i ett programtr�d */
public abstract class Stmt {
	/**
	 * Abstrakt metod f�r att tolka satsen som programkod
	 * 
	 * @param level
	 *            - indenteringsniv�n som skall anv�ndas.
	 */
	public abstract String unparse(int level);

	/**
	 * Abstrakt metod f�r att exekvera satsen.
	 * 
	 * @param table
	 *            - listan med alla uttryck.
	 */
	public abstract void exec(Table table);
}
