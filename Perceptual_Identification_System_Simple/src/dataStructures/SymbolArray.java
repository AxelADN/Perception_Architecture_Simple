/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import Config.Config;

/**
 *
 * @author axeladn
 */
public class SymbolArray {

	private boolean[][] array;
	private int length;
	private int size;
	//private ArrayList<Boolean> auxArray;
	private Symbol symbol;

	public SymbolArray() {
		this.length = 0;
		this.size = 0;
		//this.auxArray = new ArrayList<>();
		this.symbol = new Symbol();
	}

	public SymbolArray(String symbolStr0) {
		this();
		this.symbol = new Symbol(symbolStr0);
	}
	
	public SymbolArray(Symbol symbol0) {
		this();
		this.symbol = symbol0;
	}

	public void add(double[] matArray0) {
		this.length = matArray0.length;
		this.size = (int) Math.sqrt(this.length);
		this.array = new boolean[this.size][this.size];
		boolean[] currentArray = new boolean[this.length];
		for (int i = 0; i < matArray0.length; i += 1) {
			currentArray[i] = (matArray0[i] > Config.MIN_PIXELS_FACTOR);
		}
		int k = 0;
		for (int i = 0; i < this.size; i += 1) {
			for (int j = 0; j < this.size; j += 1) {
				this.array[i][j] = currentArray[k];
				k += 1;
			}
		}
	}
	
	public void add(boolean[][] booleanMatrix) {
		this.length = (int) Math.pow(booleanMatrix.length,2);
		this.size = (int) Math.sqrt(this.length);
		this.array = booleanMatrix;
		
	}

	/*public void consolidate(){
		if(this.array.length>0){
			return;
		}
		this.length = this.auxArray.size();
		this.array = new boolean[this.length];
		for(int i=0;i<this.length;i+=1){
			this.array[i] = this.auxArray.get(i);
		}
		this.auxArray = null;
	}*/
	public int size() {
		return this.size;
	}

	public boolean get(int i0) {
		return this.array[i0 % this.size][(int) Math.floor(i0 / this.size)];
	}

	public boolean get(int i0, int j0) {
		return this.array[i0][j0];
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

	public int length() {
		return this.length;
	}

	public SymbolArray subArray(int ii0, int jj0, RetinotopicPatch patch0) {
		int newSize = (int) (patch0.getBlockSize() * this.size);
		int originX = patch0.getIndexPos(ii0, jj0).getX();
		int originY = patch0.getIndexPos(ii0, jj0).getY();
		boolean[][] newBooleanMatrix = new boolean[newSize][newSize];
		int i=0;
		int j=0;
		for (int jj = 0 + originX; jj < originX + newSize; jj += 1) {
			for (int ii = 0 + originY; ii < originY + newSize; ii += 1) {
				newBooleanMatrix[i][j] = this.array[ii][jj];
				i+=1;
			}
			j+=1;
		}
		SymbolArray newSymbolArray = new SymbolArray(this.symbol);
		newSymbolArray.add(newBooleanMatrix);
		return newSymbolArray;
	}

}
