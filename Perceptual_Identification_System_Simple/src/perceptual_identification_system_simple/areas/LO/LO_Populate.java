/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.LO;

import Config.Names;
import Config.ProcessTemplate;
import cFramework.communications.spikes.LongSpike;
import dataStructures.RetinotopicPatch;
import dataStructures.SymbolMatrix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axeladn
 */
public class LO_Populate extends ProcessTemplate {

	private ArrayList<HashMap<List<Integer>,SymbolMatrix>> data;

	public LO_Populate() {
		this.ID = Names.LO_Populate;
		this.data = new ArrayList<>();

	}

	@Override
	public void init() {

	}

	@Override
	public void receive(long l, byte[] bytes) {
		SymbolMatrix matrix = this.getSymbolMatrix(bytes);
		matrix.print();
		this.getDataMatrices(matrix);
	}

	private SymbolMatrix getSymbolMatrix(byte[] bytes) {
		LongSpike spike;
		try {
			spike = new LongSpike(bytes);
			return (SymbolMatrix) spike.getIntensity();
		} catch (Exception ex) {
			Logger.getLogger(LO_Populate.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
		
		
	}

	private void getDataMatrices(SymbolMatrix matrix) {
		RetinotopicPatch patch;
		SymbolMatrix subMatrix;
		int sizeX;
		int sizeY;
		for(int i=1; i<=8;i+=1){
			patch = new RetinotopicPatch(i);
			sizeX = patch.getSize().getSizeX();
			sizeY = patch.getSize().getSizeY();
			for(int ii=0; ii<sizeX; ii+=1){
				for(int jj=0; jj<sizeY; jj+=1){
					subMatrix = matrix.subMatrix(ii,jj,patch);
				}
			}
			
		}
	}

}
