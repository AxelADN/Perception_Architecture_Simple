/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author axeladn
 */
public class SymbolMatrix {
	
	boolean[][] matrix;
	HashMap<Symbol,SymbolArray> auxMatrix;
	
	public SymbolMatrix(){
		this.auxMatrix = new HashMap<>();
	}
	
	public void add(SymbolArray array0){
		Symbol auxSymbol = array0.getSymbol();
		this.auxMatrix.put(auxSymbol, array0);
	}
	
	public void consolidate(){
		int sizeX = ((SymbolArray)this.auxMatrix.values().toArray()[0]).size();
		int sizeY = this.auxMatrix.size();
		matrix = new boolean[sizeX][sizeY];
		for(int j=0; j<sizeY;j+=1){
			List<Symbol> orderedSymbols = new ArrayList<Symbol>(this.auxMatrix.keySet());
			Collections.sort(orderedSymbols,new SymbolComparator());
			for(int i=0; i<sizeX;i+=1){
				this.matrix[i][j] = this.auxMatrix.get(orderedSymbols.get(j)).get(i);
			}
		}
		this.auxMatrix = null;
		System.out.println("[");
		for(int j=0; j<sizeY;j+=1){
			System.out.println("[");
			for(int i=0; i<sizeX;i+=1){
				System.out.print(this.matrix[i][j]);
				System.out.print(",");
			}
			System.out.println("],");
		}
		System.out.println("]");
	}
	
}


