package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import courierDAO.IntersectionsDAO;
import courierPD.Intersections;
import model.Utility;

@SuppressWarnings("serial")
public class UpdateMapScreen extends JPanel
{
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo, acmeMap;
    
    private JLabel imageFrame;
	private JPanel mapScreenContainer, southButtonContainer, mainPane, imgContainer;
	private JButton saveButton, backButton, logoutButton;
	
	private ButtonController mapButtonController;
	
	public JCheckBox aStAnd1stAve, aStAnd2ndAve, aStAnd3rdAve, aStAnd4thAve, aStAnd5thAve, aStAnd6thAve, aStAnd7thAve,
					 bStAnd1stAve, bStAnd2ndAve, bStAnd3rdAve, bStAnd4thAve, bStAnd5thAve, bStAnd6thAve, bStAnd7thAve, 
					 cStAnd1stAve, cStAnd2ndAve, cStAnd3rdAve, cStAnd4thAve, cStAnd5thAve, cStAnd6thAve, cStAnd7thAve,
					 dStAnd1stAve, dStAnd2ndAve, dStAnd3rdAve, dStAnd4thAve, dStAnd5thAve, dStAnd6thAve, dStAnd7thAve,
					 eStAnd1stAve, eStAnd2ndAve, eStAnd3rdAve, eStAnd4thAve, eStAnd5thAve, eStAnd6thAve, eStAnd7thAve,
					 fStAnd1stAve, fStAnd2ndAve, fStAnd3rdAve, fStAnd4thAve, fStAnd5thAve, fStAnd6thAve, fStAnd7thAve,
					 gStAnd1stAve, gStAnd2ndAve, gStAnd3rdAve, gStAnd4thAve, gStAnd5thAve, gStAnd6thAve, gStAnd7thAve;
					 
	private List<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
	public List<Intersections> intersections;
	
