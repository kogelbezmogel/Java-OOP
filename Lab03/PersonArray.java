import java.util.ArrayList;
import java.util.Arrays;


public class PersonArray {

	private Person[] p_arr;
	private int p_amount;

	{
		p_amount = 0;
		p_arr = new Person[p_amount];
	}

	PersonArray() {

	}

	PersonArray( PersonArray personArr ) {

	}


	public void addPerson( Person p ) {

		Person[] new_p_arr;
		var list = Arrays.asList(this.p_arr);

		if ( p == null ) {
			System.out.println("Pusta osoba");
		}
		else if ( list.contains(p) ) {
			System.out.println("Ta osoba juz wystepuje w tablicy");
		}
		else {
			++p_amount;
			new_p_arr = new Person[p_amount];
			System.arraycopy(p_arr, 0, new_p_arr, 0, p_amount-1);
			new_p_arr[ p_amount-1 ] = p;
			p_arr = new_p_arr;
		}
	}

	public void removePerson( Person p ) {

		var list = Arrays.asList(p_arr);
		int indeks;

		if( list.contains(p) ) {
			
			indeks = list.indexOf(p);
			--p_amount;
			Person[] new_p_arr = new Person[p_amount];
			System.arraycopy(p_arr, 0, new_p_arr, 0, indeks);
			System.arraycopy(p_arr, indeks + 1, new_p_arr, indeks, p_amount-indeks);
			p_arr = new_p_arr;
		}
	}

	public void sortByAge() {
		var list = Arrays.asList(p_arr);
		list.sort( (Person p1, Person p2) -> { return p1.getAge() - p2.getAge(); } );
	}

	public String toString() {
		return Arrays.deepToString(p_arr);
	}

	public boolean equals( Object obj ) {

		PersonArray parr = (PersonArray) obj;
		if(obj == null) {
			return false;
		} 
		else if( parr.getClass() != this.getClass() ){
			return false;
		}
		else {
			return Arrays.equals(parr.p_arr, this.p_arr);
		}
	}
}