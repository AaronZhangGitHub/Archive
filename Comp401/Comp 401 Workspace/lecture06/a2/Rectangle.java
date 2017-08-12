package a2;

public class Rectangle {

	// These are the object fields
	// that represent the bottom left and upper right
	// corners of the rectangle and the rectangle's
	// label.
	//
	// Do not change the declaration of these fields.
	// Do not add any additional fields.

	private Point bottom_left;
	private Point upper_right;	
	private String label;
	
	
	// This is the constructor for a Rectangle object.
	// It requires the x and y coordinates of two points
	// for opposite corners of the rectangle. The coordinates
	// as given may or may not be the bottom left and upper right
	// corners (you'll have to check and adjust as necessary). 
	// It also takes a String l that should be the rectangle's
	// label.
	// Complete the constructor to initialize
	// the rectangle's fields as appropriate.
	public Rectangle(int x1, int y1, int x2, int y2, String l) {
		label = l;
		int maxX = Math.max(x1, x2);
		int minX = Math.min(x1, x2);
		int maxY = Math.max(y1, y2);
		int minY = Math.min(y1, y2);
		this.upper_right = new Point(maxX,maxY);
		this.bottom_left = new Point(minX,minY);
	}
	// This method should return the label
	// for the rectangle.
	public String getLabel() {
		
		return label;
		/* Your code here. */
		
	}
	
	// This method should return the x-coordinate of the
	// rectangle's left side.
	public int getLeft() {

		/* Your code here. */
		return bottom_left.getX();
	}
	
	// This method should return the x-coordinate of the
	// rectangle's right side.
	public int getRight() {

		/* Your code here. */
		return upper_right.getX();
	}

	// This method should return the y-coordinate of the
	// rectangle's top side.
	public int getTop() {

		/* Your code here. */
		return upper_right.getY();
	}
	
	// This method should return the y-coordinate of the
	// rectangle's bottom side.
	public int getBottom() {

		/* Your code here. */
		return bottom_left.getY();
	}
	
	// This method should return the width of the rectangle.
	public int getWidth() {
		int width=0;
		width = Math.abs(getRight()-getLeft());
		return width;
	}
	
	// This method should return the height of the rectangle.
	public int getHeight() {
		int height=0;
		height = Math.abs(getTop()-getBottom());
		return height;
	}
	
	// This method should return the area of the rectangle.
	public int getArea() {
		int area=0;
		area = getHeight()*getWidth();
		return area;
	}
	
	// This method should return the perimeter of the rectangle.
	public int getPerimeter() {
		int perimeter=0;
		perimeter = 2*getWidth()+2*getHeight();
		return perimeter;
	}
	
	// This method should return a new Rectangle object
	// that is the same size as the rectangle but
	// translated by dx in the x-direction and dy in
	// the y-direction.
	
	public Rectangle translate(int dx, int dy) {

		/* Your code here. */
		int maxX = this.upper_right.getX();
		int minX = this.bottom_left.getX();
		int maxY = this.upper_right.getY();
		int minY = this.bottom_left.getY();
		maxX +=dx;
		minX +=dx;
		maxY+=dy;
		minY+=dy;
		Rectangle trans = new Rectangle(maxX,maxY,minX,minY,this.getLabel());
		return trans;
	}
	
	// This method should test the given Point p
	// for being inside the rectangle. Note that
	// a point on the edge of a rectangle is NOT inside.
	public boolean testPoint(Point p) {
		int x = p.getX();
		int y = p.getY();
		int maxX = this.upper_right.getX();
		int minX = this.bottom_left.getX();
		int maxY = this.upper_right.getY();
		int minY = this.bottom_left.getY();
		
		if((x>minX)&&(x<maxX)&&(y>minY)&&(y<maxY)){
			return true;
		}
		else
			return false;
	}
	
	// This method should test the given Rectangle r
	// for having the same geometry (i.e., same 
	// coordinates for top/bottom/left/right).
	public boolean equals(Rectangle r) {

		if((this.upper_right.getX()==r.upper_right.getX())
				&&(this.upper_right.getY()==r.upper_right.getY())
				&&(this.bottom_left.getX()==r.bottom_left.getX())
				&&(this.bottom_left.getY()==r.bottom_left.getY())){
			return true;
		}
		else
			return false;

	}
	
	// This method should test the given Rectangle r
	// for intersection with the rectangle. 
	public boolean intersects(Rectangle r) {
		int base_maxX = this.upper_right.getX();
		int base_maxY = this.upper_right.getY();
		int base_minX = this.bottom_left.getX();
		int base_minY = this.bottom_left.getY();
		
		int test_maxX = r.upper_right.getX();
		int test_maxY = r.upper_right.getY();
		int test_minX = r.bottom_left.getX();
		int test_minY = r.bottom_left.getY();
		
		if((test_maxX<=base_minX)||(test_minX>=base_maxX)){
			return false;
		}
		else if((test_maxY<=base_minY)||(test_minY>=base_maxY)){
			return false;
		}
		else
			return true;
	}
	
	// This method should test whether the 
	// rectangle is taller than it is wide.
	public boolean isTall() {

		if(getHeight()>getWidth()){
			return true;
		}
		else
			return false;
	}
	
	// This method should test whether the
	// rectangle is wider than it is tall.
	public boolean isWide() {

		if(getWidth()>getHeight()){
			return true;
		}
		else
			return false;
	}
	
	// This method should test whether the
	// rectangle is a square.
	public boolean isSquare() {

		if(getWidth()==getHeight()){
			return true;
		}
		else
			return false;
	}
}

