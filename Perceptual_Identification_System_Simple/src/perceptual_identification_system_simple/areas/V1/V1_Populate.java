/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.V1;

import dataStructures.SymbolArray;
import dataStructures.SymbolMatrix;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opencv.core.Mat;
import utils.FileHelper;
import utils.LongSpike;

/**
 *
 * @author axeladn
 */
public class V1_Populate  {

	public static int eventIndex = 0;	
	
	private static FileHelper fileHelper;
	private static String rootFile;
	private static HashMap<String, SymbolMatrix> excentricityMap;

	static{
		fileHelper = new FileHelper();
		rootFile = V1_Metadata.rootFile;
		excentricityMap = new HashMap<>();

	}
	
	public static byte[] run() {
		fileHelper.setPath(rootFile);
		fileHelper.setDataFileList();
		fileHelper.extractDataFromFileList();
		convertToSymbols(fileHelper.setExcentricity());
		V1_Populate.eventIndex += 1;
		System.out.println("	asdasdssfsfsfsfsfsfsf");
		System.out.println("break");
		return sendFovea();
	}

	private static void convertToSymbols(HashMap<String, HashMap> matMap0) {

		for (String excentricity : matMap0.keySet()) {

			HashMap<String, Mat> mats = matMap0.get(excentricity);
			SymbolMatrix matrix = new SymbolMatrix();
			for (String path : mats.keySet()) {
				Mat currentMat = mats.get(path);
				double[] matArray = new double[currentMat.channels() * (int) currentMat.total()];
				currentMat.get(0, 0, matArray);
				SymbolArray array = new SymbolArray(path);

				array.add(matArray);
				matrix.add(array);
			}

			//matrix.consolidate();
			//System.out.println(excentricity);
			//matrix.print();
			excentricityMap.put(excentricity, matrix);
		}
	}

	private static byte[] sendFovea() {
		try {
			String excentricity0 = "FOVEA";
			SymbolMatrix currentMatrix = excentricityMap.get(excentricity0);
			LongSpike spike = new LongSpike(currentMatrix, V1_Populate.eventIndex);
			
			return spike.getByteArray();
		} catch (IOException ex) {
			Logger.getLogger(V1_Populate.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
