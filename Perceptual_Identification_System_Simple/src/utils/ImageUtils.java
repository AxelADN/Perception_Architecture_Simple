/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author axeladn
 */
public class ImageUtils {

	private static JFrame frame;

	public static void showImg(Mat img, String name) {
		try {
			frame = new JFrame();
			Random rand = new Random();
			Mat receivedImg = img.clone();
			MatOfByte matOfByte = new MatOfByte();
			Imgcodecs.imencode(".png", receivedImg, matOfByte);
			byte[] byteArray = matOfByte.toArray();
			InputStream in = new ByteArrayInputStream(byteArray);

			BufferedImage bufImage = ImageIO.read(in);
			frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
			frame.pack();
			frame.setSize(img.cols() * 3, img.rows() * 2);
			frame.setLocation(rand.nextInt(100), rand.nextInt(100));
			frame.setVisible(true);
			frame.setTitle(name);
		} catch (IOException ex) {
			Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void showImg(Mat img, long ID, String name) {
		try {
			frame = new JFrame();
			Random rand = new Random();
			Mat receivedImg = img;
			System.out.println(receivedImg);
			MatOfByte matOfByte = new MatOfByte();
			Imgcodecs.imencode(".png", receivedImg, matOfByte);
			byte[] byteArray = matOfByte.toArray();
			InputStream in = new ByteArrayInputStream(byteArray);

			BufferedImage bufImage = ImageIO.read(in);
			frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
			frame.pack();
			frame.setSize(img.cols() * 3, img.rows() * 2);
			frame.setLocation(rand.nextInt(100), rand.nextInt(100));
			frame.setVisible(true);
			frame.setTitle(name + "--" + ID);
		} catch (IOException ex) {
			Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
