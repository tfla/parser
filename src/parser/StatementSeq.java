package parser;

import java.util.Iterator;
import java.util.LinkedList;

public class StatementSeq implements Iterable<Stmt> {
	private LinkedList<Stmt> list;
	public StatementSeq() {
		list=new LinkedList<Stmt>(); 
	}
	public void add(Stmt s){
		list.add(s);
	}
	public Stmt get(){
		return list.getFirst();
	}
	public Stmt remove(){
		return list.remove();
	}
	public String unparse(int level){
		StringBuilder sb=new StringBuilder();
		for (Stmt s: list ){
			sb.append(s.unparse(level) + ";\n");
		}
		return sb.toString();
	}
	
	public void exec(varList vlist){
		for (Stmt s: list ){
			s.exec(vlist);
		}
	}
	
    public Iterator<Stmt> iterator(){
    	return list.iterator();
    }
    public int size(){
    	return list.size();
    }

}
