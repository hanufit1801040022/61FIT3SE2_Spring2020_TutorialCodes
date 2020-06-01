package to_dos.prototype;

/* Create the ShapeDraw class which uses ShapeCache class 
to get clones of shapes stored in a Hashtable. */
public class ShapeDraw {
	// TO-DO: Implement the main() method for testing purpose
	public static void main(String[] args) {
		// run loadCache() method
		ShapeCache.loadCache();

		/*
		 * create 3 cloned shapes with 3 different types Hint: use getShape() &
		 * getType() methods
		 */
		Shape square = ShapeCache.getShape("square");
		square.draw();
		Shape circle = ShapeCache.getShape("circle");
		circle.draw();
		Shape rect = ShapeCache.getShape("rectangle");
		rect.draw();
	}
}