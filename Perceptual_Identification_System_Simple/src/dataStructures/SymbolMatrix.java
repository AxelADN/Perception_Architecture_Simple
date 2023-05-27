/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author axeladn
 */
public class SymbolMatrix implements Serializable {

	//boolean[][] matrix;
	HashMap<Symbol, SymbolArray> hashMatrix;
	int sizeX;
	int sizeY;

	public SymbolMatrix() {
		this.hashMatrix = new HashMap<>();
		//this.matrix = null;
		this.sizeX = 0;
		this.sizeY = 0;
	}

	public void add(SymbolArray array0) {
		Symbol auxSymbol = array0.getSymbol();
		this.hashMatrix.put(auxSymbol, array0);
		this.sizeY = this.hashMatrix.size();
		this.sizeX = array0.length();
	}

	/*public void consolidate() {
		this.sizeX = ((SymbolArray) this.hashMatrix.values().toArray()[0]).size();
		this.sizeY = this.hashMatrix.size();
		this.matrix = new boolean[sizeX][sizeY];
		for (int j = 0; j < sizeY; j += 1) {
			List<Symbol> orderedSymbols = new ArrayList<>(this.hashMatrix.keySet());
			Collections.sort(orderedSymbols, new SymbolComparator());
			for (int i = 0; i < sizeX; i += 1) {
				this.matrix[i][j] = this.hashMatrix.get(orderedSymbols.get(j)).get(i);
			}
		}
		this.hashMatrix = null;

	}*/

	public void print() {
		/*if (this.matrix != null) {
			System.out.print("[");
			for (int j = 0; j < sizeY; j += 1) {
				System.out.print("[");
				for (int i = 0; i < sizeX; i += 1) {
					System.out.print(this.matrix[i][j] ? 1 : 0);
				}
				System.out.println("],");
			}
			System.out.println("]");
			return;
		}*/
		System.out.print("[");
		for (Symbol j : this.hashMatrix.keySet()) {
			System.out.print("[");
			for (int i = 0; i < sizeX; i += 1) {
				System.out.print(this.hashMatrix.get(j).get(i) ? 1 : 0);
			}
			System.out.println("],");
		}
		System.out.println("]");

	}

	public SymbolMatrix subMatrix(int ii0, int jj0, RetinotopicPatch patch0) {
		SymbolMatrix newMatrix = new SymbolMatrix();
		SymbolArray currentArray;
		SymbolArray newArray;
		for (Symbol sym : this.hashMatrix.keySet()) {
			currentArray = this.hashMatrix.get(sym);
			newArray = currentArray.subArray(ii0,jj0, patch0);
			newMatrix.add(newArray);
		}
		return newMatrix;
	}

}
