package parser;

import java.util.Iterator;
import java.util.LinkedList;

public class StatementSeq {
	private LinkedList<Stmt> list;

	/**
	 * Skapar en lista med satser.
	 */
	public StatementSeq() {
		list = new LinkedList<Stmt>();
	}

	/**
	 * L�gger till en sats till satsf�ljden.
	 * 
	 * @param s
	 *            - satsen som ska l�ggas till satsf�ljden.
	 */
	public void add(Stmt s) {
		list.add(s);
	}

	/**
	 * H�mtar den f�rsta satsen ur satsf�ljden.
	 * 
	 * @return - f�rsta satsen i satsf�ljden.
	 */
	public Stmt get() {
		return list.getFirst();
	}

	/**
	 * Tar bort en sats ur satsf�ljden.
	 * 
	 * @return - den borttagna satsen.
	 */
	public Stmt remove() {
		return list.remove();
	}

	/**
	 * Returnerar en str�ng som illustrerar satsf�ljden, med radbrytningar.
	 * 
	 * @param level
	 *            - indenteringsniv�n som skall anv�ndas.
	 * @return en str�ng som illustrerar satsf�ljden.
	 */
	public String unparse(int level) {
		StringBuilder sb = new StringBuilder();
		Iterator<Stmt> it = list.listIterator(0);
		sb.append(blank(level) + list.peek().unparse(level));
		it.next();
		while (it.hasNext()) {
			sb.append(";\n" + blank(level) + it.next().unparse(level));
		}
		sb.append('\n');
		return sb.toString();
	}

	/**
	 * 
	 * @param table
	 */
	public void exec(Table table) {
		for (Stmt s : list) {
			s.exec(table);
		}
	}

	/**
	 * Hj�lpmedod f�r att l�gga till r�tt antal blanktecken.
	 * 
	 * @param level
	 * @return
	 */
	private String blank(int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level * 2; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * @return Storleken p� Satsf�ljden.
	 */
	public int size() {
		return list.size();
	}

}
