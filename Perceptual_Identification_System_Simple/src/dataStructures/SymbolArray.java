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

	private boolean[] array;
	private int size;
	private ArrayList<Boolean> auxArray;
	private Symbol symbol;

	public SymbolArray() {
		this.size = 0;
		this.auxArray = new ArrayList<>();
		this.symbol = new Symbol();
	}
	
	public SymbolArray(String symbolStr0){
		this();
		this.symbol = new Symbol(symbolStr0);
	}

	public void add(double value0) {
		this.auxArray.add(
			value0 > Config.MIN_PIXELS_FACTOR
		);
	}

	public void add(Mat submat0) {

		this.auxArray.add(
			Core.countNonZero(submat0) > Config.MIN_PIXELS_SIZE
		);

	}

	public void add(double[] matArray0) {
		this.size = matArray0.length;
		this.array = new boolean[this.size];
		for (int i = 0; i < matArray0.length; i += 1) {
			this.array[i] = (
				matArray0[i] > Config.MIN_PIXELS_FACTOR
			);
		}
	}
	
	public void consolidate(){
		if(this.array.length>0){
			return;
		}
		this.size = this.auxArray.size();
		this.array = new boolean[this.size];
		for(int i=0;i<this.size;i+=1){
			this.array[i] = this.auxArray.get(i);
		}
		this.auxArray = null;
	}

	public int size() {
		return this.size;
	}

	public boolean get(int i) {
		return this.array[i];
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

}
