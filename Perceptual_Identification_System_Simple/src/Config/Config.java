/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import dataStructures.Reference2D;
import org.opencv.core.Rect;
import org.opencv.core.Size;

/**
 *
 * @author axeladn
 */
public class Config {

	

	public static enum MODALITIES {
		DEFAULT,
	}
	
	
	public static final int MAT_SIZE = 50;
	public static final double MIN_PIXELS_FACTOR = 0.5;
	public static final Size SUB_MAT_PATCH_SIZE = new Size(Config.MAT_SIZE/10,Config.MAT_SIZE/10);
	public static final Reference2D MATRIX_SIZE = new Reference2D(Config.MAT_SIZE/Config.SUB_MAT_PATCH_SIZE.width,Config.MAT_SIZE/Config.SUB_MAT_PATCH_SIZE.height);
	public static final int MIN_PIXELS_SIZE = (int) (Config.SUB_MAT_PATCH_SIZE.width/2);
	
}
