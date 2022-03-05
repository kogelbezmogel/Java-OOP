public class Laptop extends Item {

	String mark;

	public Laptop( int volume, String id, String mark ) {
		super(volume, id);
		this.mark = mark;
	}

	public Laptop( Laptop lap ) {
		super( lap.getV(), lap.getId() );
		this.mark = lap.mark;
	}

	public boolean equals( Object obj ) {

		if( obj == null )
			return false;

		if ( obj.getClass() != this.getClass() )
			return false;
		else {
			Laptop laptop = (Laptop) obj;
			return ( laptop.getId().equals(this.getId()) && laptop.mark.equals(this.mark) );
		}
	} 

	public String toString() {
		if( this.mark != null )
			return "Laptop- mark: " + this.mark + ", " + super.toString();
		else
			return "";
	}


}