/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

import java.util.ArrayList;

/**
 *
 * @author axeladn
 */
public class SymbolMatrix {
	
	boolean[][] matrix;
	ArrayList<SymbolArray> auxMatrix;
	
	public SymbolMatrix(){
		this.auxMatrix = new ArrayList<>();
	}
	
	public void add(SymbolArray array0){
		this.auxMatrix.add(array0);
	}
	
	public void consolidate(){
		int sizeX = this.auxMatrix.get(0).size();
		int sizeY = this.auxMatrix.size();
		matrix = new boolean[sizeX][sizeY];
		for(int j=0; j<sizeY;j+=1){
			for(int i=0; i<sizeX;i+=1){
				this.matrix[i][j] = this.auxMatrix.get(j).get(i);
			}
		}
		this.auxMatrix = null;
	}
	
}
