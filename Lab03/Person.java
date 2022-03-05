public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private int weight;
	private int height;

	private Person() { };

	public int getAge() { return age; }

	public String toString() {

		if( lastName == null || firstName == null ) {
			return "not a person";
		}
		else {
			return this.firstName + " " + this.lastName + ", age: " + this.age + ", h: " + this.height + ", w: " + this.weight; 
		}
	}

	public boolean equals( Object obj ) {

		if( obj == null) {
			return false;
		}

		Person p = (Person) obj;
		if( this.getClass() != p.getClass() ) {
			return false;
		}
		return ( firstName.equals(p.firstName) && lastName.equals(p.lastName) && age == p.age && height == p.height && weight == p.weight );
	}


	public static final class Builder {

		private String firstName;
		private String lastName;
		private int age;
		private int weight;
		private int height;

		public Builder firstName(String name) { this.firstName = name; return this; }
		public Builder lastName(String name) { this.lastName = name; return this; }
		public Builder age(int age) { this.age = age; return this; }
		public Builder height(int height) { this.height = height; return this; }
		public Builder weight(int weight) { this.weight = weight; return this; }

		public Person build() {

			if( this.firstName == null || this.firstName.isEmpty() ) { return null; }
			else if( this.lastName == null || this.lastName.isEmpty() ) { return null; }

			Person p = new Person();
			p.firstName = this.firstName;
			p.lastName = this.lastName;
			p.age = this.age;
			p.height = this.height;
			p.weight = this.weight;

			return p;
		}
	}

}