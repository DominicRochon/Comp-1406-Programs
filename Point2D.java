public class Point2D{
	// instance attributes (state of objects)
	public double x;
	public double y;
	
	// instance methods (behanviour of objects)
	public double magnitude(){
        return Math.sqrt((x*x) + (y*y));
    }

    public double distance(Point2D other){
        return Math.sqrt(Math.pow((x - other.x),2) + Math.pow((y - other.y),2));
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}