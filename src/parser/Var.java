package parser;

public class Var extends Expr {
	private String name;

	/**
	 * Skapar en variabel med namn s.
	 *
	 * @param s
	 *			- variabelns namn.
	 */
	public Var(String s) {
		this.name = s;
	}

	/**
	 * Returnerar true om variabelns namn är lika med obj.
	 *
	 * @param obj
	 *			- det objekt för vilket en evaluering skall utföras.
	 * @return true om namnet för variabeln är lika med strängen obj.	
	 */
	public boolean equals(Object obj) {
		return name.equals((String) obj);
	}

	/**
	 * Returnerar variabelns värde.
	 * 
	 * @param table
	 *			- listan med alla uttryck.
	 * @return variabelns värde.
	 */
	public int value(Table table) {
		return table.getValue(name);
	}

	/**
	 * Returnerar en sträng som illustrerar variabeln.
	 * 
	 * @param level
	 *			- indenteringsnivån som skall användas.
	 * @return en sträng som illustrerar variablen.
	 */
	@Override
	public String unparse(int prec) {
		return name;
	}

}
