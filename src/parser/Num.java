package parser;

public class Num extends Expr {
	private int value;

	public Num(int v) {
		value = v;
	}

	public int value() {
		return value;
	}
}
