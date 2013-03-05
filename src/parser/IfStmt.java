package parser;

public class IfStmt extends Stmt {
	private Expr exp; // vilkor
	private StatementSeq list; // "then" satser
	private StatementSeq slist; // "else" satser

	/**
	 * Konstruktor
	 * 
	 * @param exp
	 *            - uttrycket som ska utv�rderas.
	 * @param list
	 *            - satsf�ljden som ska utf�ras om exp �r sant (!= 0).
	 * @param slist
	 *            - satsf�ljden som ska utf�ras om exp �r falskt (== 0).
	 */
	IfStmt(Expr exp, StatementSeq list, StatementSeq slist) {
		this.exp = exp;
		this.list = list;
		this.slist = slist;
	}

	/**
	 * Utf�r parsingen av if-satsen.
	 * 
	 * @param level
	 *            - indenteringsniv�n som skall anv�ndas.
	 * @return texten som motsvarar if-satsen.
	 */
	public String unparse(int level) {
		StringBuilder sb = new StringBuilder();
		sb.append("if " + exp.unparse(0) + " then");
		sb.append('\n');
		sb.append(list.unparse(level + 1));
		if (slist.size() > 0) {
			sb.append(blank(level) + "else" + '\n');
		}
		sb.append(slist.unparse(level + 1));
		sb.append(blank(level) + "endif");
		return sb.toString();
	}

	/**
	 * Hj�lpmedod f�r att l�gga till r�tt antal blanktecken f�r if-satser p�
	 * indenteringsniv�n level.
	 * 
	 * @param level
	 *            - indenteringsniv�n som skall anv�ndas.
	 * @return en str�ng med r�tt antal blanktecken.
	 */
	private String blank(int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level * 2; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * Ber�kna v�rdet av satserna i if-satsen.
	 */
	@Override
	public void exec(Table table) {
		if (exp.value(table) != 0) {
			list.exec(table);
		} else {
			slist.exec(table);
		}

	}
}
