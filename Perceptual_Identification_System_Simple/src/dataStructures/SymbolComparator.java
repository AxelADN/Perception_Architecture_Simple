/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import java.util.Comparator;

/**
 *
 * @author axeladn
 */
class SymbolComparator implements Comparator<Symbol>{

	@Override
	public int compare(Symbol t1, Symbol t2) {
		if(t1.hashCode()-t2.hashCode() > 0){
			return 1;
		}
		if(t1.hashCode() - t2.hashCode() < 0){
			return -1;
		}
		return 0;
	}
	
}
