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
	 * Lägger till en sats till satsföljden.
	 * 
	 * @param s
	 *            - satsen som ska läggas till satsföljden.
	 */
	public void add(Stmt s) {
		list.add(s);
	}

	/**
	 * Hämtar den första satsen ur satsföljden.
	 * 
	 * @return - första satsen i satsföljden.
	 */
	public Stmt get() {
		return list.getFirst();
	}

	/**
	 * Tar bort en sats ur satsföljden.
	 * 
	 * @return - den borttagna satsen.
	 */
	public Stmt remove() {
		return list.remove();
	}

	/**
	 * Returnerar en sträng som illustrerar satsföljden, med radbrytningar.
	 * 
	 * @param level
	 *            - indenteringsnivån som skall användas.
	 * @return en sträng som illustrerar satsföljden.
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
	 * Hjälpmedod för att lägga till rätt antal blanktecken.
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
	 * @return Storleken på Satsföljden.
	 */
	public int size() {
		return list.size();
	}

}
