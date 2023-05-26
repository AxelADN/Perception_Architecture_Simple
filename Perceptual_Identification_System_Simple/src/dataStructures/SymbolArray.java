/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import Config.Config;
import java.util.ArrayList;
import org.opencv.core.Core;
import org.opencv.core.Mat;

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
		//this.auxArray = new ArrayList<>();
		this.symbol = new Symbol();
	}

	public SymbolArray(String symbolStr0) {
		this();
		this.symbol = new Symbol(symbolStr0);
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
		return this.array[i0%this.size][(int)Math.floor(i0/this.size)];
	}
	
	public boolean get(int i0,int j0){
		return this.array[i0][j0];
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

	public int length() {
		return this.length;
	}

	void subArray(int ii0, int jj0, RetinotopicPatch patch0) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
