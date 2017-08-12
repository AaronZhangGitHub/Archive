package a7;
/*
 * Takoda Ren
 * November 06, 2016
 */
import java.util.Map;
import java.util.Iterator;
public class ObservablePictureImplTest 
implements ObservablePicture{
	
	private Picture source;
	private Map<Region, ROIObserver> observers;
	
	public ObservablePictureImplTest(Picture p){
		this.source = p;
		ROIObserver i = new 
	}
	
	/*
	 * Traditional getters
	 */
	@Override
	public int getWidth() {
		return source.getWidth();
	}
	
	@Override
	public int getHeight() {
		return source.getHeight();
	}
	
	/*
	 * Non traditional getters
	 */
	
	@Override
	public Pixel getPixel(int x, int y) {
		return source.getPixel(x, y);
	}
	
	@Override
	public Pixel getPixel(Coordinate c) {
		return source.getPixel(c);
	}
	/*
	 * Non traditional setters
	 */
	
	@Override
	public void setPixel(int x, int y, Pixel p) {
		source.setPixel(x, y, p);
	}
	
	@Override
	public void setPixel(Coordinate c, Pixel p) {
		source.setPixel(c, p);
	}
	
	/*
	 * Other methods
	 */
	
	@Override
	public SubPicture extract(int xoff, int yoff, int width, int height) {
		return source.extract(xoff, yoff, width, height);
	}
	
	@Override
	public SubPicture extract(Coordinate a, Coordinate b) {
		return source.extract(a, b);
	}
	
	
	
	@Override
	public void registerROIObserver(ROIObserver observer, Region r) {
		observers.put(r, observer);
	}
	
	@Override
	public void unregisterROIObservers(Region r) {
		observers.remove(r);
		/*
		 * for(ROIObserver key : observers.keySet()){
			if(regionEquals(observers.get(key), r))
				observers.remove(key, r);
		}
		 */
	}
	
	/*
	 * Helper method that determines 
	 * whether two regions are equal
	 * to one another
	 * 
	 * Input: Two regions to compare
	 * for equality
	 * 
	 * Output: Boolean true or false
	 */
	/*
	private Boolean regionEquals(Region r1, Region r2){
		if(r1.getBottom() == r2.getBottom() &&
			r1.getLeft() == r2.getLeft() &&
			r1.getRight() == r2.getRight() &&
			r1.getTop() == r2.getTop())
			return true;
		else
			return false;
	}
	*/
	
	@Override
	public void unregisterROIObserver(ROIObserver observer) {
		observers.remove(observer);
		for(Region key : observers.keySet()){
			if(regionEquals(observers.get(key), r))
				count++
		}
	}
	
	@Override
	public ROIObserver[] findROIObservers(Region r) {
		int count = 0;
		for(ROIObserver key : observers.keySet()){
			if(regionEquals(observers.get(key), r))
				count++
		}	
		ROIObserver[] r = new ROIObserver[count];
		count = 0;
		for(ROIObserver key : observers.keySet()){
			if(regionEquals(observers.get(key), r)){
				r[count] = 
			}
		}	
	}

	
	@Override
	public void suspendObservable() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resumeObservable() {
		// TODO Auto-generated method stub
		
	}
	
	
}
