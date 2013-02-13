package parser;

/** Abstrakt klass som beskriver en nod i ett uttryckstr�d */
public abstract class Expr {	
		/** Ber�kna v�rdet av uttrycket */
		public abstract int value();
		/**  Tolka uttrycket */
		public abstract String unparse();
}
