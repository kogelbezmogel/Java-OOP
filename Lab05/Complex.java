import java.util.Objects;


public class Complex {

	public double x;
	public double y;

	public Complex(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Complex(double x) {
		this.x = x;
		this.y = 0;
	}

	public Complex() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public boolean equals(Object obj) {

		if( obj == null )
			return false;

		if( obj.getClass() != this.getClass() )
			return false;
		else {
			Complex c = (Complex) obj;
			return this.x == c.x && this.y == c.y;
		}
	}

	public String toString() {

		if( this.x == 0 && this.y == 0 )
			return "0.0";
		
		else if( this.x == 0 )
			return this.y + "i";
		
		else if( this.y == 0 )
			return this.x + "";

		else
			return this.x + " " + this.y + "i";
	}

	public int hashCode() {

		return Objects.hash(this.x, this.y);
	}
}