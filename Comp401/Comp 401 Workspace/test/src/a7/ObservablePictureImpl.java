package a7;
/*
 * Takoda Ren
 * November 06, 2016
 */
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.fail;

import java.util.ArrayList;

public class ObservablePictureImpl 
implements ObservablePicture{
	
	private Picture source;
	
	private List<LinkedROIObserverImpl> observerRegion =
	new ArrayList<LinkedROIObserverImpl>();
	
	private List<Coordinate> changes = 
	new ArrayList<Coordinate>();
	
	private boolean state;
	
	
		    
	public ObservablePictureImpl(Picture p){
		this.source = p;
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
		Coordinate changedPix = new Coordinate(x, y);
		if(state){
			changes.add(new Coordinate(x, y));
			source.setPixel(x, y, p);
		}
		else{
			source.setPixel(x, y, p);
			for(LinkedROIObserverImpl lor : observerRegion){
				try{
					if(new RegionImpl(changedPix, changedPix).
					intersect(lor.getRegion()) != null)
						lor.notify(this, new RegionImpl
						(changedPix, changedPix).intersect(lor.getRegion()));
					
				} catch (NoIntersectionException e) {continue;}
			}
		}
	}
	
	@Override
	public void setPixel(Coordinate c, Pixel p) {
		this.setPixel(c.getX(), c.getY(), p);
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
		observerRegion.add(new LinkedROIObserverImpl(observer, r));
	}
	
	@Override
	public void unregisterROIObservers(Region r) {
		if(r == null)
			throw new IllegalArgumentException
			("Cannot complete unregister method with null region");
		List<LinkedROIObserverImpl> remove = new ArrayList<LinkedROIObserverImpl>();
		for(LinkedROIObserverImpl lro : observerRegion){
			try{
				if(lro.getRegion().intersect(r) != null)
					remove.add(lro);
			} catch(NoIntersectionException e){ }
		}
		
			observerRegion.removeAll(remove);
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
		if(observer == null)
			throw new IllegalArgumentException
			("Cannot complete unregister method with null observer");
		List<LinkedROIObserverImpl> remove = new ArrayList<LinkedROIObserverImpl>();
		for(LinkedROIObserverImpl lro : observerRegion){
			if(lro.getROIObserver() == observer)
				remove.add(lro);
		}
		
		observerRegion.removeAll(remove);
	}
	
	@Override
	public ROIObserver[] findROIObservers(Region r) {
		
		if(r == null)
			throw new IllegalArgumentException
			("Cannot complete unregister method with null region");
		
		int count = 0;
		List<LinkedROIObserverImpl> foundObservers =
			new ArrayList<LinkedROIObserverImpl>();
		
		for(LinkedROIObserverImpl lro : observerRegion){
			try{
				if(lro.getRegion().intersect(r) != null){
					count++;
					foundObservers.add(lro);
				}
			} catch(NoIntersectionException e) {continue;}
		}
		
		ROIObserver[] theReturn = new ROIObserver[count];
		for(int i = 0; i < count; i++)
			theReturn[i] = foundObservers.get(i).getROIObserver();
		
		return theReturn;
	}

	
	@Override
	public void suspendObservable() {
		state = true;
		
	}
	@Override
	public void resumeObservable() {
		Region r = new RegionImpl
		(new Coordinate(0,0), new Coordinate(0,0));
		for(int i = 0; i < changes.size(); i++)
			r.union(new RegionImpl(changes.get(i), changes.get(i)));
		
		for(LinkedROIObserverImpl lor : observerRegion){
			try{
				if(r.intersect(lor.getRegion()) != null)
					lor.notify(this, r.intersect(lor.getRegion()));
			} catch (NoIntersectionException e) {continue;}
		}
		state = false;
	}
	
	
}
