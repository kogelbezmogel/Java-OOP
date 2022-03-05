
import java.util.ArrayList;

public class Bank {


	static double EURO = 4.6;
	static double PLN = 1.0;
	static double USD = 3.95;

	ArrayList<Account> list;

	public Bank() { list = new ArrayList<Account>(); }

	public void addAccount( Account acc ) {
		list.add(acc);
	}

	public void printAccounts() {

		for( var a : list ) {
			System.out.println(a);
		}
	}

	public Account findAccount( String number ) {
		
		for( var acc : list ) {
			if ( acc.number == Integer.valueOf(number) )
				return acc;
		}
		System.out.println("No account with given number.");
		return null;
	}

	public void transferToDifferentCurrency( String number, String curr ) {

		Account acc = findAccount(number);
			
		if( acc != null ) {
			double money = Double.valueOf( acc.getAccountBalance() );

			if( acc.getCurrency().equals("USD") ) money = money * Bank.USD;
			else if( acc.getCurrency().equals("EURO") ) money = money * Bank.EURO;

			if( curr.equals("USD") ) money = money / Bank.USD;
			else if( curr.equals("EURO") ) money = money / Bank.EURO;

			acc.setBalance( money );
			acc.setCurrency( curr );
		}
	}

	public void transfer( String num1, String num2, double money ) {

		Account acc1 = findAccount(num1);
		Account acc2 = findAccount(num2);

		if( acc1 != null && acc2 != null ) {


			String curr = acc2.getCurrency();

			acc1.setBalance( Double.valueOf(acc1.getAccountBalance()) - money );

			if( acc1.getCurrency().equals("USD") ) money = money * Bank.USD;
			else if( acc1.getCurrency().equals("EURO") ) money = money * Bank.EURO;

			if( curr.equals("USD") ) money = money / Bank.USD;
			else if( curr.equals("EURO") ) money = money / Bank.EURO;

			acc2.setBalance( Double.valueOf(acc2.getAccountBalance()) + money );
		}
	}

		public void transfer( String num1, String num2, double money, Bank bank ) {

		Account acc1 = findAccount(num1);
		Account acc2 = bank.findAccount(num2);

		if( acc1 != null && acc2 != null ) {


			String curr = acc2.getCurrency();

			acc1.setBalance( Double.valueOf(acc1.getAccountBalance()) - money );

			if( acc1.getCurrency().equals("USD") ) money = money * Bank.USD;
			else if( acc1.getCurrency().equals("EURO") ) money = money * Bank.EURO;

			if( curr.equals("USD") ) money = money / Bank.USD;
			else if( curr.equals("EURO") ) money = money / Bank.EURO;

			acc2.setBalance( Double.valueOf(acc2.getAccountBalance()) + money );
		}
	}



}