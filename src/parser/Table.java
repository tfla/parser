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
	 *            - str�ngen f�r vilken villkoret skall utv�rderas.
	 * @return true om s finns i tabellen.
	 */
	public static boolean contains(String s) {
		return vlist.containsKey(s);
	}

	/**
	 * L�gger till en variabel i tabellen.
	 * 
	 * @param s
	 *            - variabelns namn.
	 * @param v
	 *            - variabelns v�rde.
	 * @return variabeln som skapats.
	 */
	public Var add(String s, int v) {
		vlist.put(s, v);
		return new Var(s);
	}

	/**
	 * Returnerar v�rdet f�r variabeln med namn s.
	 * 
	 * @throws RuntimeException
	 *             om variabeln inte existerar.
	 * @param s
	 *            - variabelns namn.
	 * @return variabelns v�rde.
	 */
	public int getValue(String s) {
		if (contains(s) != false) {
			return vlist.get(s);
		}
		throw new RuntimeException(" ERROR: Variable " + s
				+ " not initialized!");
	}
}
