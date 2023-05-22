/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.V1;

import Config.Names;
import Config.ProcessTemplate;
import dataStructures.SymbolArray;
import dataStructures.SymbolMatrix;
import java.util.HashMap;
import org.opencv.core.Mat;
import utils.FileHelper;

/**
 *
 * @author axeladn
 */
public class V1_Populate extends ProcessTemplate {

	private FileHelper fileHelper;
	private String rootFile;
	private HashMap<String, SymbolMatrix> excentricityMap;

	public V1_Populate() {
		this.ID = Names.V1_Populate;
		this.fileHelper = new FileHelper();
		this.rootFile = "/home/axeladn/Documents/Tesis_Doctorado/Perception_System/Sensory_Data_Set/V1/";
		this.excentricityMap = new HashMap<>();
		
	}

	@Override
	public void init() {
		
		fileHelper.setPath(rootFile);
		fileHelper.setDataFileList();
		fileHelper.extractDataFromFileList();
		convertToSymbols(fileHelper.setExcentricity());
                this.send("FOVEA");
                

	}

	private void convertToSymbols(HashMap<String, HashMap> matMap0) {
            
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
                        
			matrix.consolidate();
                        System.out.println(excentricity);
                        matrix.print();
			this.excentricityMap.put(excentricity, matrix);
		}
	}
        
        
        private void send(String excentricity0){
            SymbolMatrix currentMatrix = this.excentricityMap.get(excentricity0);
            byte[] matrixBytes = currentMatrix.toBytes();
        }

}
