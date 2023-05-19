/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

/**
 *
 * @author axeladn
 */
public class Symbol {

	private final int symbol;

	public Symbol(String str0) {
		this.symbol = str0.hashCode();
	}

	public Symbol() {
		this.symbol = 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Symbol other = (Symbol) obj;
		return this.symbol == other.symbol;
	}

	@Override
	public int hashCode() {
		if (this.symbol == 0) {
			int hash = 3;
			hash = 29 * hash + this.symbol;
			return hash;
		}
		return this.symbol;
	}

}