    public UpdateMapScreen(ButtonController buttonController)
    {
    	mapButtonController = buttonController;
    	
    	// Set ViewListener
		buttonController.setViewListener(new ViewListener()
		{
			public Object GetView() 
			{
				return UpdateMapScreen.this;
			}			

		});
    	
    	initCheckBoxes();
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	mapScreenContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 0, 0, 0);
    	mapScreenContainer.setBorder(new CompoundBorder(margin, border));
    	mapScreenContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(0, 5, 5, 5));
    	southButtonContainer.setLayout(new BoxLayout(southButtonContainer, BoxLayout.X_AXIS));
    	
    	// Set the Logo image for the North part of the window
    	try 
    	{ 
    		acmeCourierServiceLogo = ImageIO.read(new File(filePath + separator + "images" + separator + "exSmAcmeCourierServiceLogo.png"));
    		acmeMap = ImageIO.read(new File(filePath + separator + "images" + separator + "acmeMap.png"));
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
    	
    	// Save Button
    	Image saveButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "smSaveButton.png");
    	saveButton = new JButton(new ImageIcon(saveButtonIcon));     	
    	
    	// Back Button
    	Image backButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "backButton2.png");
    	backButton = new JButton(new ImageIcon(backButtonIcon));
    	
    	// Logout Button
    	Image logoutButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "logoutButton.png");
    	logoutButton = new JButton(new ImageIcon(logoutButtonIcon));
    	
    	SetUpView();
    	
    	loadCheckboxValues();
    }
    
    // Initialization of all the global check boxes
    public void initCheckBoxes()
    {
    	// 1st Street Intersections
		aStAnd1stAve = new JCheckBox();
		bStAnd1stAve = new JCheckBox();
		cStAnd1stAve = new JCheckBox();
		dStAnd1stAve = new JCheckBox();
		eStAnd1stAve = new JCheckBox();
		fStAnd1stAve = new JCheckBox();
		gStAnd1stAve = new JCheckBox();
		
		checkboxes.add(aStAnd1stAve);
		checkboxes.add(bStAnd1stAve);
		checkboxes.add(cStAnd1stAve);
		checkboxes.add(dStAnd1stAve);
		checkboxes.add(eStAnd1stAve);
		checkboxes.add(fStAnd1stAve);
		checkboxes.add(gStAnd1stAve);
		
		// 2nd Street Intersections
		aStAnd2ndAve = new JCheckBox();
		bStAnd2ndAve = new JCheckBox();
		cStAnd2ndAve = new JCheckBox();
		dStAnd2ndAve = new JCheckBox();
		eStAnd2ndAve = new JCheckBox();
		fStAnd2ndAve = new JCheckBox();
		gStAnd2ndAve = new JCheckBox();
		
		checkboxes.add(aStAnd2ndAve);
		checkboxes.add(bStAnd2ndAve);
		checkboxes.add(cStAnd2ndAve);
		checkboxes.add(dStAnd2ndAve);
		checkboxes.add(eStAnd2ndAve);
		checkboxes.add(fStAnd2ndAve);
		checkboxes.add(gStAnd2ndAve);
		
		// 3rd Street Intersections
		aStAnd3rdAve = new JCheckBox();
		bStAnd3rdAve = new JCheckBox();
		cStAnd3rdAve = new JCheckBox();
		dStAnd3rdAve = new JCheckBox();
		eStAnd3rdAve = new JCheckBox();
		fStAnd3rdAve = new JCheckBox();
		gStAnd3rdAve = new JCheckBox();
		
		checkboxes.add(aStAnd3rdAve);
		checkboxes.add(bStAnd3rdAve);
		checkboxes.add(cStAnd3rdAve);
		checkboxes.add(dStAnd3rdAve);
		checkboxes.add(eStAnd3rdAve);
		checkboxes.add(fStAnd3rdAve);
		checkboxes.add(gStAnd3rdAve);
		
		// 4th Street Intersections
		aStAnd4thAve = new JCheckBox();
		bStAnd4thAve = new JCheckBox();
		cStAnd4thAve = new JCheckBox();
		dStAnd4thAve = new JCheckBox();
		eStAnd4thAve = new JCheckBox();
		fStAnd4thAve = new JCheckBox();
		gStAnd4thAve = new JCheckBox();
		
		checkboxes.add(aStAnd4thAve);
		checkboxes.add(bStAnd4thAve);
		checkboxes.add(cStAnd4thAve);
		checkboxes.add(dStAnd4thAve);
		checkboxes.add(eStAnd4thAve);
		checkboxes.add(fStAnd4thAve);
		checkboxes.add(gStAnd4thAve);
		
		// 5th Street Intersections
		aStAnd5thAve = new JCheckBox();
		bStAnd5thAve = new JCheckBox();
		cStAnd5thAve = new JCheckBox();
		dStAnd5thAve = new JCheckBox();
		eStAnd5thAve = new JCheckBox();
		fStAnd5thAve = new JCheckBox();
		gStAnd5thAve = new JCheckBox();
		
		checkboxes.add(aStAnd5thAve);
		checkboxes.add(bStAnd5thAve);
		checkboxes.add(cStAnd5thAve);
		checkboxes.add(dStAnd5thAve);
		checkboxes.add(eStAnd5thAve);
		checkboxes.add(fStAnd5thAve);
		checkboxes.add(gStAnd5thAve);
		
		// 6th Street Intersections
		aStAnd6thAve = new JCheckBox();
		bStAnd6thAve = new JCheckBox();
		cStAnd6thAve = new JCheckBox();
		dStAnd6thAve = new JCheckBox();
		eStAnd6thAve = new JCheckBox();
		fStAnd6thAve = new JCheckBox();
		gStAnd6thAve = new JCheckBox();
		
		checkboxes.add(aStAnd6thAve);
		checkboxes.add(bStAnd6thAve);
		checkboxes.add(cStAnd6thAve);
		checkboxes.add(dStAnd6thAve);
		checkboxes.add(eStAnd6thAve);
		checkboxes.add(fStAnd6thAve);
		checkboxes.add(gStAnd6thAve);
		
		// 7th Street Intersections
		aStAnd7thAve = new JCheckBox();
		bStAnd7thAve = new JCheckBox();
		cStAnd7thAve = new JCheckBox();
		dStAnd7thAve = new JCheckBox();
		eStAnd7thAve = new JCheckBox();
		fStAnd7thAve = new JCheckBox();
		gStAnd7thAve = new JCheckBox();
		
		checkboxes.add(aStAnd7thAve);
		checkboxes.add(bStAnd7thAve);
		checkboxes.add(cStAnd7thAve);
		checkboxes.add(dStAnd7thAve);
		checkboxes.add(eStAnd7thAve);
		checkboxes.add(fStAnd7thAve);
		checkboxes.add(gStAnd7thAve);
    }
    
    public void SetUpView()
    {
        /*
         *  Logo
         */
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(0, 10, 0, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		// MAP image container with check boxes at intersections
		Border line = new LineBorder(Color.BLUE, 1);
		Border margin = new EmptyBorder(0, 150, 0, 150);
		JLayeredPane mapImageContainer = new JLayeredPane();
		mapImageContainer.setLayout(new LayeredPaneLayout(mapImageContainer));
		mapImageContainer.setBorder(new CompoundBorder(margin, line));
				
			JLabel mapImage = new JLabel(new ImageIcon(acmeMap));
			mapImageContainer.add((Component)mapImage, new Integer(JLayeredPane.DEFAULT_LAYER));
		
			// JPanels with check boxes in the mapImageContainer
			JPanel checkboxesContainer = new JPanel();
			checkboxesContainer.setAlignmentX(LEFT_ALIGNMENT);
			checkboxesContainer.setPreferredSize(new Dimension(108, 555));
			checkboxesContainer.setOpaque(false);
			checkboxesContainer.setLayout(new BoxLayout(checkboxesContainer, BoxLayout.Y_AXIS));
						
				// Intersections by Street containers 
				JPanel firstStreetIntersections = new JPanel();
				firstStreetIntersections.setSize(110, 40);
				firstStreetIntersections.setOpaque(false);
				firstStreetIntersections.setLayout(new BoxLayout(firstStreetIntersections, BoxLayout.X_AXIS));
				
					// 1st Ave and A Street
					aStAnd1stAve.setToolTipText("A St and 1st Ave");
					aStAnd1stAve.setOpaque(false);
					aStAnd1stAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd1stAve.setBorder(new EmptyBorder(8, 0, 0, 0));
					firstStreetIntersections.add(aStAnd1stAve);
					
					// 1st Ave and B Street
					bStAnd1stAve.setToolTipText("B St and 1st Ave");
					bStAnd1stAve.setOpaque(false);
					bStAnd1stAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd1stAve.setBorder(new EmptyBorder(8, 85, 0, 0));
					firstStreetIntersections.add(bStAnd1stAve);
				
					// 1st Ave and C Street
					cStAnd1stAve.setToolTipText("C St and 1st Ave");
					cStAnd1stAve.setOpaque(false);
					cStAnd1stAve.setBorder(new EmptyBorder(8, 85, 0, 0));
					firstStreetIntersections.add(cStAnd1stAve);
					
					// 1st Ave and D Street
					dStAnd1stAve.setToolTipText("D St and 1st Ave");
					dStAnd1stAve.setOpaque(false);
					dStAnd1stAve.setBorder(new EmptyBorder(8, 85, 0, 0));
					firstStreetIntersections.add(dStAnd1stAve);
					
					// 1st Ave and E Street
					eStAnd1stAve.setToolTipText("E St and 1st Ave");
					eStAnd1stAve.setOpaque(false);
					eStAnd1stAve.setBorder(new EmptyBorder(8, 85, 0, 0));
					firstStreetIntersections.add(eStAnd1stAve);
					
					// 1st Ave and F Street
					fStAnd1stAve.setToolTipText("F St and 1st Ave");
					fStAnd1stAve.setOpaque(false);
					fStAnd1stAve.setBorder(new EmptyBorder(8, 85, 0, 0));
					firstStreetIntersections.add(fStAnd1stAve);
					
					// 1st Ave and G Street
					gStAnd1stAve.setToolTipText("G St and 1st Ave");
					gStAnd1stAve.setOpaque(false);
					gStAnd1stAve.setBorder(new EmptyBorder(8, 85, 0, 0));
					firstStreetIntersections.add(gStAnd1stAve);
					
				checkboxesContainer.add(firstStreetIntersections);
				
				JPanel secondStreetIntersections = new JPanel();
				secondStreetIntersections.setSize(110, 40);
				secondStreetIntersections.setOpaque(false);
				secondStreetIntersections.setLayout(new BoxLayout(secondStreetIntersections, BoxLayout.X_AXIS));
				
					// 2nd Ave and A Street
					aStAnd2ndAve.setToolTipText("A St and 2nd Ave");
					aStAnd2ndAve.setOpaque(false);
					aStAnd2ndAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd2ndAve.setBorder(new EmptyBorder(78, 0, 0, 0));
					secondStreetIntersections.add(aStAnd2ndAve);
					
					// 2nd Ave and B Street
					bStAnd2ndAve.setToolTipText("B St and 2nd Ave");
					bStAnd2ndAve.setOpaque(false);
					bStAnd2ndAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd2ndAve.setBorder(new EmptyBorder(78, 85, 0, 0));
					secondStreetIntersections.add(bStAnd2ndAve);
				
					// 2nd Ave and C Street
					cStAnd2ndAve.setToolTipText("C St and 2nd Ave");
					cStAnd2ndAve.setOpaque(false);
					cStAnd2ndAve.setBorder(new EmptyBorder(78, 85, 0, 0));
					secondStreetIntersections.add(cStAnd2ndAve);
					
					// 2nd Ave and D Street
					dStAnd2ndAve.setToolTipText("D St and 2nd Ave");
					dStAnd2ndAve.setOpaque(false);
					dStAnd2ndAve.setBorder(new EmptyBorder(78, 85, 0, 0));
					secondStreetIntersections.add(dStAnd2ndAve);
					
					// 2nd Ave and E Street
					eStAnd2ndAve.setToolTipText("E St and 2nd Ave");
					eStAnd2ndAve.setOpaque(false);
					eStAnd2ndAve.setBorder(new EmptyBorder(78, 85, 0, 0));
					secondStreetIntersections.add(eStAnd2ndAve);
					
					// 2nd Ave and F Street
					fStAnd2ndAve.setToolTipText("F St and 2nd Ave");
					fStAnd2ndAve.setOpaque(false);
					fStAnd2ndAve.setBorder(new EmptyBorder(78, 85, 0, 0));
					secondStreetIntersections.add(fStAnd2ndAve);
					
					// 2nd Ave and G Street
					gStAnd2ndAve.setToolTipText("G St and 2nd Ave");
					gStAnd2ndAve.setOpaque(false);
					gStAnd2ndAve.setBorder(new EmptyBorder(80, 85, 0, 0));
					secondStreetIntersections.add(gStAnd2ndAve);
					
				checkboxesContainer.add(secondStreetIntersections);
				
				JPanel thirdStreetIntersections = new JPanel();
				thirdStreetIntersections.setSize(110, 40);
				thirdStreetIntersections.setOpaque(false);
				thirdStreetIntersections.setLayout(new BoxLayout(thirdStreetIntersections, BoxLayout.X_AXIS));
				
					// 3rd Ave and A Street
					aStAnd3rdAve.setToolTipText("A St and 3rd Ave");
					aStAnd3rdAve.setOpaque(false);
					aStAnd3rdAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd3rdAve.setBorder(new EmptyBorder(75, 0, 0, 0));
					thirdStreetIntersections.add(aStAnd3rdAve);
					
					// 3rd Ave and B Street
					bStAnd3rdAve.setToolTipText("B St and 3rd Ave");
					bStAnd3rdAve.setOpaque(false);
					bStAnd3rdAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd3rdAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					thirdStreetIntersections.add(bStAnd3rdAve);
				
					// 3rd Ave and C Street
					cStAnd3rdAve.setToolTipText("C St and 3rd Ave");
					cStAnd3rdAve.setOpaque(false);
					cStAnd3rdAve.setBorder(new EmptyBorder(72, 85, 0, 0));
					thirdStreetIntersections.add(cStAnd3rdAve);
					
					// 3rd Ave and D Street
					dStAnd3rdAve.setToolTipText("D St and 3rd Ave");
					dStAnd3rdAve.setOpaque(false);
					dStAnd3rdAve.setBorder(new EmptyBorder(72, 85, 0, 0));
					thirdStreetIntersections.add(dStAnd3rdAve);
					
					// 3rd Ave and E Street
					eStAnd3rdAve.setToolTipText("E St and 3rd Ave");
					eStAnd3rdAve.setOpaque(false);
					eStAnd3rdAve.setBorder(new EmptyBorder(72, 85, 0, 0));
					thirdStreetIntersections.add(eStAnd3rdAve);
					
					// 3rd Ave and F Street
					fStAnd3rdAve.setToolTipText("F St and 3rd Ave");
					fStAnd3rdAve.setOpaque(false);
					fStAnd3rdAve.setBorder(new EmptyBorder(72, 85, 0, 0));
					thirdStreetIntersections.add(fStAnd3rdAve);
					
					// 3rd Ave and G Street
					gStAnd3rdAve.setToolTipText("G St and 3rd Ave");
					gStAnd3rdAve.setOpaque(false);
					gStAnd3rdAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					thirdStreetIntersections.add(gStAnd3rdAve);
					
				checkboxesContainer.add(thirdStreetIntersections);
				
				JPanel fourthStreetIntersections = new JPanel();
				fourthStreetIntersections.setSize(110, 40);
				fourthStreetIntersections.setOpaque(false);
				fourthStreetIntersections.setLayout(new BoxLayout(fourthStreetIntersections, BoxLayout.X_AXIS));
				
					// 4th Ave and A Street
					aStAnd4thAve.setToolTipText("A St and 4th Ave");
					aStAnd4thAve.setOpaque(false);
					aStAnd4thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd4thAve.setBorder(new EmptyBorder(70, 0, 0, 0));
					fourthStreetIntersections.add(aStAnd4thAve);
					
					// 4th Ave and B Street
					bStAnd4thAve.setToolTipText("B St and 4th Ave");
					bStAnd4thAve.setOpaque(false);
					bStAnd4thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd4thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					fourthStreetIntersections.add(bStAnd4thAve);
				
					// 4th Ave and C Street
					cStAnd4thAve.setToolTipText("C St and 4th Ave");
					cStAnd4thAve.setOpaque(false);
					cStAnd4thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					fourthStreetIntersections.add(cStAnd4thAve);
					
					// 4th Ave and D Street
					dStAnd4thAve.setToolTipText("D St and 4th Ave");
					dStAnd4thAve.setOpaque(false);
					dStAnd4thAve.setBorder(new EmptyBorder(68, 85, 0, 0));
					fourthStreetIntersections.add(dStAnd4thAve);
					
					// 4th Ave and E Street
					eStAnd4thAve.setToolTipText("E St and 4th Ave");
					eStAnd4thAve.setOpaque(false);
					eStAnd4thAve.setBorder(new EmptyBorder(68, 85, 0, 0));
					fourthStreetIntersections.add(eStAnd4thAve);
					
					// 4th Ave and F Street
					fStAnd4thAve.setToolTipText("F St and 4th Ave");
					fStAnd4thAve.setOpaque(false);
					fStAnd4thAve.setBorder(new EmptyBorder(68, 85, 0, 0));
					fourthStreetIntersections.add(fStAnd4thAve);
					
					// 4th Ave and G Street
					gStAnd4thAve.setToolTipText("G St and 4th Ave");
					gStAnd4thAve.setOpaque(false);
					gStAnd4thAve.setBorder(new EmptyBorder(68, 85, 0, 0));
					fourthStreetIntersections.add(gStAnd4thAve);
					
				checkboxesContainer.add(fourthStreetIntersections);
				
				JPanel fifthStreetIntersections = new JPanel();
				fifthStreetIntersections.setSize(110, 40);
				fifthStreetIntersections.setOpaque(false);
				fifthStreetIntersections.setLayout(new BoxLayout(fifthStreetIntersections, BoxLayout.X_AXIS));
				
					// 5th Ave and A Street
					aStAnd5thAve.setToolTipText("A St and 5th Ave");
					aStAnd5thAve.setOpaque(false);
					aStAnd5thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd5thAve.setBorder(new EmptyBorder(75, 0, 0, 0));
					fifthStreetIntersections.add(aStAnd5thAve);
					
					// 5th Ave and B Street
					bStAnd5thAve.setToolTipText("B St and 5th Ave");
					bStAnd5thAve.setOpaque(false);
					bStAnd5thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd5thAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					fifthStreetIntersections.add(bStAnd5thAve);
				
					// 5th Ave and C Street
					cStAnd5thAve.setToolTipText("C St and 5th Ave");
					cStAnd5thAve.setOpaque(false);
					cStAnd5thAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					fifthStreetIntersections.add(cStAnd5thAve);
					
					// 5th Ave and D Street
					dStAnd5thAve.setToolTipText("D St and 5th Ave");
					dStAnd5thAve.setOpaque(false);
					dStAnd5thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					fifthStreetIntersections.add(dStAnd5thAve);
					
					// 5th Ave and E Street
					eStAnd5thAve.setToolTipText("E St and 5th Ave");
					eStAnd5thAve.setOpaque(false);
					eStAnd5thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					fifthStreetIntersections.add(eStAnd5thAve);
					
					// 5th Ave and F Street
					fStAnd5thAve.setToolTipText("F St and 5th Ave");
					fStAnd5thAve.setOpaque(false);
					fStAnd5thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					fifthStreetIntersections.add(fStAnd5thAve);
					
					// 5th Ave and G Street
					gStAnd5thAve.setToolTipText("G St and 5th Ave");
					gStAnd5thAve.setOpaque(false);
					gStAnd5thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					fifthStreetIntersections.add(gStAnd5thAve);
					
				checkboxesContainer.add(fifthStreetIntersections);
				
				JPanel sixthStreetIntersections = new JPanel();
				sixthStreetIntersections.setSize(110, 40);
				sixthStreetIntersections.setOpaque(false);
				sixthStreetIntersections.setLayout(new BoxLayout(sixthStreetIntersections, BoxLayout.X_AXIS));
				
					// 6th Ave and A Street
					aStAnd6thAve.setToolTipText("A St and 6th Ave");
					aStAnd6thAve.setOpaque(false);
					aStAnd6thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd6thAve.setBorder(new EmptyBorder(75, 0, 0, 0));
					sixthStreetIntersections.add(aStAnd6thAve);
					
					// 6th Ave and B Street
					bStAnd6thAve.setToolTipText("B St and 6th Ave");
					bStAnd6thAve.setOpaque(false);
					bStAnd6thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd6thAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					sixthStreetIntersections.add(bStAnd6thAve);
				
					// 6th Ave and C Street
					cStAnd6thAve.setToolTipText("C St and 6th Ave");
					cStAnd6thAve.setOpaque(false);
					cStAnd6thAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					sixthStreetIntersections.add(cStAnd6thAve);
					
					// 6th Ave and D Street
					dStAnd6thAve.setToolTipText("D St and 6th Ave");
					dStAnd6thAve.setOpaque(false);
					dStAnd6thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					sixthStreetIntersections.add(dStAnd6thAve);
					
					// 6th Ave and E Street
					eStAnd6thAve.setToolTipText("E St and 6th Ave");
					eStAnd6thAve.setOpaque(false);
					eStAnd6thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					sixthStreetIntersections.add(eStAnd6thAve);
					
					// 6th Ave and F Street
					fStAnd6thAve.setToolTipText("F St and 6th Ave");
					fStAnd6thAve.setOpaque(false);
					fStAnd6thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					sixthStreetIntersections.add(fStAnd6thAve);
					
					// 6th Ave and G Street
					gStAnd6thAve.setToolTipText("G St and 6th Ave");
					gStAnd6thAve.setOpaque(false);
					gStAnd6thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					sixthStreetIntersections.add(gStAnd6thAve);
					
				checkboxesContainer.add(sixthStreetIntersections);
				
				JPanel seventhStreetIntersections = new JPanel();
				seventhStreetIntersections.setSize(110, 40);
				seventhStreetIntersections.setOpaque(false);
				seventhStreetIntersections.setLayout(new BoxLayout(seventhStreetIntersections, BoxLayout.X_AXIS));
				
					// 7th Ave and A Street
					aStAnd7thAve.setToolTipText("A St and 7th Ave");
					aStAnd7thAve.setOpaque(false);
					aStAnd7thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					aStAnd7thAve.setBorder(new EmptyBorder(75, 0, 0, 0));
					seventhStreetIntersections.add(aStAnd7thAve);
					
					// 7th Ave and B Street
					bStAnd7thAve.setToolTipText("B St and 7th Ave");
					bStAnd7thAve.setOpaque(false);
					bStAnd7thAve.setLayout(new FlowLayout(FlowLayout.LEFT));
					bStAnd7thAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					seventhStreetIntersections.add(bStAnd7thAve);
				
					// 7th Ave and C Street
					cStAnd7thAve.setToolTipText("C St and 7th Ave");
					cStAnd7thAve.setOpaque(false);
					cStAnd7thAve.setBorder(new EmptyBorder(75, 85, 0, 0));
					seventhStreetIntersections.add(cStAnd7thAve);
					
					// 7th Ave and D Street
					dStAnd7thAve.setToolTipText("D St and 7th Ave");
					dStAnd7thAve.setOpaque(false);
					dStAnd7thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					seventhStreetIntersections.add(dStAnd7thAve);
					
					// 7th Ave and E Street
					eStAnd7thAve.setToolTipText("E St and 7th Ave");
					eStAnd7thAve.setOpaque(false);
					eStAnd7thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					seventhStreetIntersections.add(eStAnd7thAve);
					
					// 7th Ave and F Street
					fStAnd7thAve.setToolTipText("F St and 7th Ave");
					fStAnd7thAve.setOpaque(false);
					fStAnd7thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					seventhStreetIntersections.add(fStAnd7thAve);
					
					// 7th Ave and G Street
					gStAnd7thAve.setToolTipText("G St and 7th Ave");
					gStAnd7thAve.setOpaque(false);
					gStAnd7thAve.setBorder(new EmptyBorder(70, 85, 0, 0));
					seventhStreetIntersections.add(gStAnd7thAve);
					
				checkboxesContainer.add(seventhStreetIntersections);
				
			mapImageContainer.add(checkboxesContainer, new Integer(JLayeredPane.DEFAULT_LAYER + 10));
					
		mainPane.add(mapImageContainer, BorderLayout.CENTER);
				
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 70));
		backButton.addActionListener(mapButtonController);
		southButtonContainer.add(backButton);
		
		// -- Save Button
		saveButton.setName("saveButton");
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(new EmptyBorder(0, 70, 0, 70));
		saveButton.addActionListener(mapButtonController);
		southButtonContainer.add(saveButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 70, 0, 0));
		logoutButton.addActionListener(mapButtonController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
    }
    
    // Save the checkbox values into the db
    public void saveCheckBoxValues()
    {
    	try
    	{
    		intersections = IntersectionsDAO.listIntersections();
    		for(int index = 0; index < checkboxes.size(); index++) 
    		{
    			if(checkboxes.get(index).isSelected())
    			{
    				
    				intersections.get(index).setIsBlocked("N");
    			}
    			else
    			{
    				intersections.get(index).setIsBlocked("Y");
    			}
    		}
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    // Load the checkbox values from the db
    public void loadCheckboxValues() 
    {
    	List<Intersections> intersections = IntersectionsDAO.listIntersections();
    	try
    	{
    		for(Intersections intersection : intersections) 
        	{
        		if(intersection.getIsBlocked().equals("Y"))
        		{
        			checkboxes.get((int) intersection.getId() - 1).setSelected(false);
        		}
        		else 
        		{
        			checkboxes.get((int) intersection.getId() - 1).setSelected(true);
        		}
        		checkboxes.get((int) intersection.getId() - 1).repaint();
        	}
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    }
}