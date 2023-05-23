/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perceptual_identification_system_simple;


import org.opencv.core.Core;
import perceptual_identification_system_simple.areas.V1.V1;
import cFramework.nodes.service.Igniter;
import perceptual_identification_system_simple.areas.LO.LO;

/**
 *
 * @author axeladn
 */
public class Perceptual_Identification_System_Simple extends Igniter{
	
	public  Perceptual_Identification_System_Simple(){
		addArea(V1.class.getName());
		addArea(LO.class.getName());

		configuration.setLocal(true);
		configuration.setDebug(Boolean.TRUE);
		configuration.setTCP();

		run();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		new Perceptual_Identification_System_Simple();
		
	}

}
