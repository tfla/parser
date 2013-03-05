package parser;

public class IfStmt extends Stmt {
	private Expr exp; // vilkor
	private StatementSeq list; // "then" satser
	private StatementSeq slist; // "else" satser

	/**
	 * Konstruktor
	 * 
	 * @param exp
	 *            - uttrycket som ska utvärderas.
	 * @param list
	 *            - satsföljden som ska utföras om exp är sant (!= 0).
	 * @param slist
	 *            - satsföljden som ska utföras om exp är falskt (== 0).
	 */
	IfStmt(Expr exp, StatementSeq list, StatementSeq slist) {
		this.exp = exp;
		this.list = list;
		this.slist = slist;
	}

	/**
	 * Utför parsingen av if-satsen.
	 * 
	 * @param level
	 *            - indenteringsnivån som skall användas.
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
	 * Hjälpmedod för att lägga till rätt antal blanktecken för if-satser på
	 * indenteringsnivån level.
	 * 
	 * @param level
	 *            - indenteringsnivån som skall användas.
	 * @return en sträng med rätt antal blanktecken.
	 */
	private String blank(int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level * 2; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * Beräkna värdet av satserna i if-satsen.
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
