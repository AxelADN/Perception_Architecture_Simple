/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.LO;

import perceptual_identification_system_simple.areas.V1.*;
import Config.AreaTemplate;
import Config.Names;
import static Config.Names.V1_Populate;

/**
 *
 * @author axeladn
 */
public class LO extends AreaTemplate {

	public LO() {
		this.ID = Names.LO;
		addProcess(LO_Populate.class);
		
	}

	@Override
	public void receive(long l, byte[] bytes) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
