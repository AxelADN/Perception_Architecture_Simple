/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptual_identification_system_simple.areas.V1;

import java.util.HashMap;
import utils.Dictionary;

/**
 *
 * @author axeladn
 */
public class V1_Metadata {

	public static final HashMap<String, double[]> excentricityPatches = new HashMap<>();
	public static final String FOVEA = "FOVEA";
	public static final String PARAFOVEA = "PARAFOVEA";
	public static final String PERIFOVEA = "PERIFOVEA";
	public static final Dictionary dict = new Dictionary("V1");

	static {
		double[] foveaPatch = new double[]{0.33, 0.33, 0.33, 0.33};
		double[] paraFoveaPatch = new double[]{0.166, 0.166, 0.66, 0.66};
		double[] periFoveaPatch = new double[]{0.0, 0.0, 1.0, 1.0};

		V1_Metadata.excentricityPatches.put(V1_Metadata.FOVEA, foveaPatch);
		V1_Metadata.excentricityPatches.put(V1_Metadata.PARAFOVEA, paraFoveaPatch);
		V1_Metadata.excentricityPatches.put(V1_Metadata.PERIFOVEA, periFoveaPatch);

		dict.addKeyType("ComplexCells");
		dict.addKeyType("DoubleOpponent");
		dict.addKeyType("HyperComplexCells");
		dict.addKeyType("MergedHyperComplexCells");
		dict.addKeyType("SimpleCells");
		dict.addKeySubtype("Or_0");
		dict.addKeySubtype("Or_1");
		dict.addKeySubtype("Or_2");
		dict.addKeySubtype("Or_3");
		dict.addKeySubtype("Bank_0");
		dict.addKeySubtype("Bank0");
		dict.addKeySubtype("Eye_0");
		dict.addKeySubtype("Dp");
		dict.addKeySubtype("Kp");
		dict.addKeySubtype("Lp");
		dict.addKeySubtype("Type_0");
		dict.addKeySubtype("Type_1");
		dict.addKeySubtype("Phase1");
		dict.addKeySubtype("Phase2");
	}

}
