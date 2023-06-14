/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.LO;

import dataStructures.RetinotopicPatch;
import dataStructures.SymbolMatrix;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.LongSpike;

/**
 *
 * @author axeladn
 */
public class LO_Populate {

	private static HashMap<Integer, HashMap<List<Integer>, SymbolMatrix>> data;
	private static int eventIndex;

	static {
		data = new HashMap<>();
		eventIndex = 0;
	}

	public static byte[] run(byte[] bytes) {
		System.out.println("aldskjnladnolasdkjla");
		SymbolMatrix matrix = getSymbolMatrix(bytes);
		//matrix.print();
		getDataMatrices(matrix);
		printAll();
		return getSpikeBytes();
	}

	private static SymbolMatrix getSymbolMatrix(byte[] bytes) {
		try {
			LongSpike spike;
			spike = new LongSpike(bytes);
			eventIndex = spike.getTiming();
			return (SymbolMatrix) spike.getIntensity();
		} catch (IOException ex) {
			Logger.getLogger(LO_Populate.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LO_Populate.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}

	private static void getDataMatrices(SymbolMatrix matrix) {
		RetinotopicPatch patch;
		SymbolMatrix subMatrix;
		int X = 0;
		int Y = 1;
		int sizeX;
		int sizeY;
		List<Integer> index = new ArrayList<>();
		index.add(0);
		index.add(0);
		HashMap<List<Integer>, SymbolMatrix> symbolMatrixMatrix = new HashMap<>();
		for (int i = 1; i <= 8; i += 1) {
			patch = new RetinotopicPatch(i);
			sizeX = patch.getSize().getSizeX();
			sizeY = patch.getSize().getSizeY();
			for (int ii = 0; ii < sizeX; ii += 1) {
				for (int jj = 0; jj < sizeY; jj += 1) {
					subMatrix = matrix.subMatrix(ii, jj, patch);
					index = new ArrayList<>();
					index.add( ii);
					index.add( jj);
					symbolMatrixMatrix.put(index, subMatrix);
				}
			}
			data.put(i, symbolMatrixMatrix);

		}
	}

	private static void printAll() {
		HashMap<List<Integer>, SymbolMatrix> symbolMatrixMatrix;
		SymbolMatrix currentSymbolMatrix;
		for (int level : data.keySet()) {
			symbolMatrixMatrix = data.get(level);
			for (List index : symbolMatrixMatrix.keySet()) {
				currentSymbolMatrix = symbolMatrixMatrix.get(index);
				currentSymbolMatrix.print();
			}
		}
	}

	private static byte[] getSpikeBytes() {
		try {
			LongSpike spike = new LongSpike(data, eventIndex);
			return spike.getByteArray();
		} catch (IOException ex) {
			Logger.getLogger(LO_Populate.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
