package parser;

public class Num extends Expr {
	private int value;

	public Num(int v) {
		value = v;
	}

	public int value() {
		return value;
	}

	@Override
	public String unparse() {
		// TODO Auto-generated method stub
	    return new Integer(value).toString();
	}
}
