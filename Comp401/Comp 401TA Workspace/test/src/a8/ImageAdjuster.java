package a8;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class ImageAdjuster extends JPanel implements ChangeListener {
	
	private Picture static_picture;
	private PictureView picture_view;
	private JPanel interactive_panel;
	private JPanel label_panel;
	private JPanel slider_panel;
	private JSlider blur_slider;
	private JSlider brightness_slider;
	private JSlider saturation_slider;
	
	public ImageAdjuster(Picture picture) {
		
		// UI stuff, nothing special going on here.
		static_picture = picture;
		picture_view = new PictureView(static_picture.createObservable());
		
		setLayout(new BorderLayout());
		interactive_panel = new JPanel();
		interactive_panel.setLayout(new BorderLayout());
		label_panel = new JPanel();
		label_panel.setLayout(new BoxLayout(label_panel, BoxLayout.Y_AXIS));
		slider_panel = new JPanel();
		slider_panel.setLayout(new BoxLayout(slider_panel, BoxLayout.Y_AXIS));
		
		add(picture_view, BorderLayout.CENTER);
		add(interactive_panel, BorderLayout.SOUTH);
		interactive_panel.add(label_panel, BorderLayout.WEST);
		interactive_panel.add(slider_panel, BorderLayout.CENTER);
		
		JLabel blur = new JLabel("Blur:");
		JLabel brightness = new JLabel("Brightness:");
		JLabel saturation = new JLabel("Saturation:");
		blur_slider = new JSlider(0, 10, 0);
		brightness_slider = new JSlider(-100, 100, 0);
		saturation_slider = new JSlider(-100, 100, 0);
		
		label_panel.add(blur);
		label_panel.add(brightness);
		label_panel.add(saturation);
		slider_panel.add(blur_slider);
		slider_panel.add(brightness_slider);
		slider_panel.add(saturation_slider);
		
		
		Dimension sliderSize = new Dimension(230, 50);
		Dimension labelSize = new Dimension(100, 20);
		Border labelspace = BorderFactory.createEmptyBorder(15, 5, 15, 20);
		Border sliderspace = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		blur.setPreferredSize(labelSize);
		blur.setBorder(labelspace);
		brightness.setPreferredSize(labelSize);
		brightness.setBorder(labelspace);
		saturation.setPreferredSize(labelSize);
		saturation.setBorder(labelspace);
		blur_slider.setPreferredSize(sliderSize);
		blur_slider.setBorder(sliderspace);
		blur_slider.setPaintTicks(true);
		blur_slider.setMajorTickSpacing(1);
		blur_slider.setPaintLabels(true);
		blur_slider.setLabelTable(blur_slider.createStandardLabels(1, 0));
		blur_slider.setSnapToTicks(true);
		brightness_slider.setPreferredSize(sliderSize);
		brightness_slider.setBorder(sliderspace);
		brightness_slider.setPaintTicks(true);
		brightness_slider.setMajorTickSpacing(25);
		brightness_slider.setPaintLabels(true);
		brightness_slider.setLabelTable(brightness_slider.createStandardLabels(25, -100));
		saturation_slider.setPreferredSize(sliderSize);
		saturation_slider.setBorder(sliderspace);
		saturation_slider.setPaintTicks(true);
		saturation_slider.setMajorTickSpacing(25);
		saturation_slider.setPaintLabels(true);
		saturation_slider.setLabelTable(saturation_slider.createStandardLabels(25, -100));
		
		
		blur_slider.addChangeListener(this);
		brightness_slider.addChangeListener(this);
		saturation_slider.addChangeListener(this);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		Picture fluid_picture = new PictureImpl(static_picture.getWidth(), static_picture.getHeight());
		
		// Reset picture by making all fluid pixels reference static pixels
		for (int x = 0; x < static_picture.getWidth(); x++) {
			for (int y = 0; y < static_picture.getHeight(); y++) {
				fluid_picture.setPixel(x, y, static_picture.getPixel(x, y));
			}	
		}
		
		// Loop through all pixels to enact changes.
		for (int x = 0; x < static_picture.getWidth(); x++) {
			for (int y = 0; y < static_picture.getHeight(); y++) {
					
				// Don't waste time on doing blur stuff if the slider is 0
				if (!(blur_slider.getValue() == 0)) {
				
					double redSum = 0.0;
					double greSum = 0.0;
					double bluSum = 0.0;	// Blur related variables.
					double redAve = 0.0;
					double greAve = 0.0;
					double bluAve = 0.0;
					int numPix = 0;
					
					// Neat helper method I cooked up to minimize lines of code.
					Region blurSquare = findRegion(x, y, blur_slider.getValue());
					for (int zx = blurSquare.getLeft(); zx < blurSquare.getRight(); zx++) {
						for (int zy = blurSquare.getTop(); zy < blurSquare.getBottom(); zy++) {
							
							redSum += static_picture.getPixel(zx, zy).getRed();
							greSum += static_picture.getPixel(zx, zy).getGreen(); 
							bluSum += static_picture.getPixel(zx, zy).getBlue();
							numPix++;
							
						}
					}
					
					redAve = (redSum)/(numPix);
					greAve = (greSum)/(numPix);
					bluAve = (bluSum)/(numPix);
					fluid_picture.setPixel(x, y, new ColorPixel(redAve, greAve, bluAve));
					
				}
				
				// Oversaturate/gray the pixel accordingly.
				fluid_picture.setPixel(x, y, saturateIt(x, y, fluid_picture));
				
				// Brighten/Darken the pixel accordingly.
				fluid_picture.setPixel(x, y, blendemLightDark(x, y, fluid_picture));

			}
		}
		
		picture_view.setPicture(fluid_picture.createObservable());	
		
	}
	
	private Region findRegion(int x, int y, int z) {
		
		/* This helper method determines the size of the rectangle around the
		 * Pixel to be blurred. Note: The while loops assure the rectangle 
		 * never exceeds the picture's boundaries.  */
		
		int topX = (x-z);
		int topY = (y-z);
		int bottomX = (x+z);
		int bottomY = (y+z);
		
		while (topX < 0) {
			topX++;
		}
		
		while (topY < 0) {
			topY++;
		}
		
		while (bottomX >= static_picture.getWidth()) {
			bottomX--;
		}
		
		while (bottomY >= static_picture.getHeight()) {
			bottomY--;
		}
		
		Coordinate topLeft = new Coordinate(topX, topY);
		Coordinate bottomRight = new Coordinate(bottomX, bottomY);
		Region pixels = new RegionImpl(topLeft, bottomRight);
		
		return pixels;
		
	}
	
	private Pixel blendemLightDark(int x, int y, Picture fluid_picture) {
		
		// If brightness is above 0, blend a weighted white pixel with current pixel.
		if (brightness_slider.getValue() > 0) {
			
			Pixel whitePixel = new ColorPixel(1.0, 1.0, 1.0);
			double adjustedValue = (brightness_slider.getValue()/100.0);
			double currentWeight = (1.0 - adjustedValue);
			
			double redBrighter = (whitePixel.getRed() * adjustedValue) + (fluid_picture.getPixel(x, y).getRed()*currentWeight);
			double greBrighter = (whitePixel.getRed() * adjustedValue) + (fluid_picture.getPixel(x, y).getGreen()*currentWeight);
			double bluBrighter = (whitePixel.getRed() * adjustedValue) + (fluid_picture.getPixel(x, y).getBlue()*currentWeight);
			
			return new ColorPixel(redBrighter, greBrighter, bluBrighter);
			
		// If brightness is below 0, blend a weighted black pixel with current pixel.	
		} else if (brightness_slider.getValue() < 0) {
			
			Pixel blackPixel = new ColorPixel(0.0, 0.0, 0.0);
			double adjustedValue = Math.abs((brightness_slider.getValue()/100.0));
			double currentWeight = (1.0 - adjustedValue);
			
			double redDarker = (blackPixel.getRed() * adjustedValue) + (fluid_picture.getPixel(x, y).getRed()*currentWeight);
			double greDarker = (blackPixel.getRed() * adjustedValue) + (fluid_picture.getPixel(x, y).getGreen()*currentWeight);
			double bluDarker = (blackPixel.getRed() * adjustedValue) + (fluid_picture.getPixel(x, y).getBlue()*currentWeight);
			
			return new ColorPixel(redDarker, greDarker, bluDarker);
			
		} else {
		
		// When slider is 0, original pixel should be returned.
		return fluid_picture.getPixel(x, y);
		
		}
		
	}
	
	private Pixel saturateIt(int x, int y, Picture fluid_picture) {
		
		// The two saturation formulas given by KMP, with slider division step done beforehand.
		if (saturation_slider.getValue() > 0) {
			
			double saturation = saturation_slider.getValue()/100.0;
			double oldRed = fluid_picture.getPixel(x, y).getRed();
			double oldGre = fluid_picture.getPixel(x, y).getGreen();
			double oldBlu = fluid_picture.getPixel(x, y).getBlue();
			
			double stepOne = oldRed > oldBlu ? oldRed : oldBlu;
			double largest = stepOne > oldGre ? stepOne : oldGre;
			
			if (largest == 0) {
				return new ColorPixel(oldRed, oldGre, oldBlu);
			}
			
			double newRed = oldRed*((largest + ((1.0 - largest)*(saturation)))/ largest);
			double newGre = oldGre*((largest + ((1.0 - largest)*(saturation)))/ largest);
			double newBlu = oldBlu*((largest + ((1.0 - largest)*(saturation)))/ largest);
			
			return new ColorPixel(newRed, newGre, newBlu);
			
		} else if (saturation_slider.getValue() < 0) {
			
			double saturation = (saturation_slider.getValue()/100.0);
			double intensity = fluid_picture.getPixel(x, y).getIntensity();
			
			double newRed = (fluid_picture.getPixel(x, y).getRed() * (1.0 + saturation)) - (saturation*intensity);
			double newGre = (fluid_picture.getPixel(x, y).getGreen() * (1.0 + saturation)) - (saturation*intensity);
			double newBlu = (fluid_picture.getPixel(x, y).getBlue() * (1.0 + saturation)) - (saturation*intensity);
			
			return new ColorPixel(newRed, newGre, newBlu);
			
		} else {
			
		// When slider is 0, original pixel should be returned.
		return fluid_picture.getPixel(x, y);
			
		}
		
	}
}