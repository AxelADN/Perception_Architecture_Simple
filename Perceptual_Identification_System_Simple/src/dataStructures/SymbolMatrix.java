/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author axeladn
 */
public class SymbolMatrix implements Serializable {

	boolean[][] matrix;
	HashMap<Symbol, SymbolArray> auxMatrix;
	int sizeX;
	int sizeY;

	public SymbolMatrix() {
		this.auxMatrix = new HashMap<>();
		this.matrix = new boolean[][]{};
		this.sizeX = 0;
		this.sizeY = 0;
	}

	public void add(SymbolArray array0) {
		Symbol auxSymbol = array0.getSymbol();
		this.auxMatrix.put(auxSymbol, array0);
	}

	public void consolidate() {
		this.sizeX = ((SymbolArray) this.auxMatrix.values().toArray()[0]).size();
		this.sizeY = this.auxMatrix.size();
		this.matrix = new boolean[sizeX][sizeY];
		for (int j = 0; j < sizeY; j += 1) {
			List<Symbol> orderedSymbols = new ArrayList<Symbol>(this.auxMatrix.keySet());
			Collections.sort(orderedSymbols, new SymbolComparator());
			for (int i = 0; i < sizeX; i += 1) {
				this.matrix[i][j] = this.auxMatrix.get(orderedSymbols.get(j)).get(i);
			}
		}
		this.auxMatrix = null;

	}

	public void print() {
		System.out.print("[");
		for (int j = 0; j < sizeY; j += 1) {
			System.out.print("[");
			for (int i = 0; i < sizeX; i += 1) {
				System.out.print(this.matrix[i][j] ? 1 : 0);
			}
			System.out.println("],");
		}
		System.out.println("]");
	}

	public SymbolMatrix subMatrix(int ii0, int jj0, RetinotopicPatch patch0) {
		int originX = patch0.getIndexPos(ii0, jj0).getX();
		int originY = patch0.getIndexPos(ii0, jj0).getY();
		int size = patch0.getBlockSize()*this.sizeX;
		for (int ii = 0; ii < sizeX; ii += 1) {
			for (int jj = 0; jj < sizeY; jj += 1) {
				
			}
		}
	}

}
