  package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzleFrameWidget {

	public static void main(String[] args) throws IOException {
		
		Picture p = A8Helper.readFromURL("http://www.game-ost.com/static/covers_soundtracks/1050_122117.jpg");
		PuzzleFrame PuzzleFrameWidget = new PuzzleFrame(p);
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Puzzle Frame Game");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(PuzzleFrameWidget, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);
		
		main_frame.pack();
		main_frame.setVisible(true);

	}

}
