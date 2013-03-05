package parser;

public class Var extends Expr {
	private String name;

	/**
	 * 
	 * @param s
	 */
	public Var(String s) {
		this.name = s;
	}

	/**
 * 	
 */
	public boolean equals(Object obj) {
		return name.equals((String) obj);
	}

	/**
  * 
  */
	public int value(Table table) {
		return table.getValue(name);
	}

	/**
 * 
 */
	@Override
	public String unparse(int prec) {
		return name;
	}

}
