/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perceptual_identification_system_simple;


import org.opencv.core.Core;
import perceptual_identification_system_simple.areas.LO.LO;
import perceptual_identification_system_simple.areas.V1.V1;

/**
 *
 * @author axeladn
 */
public class Perceptual_Identification_System_Simple {
	
	public  Perceptual_Identification_System_Simple(){
		V1 v1 = new V1();
		v1.Populate();
		byte[] LO_data = LO.Populate(V1_data);
		
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		new Perceptual_Identification_System_Simple();
		
	}

}
