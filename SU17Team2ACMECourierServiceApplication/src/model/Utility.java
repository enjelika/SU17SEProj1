package model;
/*
 * @author Debra Hogue
 */

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Utility 
{
	public static Image getImage(String fileName) 
	{
        Image image = null;
        
        try 
        {
            image = ImageIO.read(new File(fileName));
        } 
        catch (Exception ioe) 
        {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        
        return image;
    }
}
