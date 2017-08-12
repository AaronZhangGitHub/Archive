package a8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PixelInspector extends JPanel implements MouseListener {

	private Picture picture;
	private PictureView picture_view;
	private JPanel side_panel;
	private Pixel loaded_pixel;
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel redLabel;
	private JLabel bluLabel;
	private JLabel greLabel;
	private JLabel briLabel;
	
	public PixelInspector(Picture picture) {
		
		setLayout(new BorderLayout());
		
		// Information panel gets vertical box layout
		side_panel = new JPanel();
		side_panel.setLayout(new GridLayout(0,1));
		
		this.picture = picture;
		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		
		add(picture_view, BorderLayout.CENTER);
		add(side_panel, BorderLayout.WEST);
		
		// Initialize variable labels
		xLabel = new JLabel("X: 0");
		yLabel = new JLabel("Y: 0");
		redLabel = new JLabel("Red: 0.00");
		bluLabel = new JLabel("Blue: 0.00");
		greLabel = new JLabel("Green: 0.00");
		briLabel = new JLabel("Brightness: 0.00");
		
		side_panel.add(xLabel);
		side_panel.add(yLabel);
		side_panel.add(redLabel);
		side_panel.add(bluLabel);
		side_panel.add(greLabel);
		side_panel.add(briLabel);
		
		// Formatting for a better UI
		Border whitespace = BorderFactory.createEmptyBorder(15, 5, 15, 20);
		xLabel.setBorder(whitespace);
		yLabel.setBorder(whitespace);
		redLabel.setBorder(whitespace);
		bluLabel.setBorder(whitespace);
		greLabel.setBorder(whitespace);
		briLabel.setBorder(whitespace);
		briLabel.setMinimumSize(new Dimension(128, 41));
		briLabel.setPreferredSize(new Dimension(128, 41));
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		
		// Just in case the PictureView is clicked out of bounds (not really important)
		if (e.getX() >= picture.getWidth() || e.getY() >= picture.getHeight()) {
			return;
		}
		
		// Ensures the double values do not exceed 2 decimal places
		DecimalFormat twoPlaces = new DecimalFormat("#.##");
		twoPlaces.setRoundingMode(RoundingMode.CEILING);
		
		// Matches clicked location to appropiate pixel
		Coordinate pixel_point = new Coordinate(e.getX(), e.getY());
		loaded_pixel = picture.getPixel(pixel_point);
		
		// Update labels accordingly.
		xLabel.setText("X: " + e.getX());
		yLabel.setText("Y: " + e.getY());
		redLabel.setText("Red: " + twoPlaces.format(loaded_pixel.getRed()));
		bluLabel.setText("Blue: " + twoPlaces.format(loaded_pixel.getBlue()));
		greLabel.setText("Green: " + twoPlaces.format(loaded_pixel.getGreen()));
		briLabel.setText("Brightness: " + twoPlaces.format(loaded_pixel.getIntensity()));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
