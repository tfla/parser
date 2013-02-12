package parser;

import java.util.ArrayList;
import java.util.Iterator;

public class varList {
	private static ArrayList<Var> vlist;

	public static void VarIn() {
		vlist = new ArrayList<Var>();
	}

	public static int contains(String s) {
		Iterator<Var> it = vlist.iterator();
		int pos = 0;
		while (it.hasNext()) {
			Var v = it.next();
			if (v.GetName().equals(s)) {
				return pos;
			}
			pos++;
		}
		return -1;
	}

	public static Var new_nbr(String s, int v) {
		if (contains(s) == -1) {
			vlist.add(new Var(s, v));
			return new Var(s, v);
		} else {
			vlist.set(contains(s), new Var(vlist.get(contains(s)).GetName(), v));
			return vlist.get(contains(s));
		}
	}

	public static Var getNum(String s) {
		if (contains(s) != -1) {
			return vlist.get(contains(s));
		}
		return null;
	}

	public static void print() {
		while (vlist.size() > 0) {
			Var v = vlist.remove(vlist.size() - 1);
			System.out.println(v.GetName() + "=" + v.value());
		}
	}
}
