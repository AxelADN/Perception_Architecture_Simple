/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.V1;

/**
 *
 * @author axeladn
 */
public class V1  {

	private V1_Populate populate;
	
	public byte[] Populate(){
		this.populate = new V1_Populate();
		this.populate.run();
	}

}
