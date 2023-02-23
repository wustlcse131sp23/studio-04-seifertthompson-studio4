package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String type = in.next();
		
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		
		boolean isFilled = in.nextBoolean();
		
		double centerPosX = in.nextDouble();
		double centerPosY = in.nextDouble();
		double halfWidth = in.nextDouble();
		double halfHeight = in.nextDouble();
		
		System.out.println(type);
		if(type.equals("rectangle") && isFilled == true) {
			StdDraw.setPenColor(red, green, blue);
			StdDraw.filledRectangle(centerPosX, centerPosY, halfWidth, halfHeight);
		}
		else if(type.equals("rectangle")) {
			StdDraw.rectangle(centerPosX, centerPosY, halfWidth, halfHeight);
		}
		else if(type.equals("ellipse") && isFilled == true) {
			StdDraw.setPenColor(red, green, blue);
			StdDraw.filledEllipse(centerPosX, centerPosY, halfWidth, halfHeight);
		}
		else if(type.equals("ellipse")) {
			StdDraw.filledEllipse(centerPosX, centerPosY, halfWidth, halfHeight);
		}
		
		if(in.hasNextDouble())
		{
			double pointXFinal = in.nextDouble();
			double pointYFinal = in.nextDouble();
			double[] pointX = {centerPosX, halfWidth, pointXFinal};
			double[] pointY = {centerPosY, halfHeight, pointYFinal};
			
			if(isFilled == true) {
				StdDraw.setPenColor(red, green, blue);
				StdDraw.filledPolygon(pointX, pointY);
			}
			else
			{
				StdDraw.polygon(pointX, pointY);
			}
		}
	}
}
