

public class Account {

	public static int NUMBER_OF_CREATED_ACCOUNTS;

	String firstName;
	String lastName;
	String currency;
	double balance;
	int number;


	public Account( String name, String lname, String curr) {
		++NUMBER_OF_CREATED_ACCOUNTS;
		this.firstName = name;
		this.lastName = lname;
		this.currency = curr;
		this.number = (int)(Math.random() * 900 + 100) + NUMBER_OF_CREATED_ACCOUNTS * 1000;
		balance = 0;
	}

	public Account( String name, String lname, double balance, String curr ) {
		++NUMBER_OF_CREATED_ACCOUNTS;
		this.firstName = name;
		this.lastName = lname;
		this.balance = balance; 
		this.currency = curr;
		this.number = (int)(Math.random() * 900 + 100) + NUMBER_OF_CREATED_ACCOUNTS * 1000;
	}

	public String getOwner() {
		return "first name: " + firstName + " , last name: " + lastName;
	}

	public String getAccountBalance() { return Double.toString(balance); }

	public String getNumber() { return Integer.toString(number); }

	public String getCurrency() { return currency; }

	public void setBalance( double balance ) { this.balance = balance; }

	public void setCurrency( String curr ) { this.currency = curr; }

	public boolean equals( Object obj ) {

		Account acc = (Account) obj;

		if( obj == null ) {
			return false;
		}
		else if( obj instanceof Account ) {
			return this.firstName.equals(acc.firstName) && this.lastName.equals(acc.lastName);
		}
		else {
			return false;
		}
	}

	public String toString() {
		return "first name: " + firstName + " , last name: " + lastName + ", balance: " + balance + " " + currency;
	}

}