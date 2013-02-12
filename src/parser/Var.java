package parser;


public class Var extends Expr {
	private int value;
	private String name; 

	public Var(String s,int v) {
		value = v;
		this.name = s;
	}
    public boolean equals(Object obj){
    		return name.equals((String) obj); 
    }
	public int value() {
		return value;
	}
	public String GetName() {
		return name;
	}
	 
}
