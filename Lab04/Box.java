import java.util.ArrayList;

public class Box extends Item {

	int capacity;
	int used_capacity;
	ArrayList<Item> list;

	public Box(int volume, String id, int capacity ) {
		super(volume, id);
		this.capacity = capacity;
		this.used_capacity = 0;
		list = new ArrayList<Item>();
	}


	public Box( Box box ) {
		super(box.volume, box.id);
		this.list = new ArrayList<Item> (box.list);
		this.used_capacity = box.used_capacity;
		this.capacity = box.capacity;
	}


	void addItem( Item item ) {

		if( item.getV() + this.used_capacity <= this.capacity ) {

			if( this.getClass() == item.getClass() ) {
				if( this.id.equals(item.id) == false ) {
					Box box = (Box) item;
					if( box.containsItem(this) == false && this.containsItem(item) == false ){
						list.add(item);
						used_capacity += item.getV();
						System.out.println("Dodalem pudelko");
					}
				}
			}
			else if( this.containsItem(item) == false ) {
				list.add(item);
				used_capacity += item.getV();
			}
		}
	}

	void removeItem( Item item ) {

		if( this.containsItem(item) == true ) {		
			if( list.remove(item) == false  ) {
				for( Item it : list ) {
					if( it.getClass() == this.getClass() )
						((Box) it).removeItem(item);
				}
			}
			this.used_capacity -= item.getV(); 
		}
	}

	boolean containsItem( Item item ) {

		for( Item i : list ) {
			if( i.equals(item) )
				return true;
		}

		for( Item i : list ) {
			if( i.getClass() == this.getClass() ) {
				if( ((Box) i).containsItem(item) == true)
					return true;
			}
		}

		return false;
	}

	public int getUsedCapacity() {
		return this.used_capacity;
	}

	public boolean equals( Object obj ) {

		if( obj == null )
			return false;

		if ( obj.getClass() == this.getClass() ) {
			Box box = (Box) obj;
			return list.equals(box.list);
		}
		else
			return false;
	} 

	public String toString() {
		
		String box = "id: " + this.id + "\n";
		for(Item i : list)
			box += " " + i.toString() + "\n";
		return box;
	}
}