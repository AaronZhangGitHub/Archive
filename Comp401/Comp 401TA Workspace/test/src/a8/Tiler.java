package a8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Tile iterator form a previous assignment.
public class Tiler implements Iterator<SubPicture> {
	
	private AnyPicture source;
	private List<SubPicture> tiles = new ArrayList<SubPicture>();
	private int numTiles = 0;
	private int idx = 0;
	private int tileWidth;
	private int tileHeight;
	
	public Tiler(AnyPicture p, int tile_width, int tile_height) {
		
		if (tile_width > p.getWidth() || tile_height > p.getHeight()) {
			throw new IllegalArgumentException("Window is too large.");
		}
		
		if (tile_width < 0 || tile_height < 0) {
			throw new IllegalArgumentException("Invalid window size.");
		}
		
		this.source = p;
		this.tileHeight = tile_height;
		this.tileWidth = tile_width;
		
		for (int y = 0; y < source.getHeight(); y += tileHeight) {
			
			for (int x = 0; x < source.getWidth(); x += tileWidth) {
				
				if  (x + tileWidth > source.getWidth()) {
					continue;
				} else if (y + tileHeight > source.getHeight()) {
					break;
				} else {
					tiles.add(new SubPictureImpl((Picture) source, x, y, tileWidth, tileHeight));
					numTiles++;
				}	
			}	
		}
		
		
	}

	@Override
	public boolean hasNext() {
		
		if (idx < numTiles) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public SubPicture next() {
		
		for (int y = 0; y < source.getHeight(); y += tileHeight) {
			
			for (int x = 0; x < source.getWidth(); x += tileWidth) {
				
				if  (x + tileWidth > source.getWidth()) {
					continue;
				} else if (y + tileHeight > source.getHeight()) {
					break;
				} else {
					tiles.add(new SubPictureImpl((Picture) source, x, y, tileWidth, tileHeight));
				}	
			}	
		}
		
		if (idx >= numTiles) {
			throw new NoSuchElementException("All out");
		}
		
		SubPicture queriedSub = tiles.get(idx);
		idx++;
		return queriedSub;
		
	}

}
