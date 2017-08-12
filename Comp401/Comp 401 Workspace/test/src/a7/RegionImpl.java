package a7;
/*
 * Takoda Ren
 * November 06, 2016
 */
public class RegionImpl 
implements Region{
	
	private Coordinate upperLeft;
	private Coordinate lowerRight;
	
	public RegionImpl(Coordinate a, Coordinate b){
		if(a == null || b == null)
			throw new IllegalArgumentException(
			"Coordinates submitted to RegionImpl constructor are null");
		//a upper left, b lower right
		if(a.getX() <= b.getX() && a.getY() < b.getY()){
			upperLeft = a;
			lowerRight = b;
		}
		//b upper left, a lower right
		if(b.getX() <= a.getX() && b.getY() < a.getY()){
			upperLeft = b;
			lowerRight = a;
		}
		//a lower left, b upper right
		if(a.getX() < b.getX() && a.getY() >= b.getY()){
			upperLeft = new Coordinate(a.getX(), b.getY());
			lowerRight = new Coordinate(b.getX(), a.getY());
		}
		//b lower left, a upper right
		if(b.getX() < a.getX() && b.getY() >= a.getY()){
			upperLeft = new Coordinate(b.getX(), a.getY());
			lowerRight = new Coordinate(a.getX(), b.getY());
		}
		
		if(a.getX() == b.getX() && a.getY() == b.getY()){
			upperLeft = new Coordinate(a.getX(), a.getY());
			lowerRight = upperLeft;
		}
	}
	
	/*
	 * Traditional getters
	 */
	
	public Coordinate getUpperLeft(){
		return upperLeft;
	}
	
	public Coordinate getLowerRight(){
		return lowerRight;
	}
	
	/*
	 * Getters for the integers that represent
	 * the y values for "top" and "bottom" and 
	 * the x values for "left" and "right"
	 */
	
	public int getTop(){
		return upperLeft.getY();
	}
	
	public int getBottom(){
		return lowerRight.getY();
	}
	
	public int getLeft(){
		return upperLeft.getX();
	}
	
	public int getRight(){
		return lowerRight.getX();
	}
	
	/*
	 * intersect returns a region that represents
	 * the intersection of a provided region with
	 * the current region instance.
	 * 
	 * Input: Region object to find an intersection
	 * with
	 * 
	 * Output: Region object representing
	 * intersection of current region with
	 * parameter region
	 */
	public Region intersect(Region other) 
	throws NoIntersectionException{
		if(other == null)
			throw new NoIntersectionException();
		if(this.getBottom() < other.getTop() ||
		other.getBottom() < this.getTop() ||
		this.getRight() < other.getLeft() ||
		this.getLeft() > other.getRight()){
			throw new NoIntersectionException();
		}
		
		if(this.getTop() < other.getTop() &&
		this.getLeft() <= other.getLeft()){
			return new RegionImpl
			(other.getUpperLeft(), this.getLowerRight());
		}
		
		else if(this.getBottom() >= other.getBottom() &&
		this.getLeft() < other.getLeft()){
			Coordinate ul = new Coordinate
			(other.getLeft(), this.getTop());
			Coordinate lr = new Coordinate
			(this.getRight(), other.getBottom());
			return new RegionImpl(ul, lr);
		}
		
		else if(this.getBottom() > other.getBottom() &&
		this.getRight() >= other.getRight()){
			return new RegionImpl
			(this.getUpperLeft(), other.getLowerRight());
		}
		
		else if(this.getBottom() >= other.getBottom() &&
		this.getTop() <= other.getTop() &&
		this.getRight() >= other.getRight() &&
		this.getLeft() <= other.getLeft()){
			return new RegionImpl
			(other.getUpperLeft(), other.getLowerRight());
		}
		
		else if(other.getBottom() >= this.getBottom() &&
		other.getTop() <= this.getTop() &&
		other.getRight() >= this.getRight() &&
		other.getLeft() <= this.getLeft()){
			return new RegionImpl
			(this.getUpperLeft(), this.getLowerRight());
		}
		
		//Implicitly: this.getTop <= other.getTop() &&
		// this.getRight() > other.getRight()
		else{
			Coordinate ul = new Coordinate
			(this.getLeft(), other.getTop());
			Coordinate lr = new Coordinate
			(other.getRight(), this.getBottom());
			return new RegionImpl(ul, lr);
		}
	}
	
	/*
	 * Union returns the smallest possible
	 * region that encompasses both the 
	 * current region and the given region.
	 * 
	 * Input: Region object to calculate
	 * union with
	 * 
	 * Output: Region representing
	 * union of current region and
	 * given region
	 */
	public Region union(Region other){
		if(other == null)
			return this;
		Coordinate ul, lr;
		
		if(this.getTop() <= other.getTop()){
			if(this.getLeft() <= other.getLeft()){
				ul = new Coordinate
				(this.getTop(), this.getLeft());
			}
			else{
				ul = new Coordinate
				(other.getLeft(), this.getTop());
			}
		}
		else{
			if(this.getLeft() <= other.getLeft()){
				ul = new Coordinate
				(this.getLeft(), other.getTop());
			}
			else{
				ul = new Coordinate
				(other.getLeft(), other.getTop());
			}
		}
		
		if(this.getBottom() >= other.getBottom()){
			if(this.getRight() >= other.getRight()){
				lr = new Coordinate
				(this.getRight(), this.getBottom());
			}
			else{
				lr = new Coordinate
				(other.getRight(), this.getBottom());
			}
		}
		else{
			if(this.getRight() <= other.getRight()){
				lr = new Coordinate
				(other.getRight(), other.getBottom());
			}
			else{
				lr = new Coordinate
				(this.getRight(), other.getBottom());
			}
		}
		
		return new RegionImpl(ul, lr);
	}
	
	
}
