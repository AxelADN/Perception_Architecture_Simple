/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.LO;

import Config.Names;
import Config.ProcessTemplate;
import dataStructures.SymbolMatrix;
import java.util.HashMap;

/**
 *
 * @author axeladn
 */
public class LO_Populate extends ProcessTemplate {

	
	private HashMap<String, SymbolMatrix> excentricityMap;

	public LO_Populate() {
		this.ID = Names.V1_Populate;
		
		this.excentricityMap = new HashMap<>();
		
	}

	@Override
	public void init() {
		
		
                

	}

        @Override
	public void receive(long l, byte[] bytes) {
            
        }

}
