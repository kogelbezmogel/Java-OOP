public class Book extends Item {

	String title;
	String author;

	public Book(int volume, String id, String author, String title) {
		super(volume, id);
		this.title = title;
		this.author = author;
	}

	public Book( Book book ) {
		super( book.getV(), book.getId() );
		this.title = book.title;
		this.author = book.author;
	}

	public boolean equals( Object obj ) {

		if( obj == null )
			return false;

		if ( obj.getClass() != this.getClass() )
			return false;
		else {
			Book book = (Book) obj;
			return ( book.getId().equals(this.getId()) && book.title.equals(this.title) );
		}
	} 

	public String toString() {
		if( this.title != null && this.author != null )
			return "Book- title: " + this.title + ",  author: " + this.author + ", " + super.toString();
		else
			return "";
	}
}