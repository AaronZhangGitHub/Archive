package a8;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

// This new version corrects a misunderstanding of the assignment on my part.
// Edit: This THIRD version does not shuffle the pieces.
public class PuzzleFrame extends JPanel implements MouseListener, KeyListener {
	
	private int keyframeIdx;
	private SubPicture[] tiles;
	private PictureView[] tileWatchers;
	private Random rng;
	
	public PuzzleFrame(Picture picture) {
		
		// Java has a random number generating object apprarently.
		rng = new Random();
		setLayout(new GridLayout(5,5));
		
		// This panel should always receive focus and respond to key events.
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
		
		/* Imagine if these parameters could be determined variably in an intuitive manner,
		 * such that any reasonably sized picture could be substituted in the puzzle... */
		tiles = new SubPicture[25];
		tileWatchers = new PictureView[25];
		Iterator<SubPicture> tiler = picture.tile(90, 90);
		
		/* Cuts the picture into tiles of predetermined size, using the tile iterator developed
		 * in a previous assignment. */
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = tiler.next();
		}
		
		// Replaces the last tile with a solid color one.
		for (int x = 0; x < tiles[0].getWidth(); x++) {
			for (int y = 0; y < tiles[0].getHeight(); y++) {
				tiles[tiles.length-1].setPixel(x, y, new ColorPixel(0.5, 0.5, 0.5));
			}
		}
		
		// Swap the solid color tile with the tile at the top of the array.
		SubPicture hold = tiles[0];
		tiles[0] = tiles[tiles.length - 1]; tiles[tiles.length - 1] = hold;
		
		// Set up all the individual views
		for (int i = 0; i < tileWatchers.length; i++) {
			tileWatchers[i] = new PictureView(tiles[i].createObservable());
			this.add(tileWatchers[i]);
			tileWatchers[i].addMouseListener(this);
			tileWatchers[i].setFocusable(false);
		}
		
		/* My implementation relies on the fact that the solid color tile, which is dubbed
		 * the 'keyframe', will always start at the top-right corner of the puzzle. Thinking
		 * of the 5x5 grid of tiles as an array of Subpictures allows for a parallel array 
		 * approach in which the SubPicture array is manipulated by the player. After every
		 * move the changed tile order is transposed onto a static array of picture views. */
		
		keyframeIdx = 0;	// This variable tracks the keyframe's movement.
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Store the clicked PictureView using contravariant casting
		PictureView clickedPiece = (PictureView) e.getSource();
		int indexOf = 0;
		
		// Get the index of the clicked PictureView, which is also the index of the SubPicture tile.
		for(int i = 0; i < tileWatchers.length; i++) {
			if (tileWatchers[i] == clickedPiece) {
				indexOf = i;
			}
		}
		
		// Positive movements of the keyframe.
		if (indexOf > keyframeIdx) {
			
			// find the keyframe row's upper bound.
			int bind = keyframeIdx + 1;
			while(!(bind % 5 == 0)) {
				bind++;
			}
			
			// Row movement.
			if (indexOf < bind) {
				
				
				for (int i = keyframeIdx; i < indexOf; i++) {
					
					SubPicture holdPic = tiles[keyframeIdx + 1];
					tileWatchers[keyframeIdx + 1].setPicture(tiles[keyframeIdx].createObservable());	
					tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
					tiles[keyframeIdx + 1] = tiles[keyframeIdx];									
					tiles[keyframeIdx] = holdPic;
					keyframeIdx += 1;
					
				}
			
			// Column Movement.
			} else if ((indexOf - keyframeIdx) % 5 == 0) {
				
				for (int i = keyframeIdx; i < indexOf; i+=5) {
					
					SubPicture holdPic = tiles[keyframeIdx + 5];
					tileWatchers[keyframeIdx + 5].setPicture(tiles[keyframeIdx].createObservable());	
					tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
					tiles[keyframeIdx + 5] = tiles[keyframeIdx];									
					tiles[keyframeIdx] = holdPic;
					keyframeIdx += 5;
					
				}
				
			}	
		
		// Negative Movement of the keyframe.
		} else if (keyframeIdx > indexOf) {
			
			// find the keyframe row's lower bound + 1.
			int bind = keyframeIdx;
			while(!(bind % 5 == 0)) {
				bind--;
			}
			bind--;

			// Row movement.
			if (indexOf > bind) {
							
				for (int i = keyframeIdx; i > indexOf; i--) {
								
					SubPicture holdPic = tiles[keyframeIdx - 1];
					tileWatchers[keyframeIdx - 1].setPicture(tiles[keyframeIdx].createObservable());	
					tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
					tiles[keyframeIdx - 1] = tiles[keyframeIdx];									
					tiles[keyframeIdx] = holdPic;
					keyframeIdx -= 1;
								
				}
						
			// Column Movement.
			} else if ((keyframeIdx - indexOf) % 5 == 0) {
						
				for (int i = keyframeIdx; i > indexOf; i-=5) {
								
					SubPicture holdPic = tiles[keyframeIdx - 5];
					tileWatchers[keyframeIdx - 5].setPicture(tiles[keyframeIdx].createObservable());	
					tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
					tiles[keyframeIdx - 5] = tiles[keyframeIdx];									
					tiles[keyframeIdx] = holdPic;
					keyframeIdx -= 5;
								
				}
							
			}
		
		// This isn't really neccessary.
		} else {return;}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		// This the same movement logic as above, except now responding to arrow keys.
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		
			if (!(keyframeIdx == 0) && (keyframeIdx + 1) % 5 == 0) {
				return;
			}
			
			// This new bit prevents the player from going OOB, which produces an annoying console error.
			int indexOf = keyframeIdx + 1;
			if (indexOf > tiles.length) { return; }
			
			SubPicture holdPic = tiles[keyframeIdx + 1];
			tileWatchers[keyframeIdx + 1].setPicture(tiles[keyframeIdx].createObservable());	
			tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
			tiles[keyframeIdx + 1] = tiles[keyframeIdx];									
			tiles[keyframeIdx] = holdPic;
			keyframeIdx += 1;					
		
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if (!(keyframeIdx == 0) && (keyframeIdx) % 5 == 0) {
				return;
			}
			
			int indexOf = keyframeIdx - 1;
			if (indexOf < 0) { return; }
			
			SubPicture holdPic = tiles[keyframeIdx - 1];
			tileWatchers[keyframeIdx - 1].setPicture(tiles[keyframeIdx].createObservable());
			tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
			tiles[keyframeIdx - 1] = tiles[keyframeIdx];
			tiles[keyframeIdx] = holdPic;
			keyframeIdx -= 1;
		
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			int indexOf = keyframeIdx + 5;
			if (indexOf >= 25) { return; }
		
			SubPicture holdPic = tiles[keyframeIdx + 5];
			tileWatchers[keyframeIdx + 5].setPicture(tiles[keyframeIdx].createObservable());
			tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
			tiles[keyframeIdx + 5] = tiles[keyframeIdx];
			tiles[keyframeIdx] = holdPic;
			keyframeIdx += 5;
		
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		
			int indexOf = keyframeIdx - 5;
			if (indexOf < 0) { return; }
			
			SubPicture holdPic = tiles[keyframeIdx - 5];
			tileWatchers[keyframeIdx - 5].setPicture(tiles[keyframeIdx].createObservable());
			tileWatchers[keyframeIdx].setPicture(holdPic.createObservable());
			tiles[keyframeIdx - 5] = tiles[keyframeIdx];
			tiles[keyframeIdx] = holdPic;
			keyframeIdx -= 5;
		
		}
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
