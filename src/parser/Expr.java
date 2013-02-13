package parser;

/** Abstrakt klass som beskriver en nod i ett uttrycksträd */
public abstract class Expr {	
		/** Beräkna värdet av uttrycket */
		public abstract int value();
		/**  Tolka uttrycket */
		public abstract String unparse();
}
