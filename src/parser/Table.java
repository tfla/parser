package parser;

import java.util.Map;
import java.util.TreeMap;

public class Table {
	private static Map<String, Integer> vlist;

	/**
	 * Skapar en tabell.
	 */
	public Table() {
		vlist = new TreeMap<String, Integer>();
	}

	/**
	 * Returnerar true ifall s finns i tabellen.
	 * 
	 * @param s
	 *            - strängen för vilken villkoret skall utvärderas.
	 * @return true om s finns i tabellen.
	 */
	public static boolean contains(String s) {
		return vlist.containsKey(s);
	}

	/**
	 * Lägger till en variabel i tabellen.
	 * 
	 * @param s
	 *            - variabelns namn.
	 * @param v
	 *            - variabelns värde.
	 * @return variabeln som skapats.
	 */
	public Var add(String s, int v) {
		vlist.put(s, v);
		return new Var(s);
	}

	/**
	 * Returnerar värdet för variabeln med namn s.
	 * 
	 * @throws RuntimeException
	 *             om variabeln inte existerar.
	 * @param s
	 *            - variabelns namn.
	 * @return variabelns värde.
	 */
	public int getValue(String s) {
		if (contains(s) != false) {
			return vlist.get(s);
		}
		throw new RuntimeException(" ERROR: Variable " + s
				+ " not initialized!");
	}
}
