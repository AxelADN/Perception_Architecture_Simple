/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import cFramework.util.IDHelper;

/**
 *
 * @author AxelADN
 */
public class Names {

	public static long ObserverNode = IDHelper.generateID("ObserverNode");
	public static long StartingNode = IDHelper.generateID("ObserverNode", "StartingNode");

	public static long V1 = IDHelper.generateID("V1");
	public static long V1_Populate = IDHelper.generateID("V1", "V1_Populate");

	public static long V2 = IDHelper.generateID("V2");
	public static long V2_AngularActivation = IDHelper.generateID("V2", "V2_AngularActivation");

	public static long V4 = IDHelper.generateID("V4");
	public static long V4_ShapeActivation = IDHelper.generateID("V4", "V4_ShapeActivation");

	public static long LO = IDHelper.generateID("LO");
        public static long LO_Populate = IDHelper.generateID("LO", "LO_Populate");
    
}
