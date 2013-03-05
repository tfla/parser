package parser;

import java.util.Map;
import java.util.TreeMap;

public class varList {
	private static Map<String,Integer> vlist;

	/**
	 * Skapar et uttrycksträd.
	 */
	public varList() {
		vlist = new TreeMap<String,Integer>();
	}

	/**
	 * Returnerar true om uttrycksträdet innehåller strängen s.
	 *
	 * @param s
	 *			- strängen som skall eftersökas i uttryckträdet.
	 * @return	true om uttrycksträdet innehåller strängen s.
	 */
	public static boolean contains(String s) {
		return vlist.containsKey(s);
	}

	/**
	 * Skapar och lägger till en ny variabel i uttrycksträdet.
	 * 
	 * @param s
	 *			- variabelns namn.
	 * @param v
	 *			- variabelns värde.
	 * @return den nyss tillagda variabeln.
	 */
	public Var add(String s, int v) {
			vlist.put(s,v);
			return new Var(s);
	}

	/**
	 * Returnerar värdet för variabeln med namn s.
	 *
	 * @throws RuntimeException om variabeln inte återfinns i trädet.
	 * @param s
	 *			- variabelns namn.
	 * @return variabelns värde.
	 */
	public int getValue(String s) {
		if (contains(s) != false) {
			return vlist.get(s);
		}
		throw new RuntimeException("Variable not initized!");
	}

}
