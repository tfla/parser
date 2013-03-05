package parser;

import java.util.Map;
import java.util.TreeMap;

public class varList {
	private static Map<String,Integer> vlist;
/**
 * 
 */
	public varList() {
		vlist = new TreeMap<String,Integer>();
	}
/**
 * 
 * @param s
 * @return
 */
	public static boolean contains(String s) {
		return vlist.containsKey(s);
	}
/**
 * 
 * @param s
 * @param v
 * @return
 */
	public Var add(String s, int v) {
			vlist.put(s,v);
			return new Var(s);
	}
/**
 * @throws RuntimeException
 * @param s
 * @return
 */
	public int getValue(String s) {
		if (contains(s) != false) {
			return vlist.get(s);
		}
		throw new RuntimeException("Variable not initized!");
	}

//	public void print() {
//		while (vlist.size() > 0) {
//			int v = (int) vlist.remove(vlist.size() - 1);
//			System.out.println(v.unparse(0) + "=" + v.value(this));
//		}
//	}
}
