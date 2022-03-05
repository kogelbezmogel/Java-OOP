public abstract class Item {

	String id;
	int volume;

	Item( ) {
		this.id = null;
	}

	Item(int volume, String id) {
		this.volume = volume;
		this.id = id;
	}

	Item( Item item ) {
		this.volume = item.volume;
		this.id = item.id;
	}

	public boolean equals( Object obj ) {

		if( obj == null )
			return false;

		Item item = (Item) obj;
		if( item.getClass() != this.getClass() )
			return false;
		else 
			return this.id.equals(item.id);
	}

	public String toString() {
		return this.id + ",  volume: " + this.volume;
	}


	int getV() { return this.volume; }
	String getId() { return this.id; }
}