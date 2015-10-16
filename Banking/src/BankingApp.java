import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String accountNum, accountName, type;
		double balance, amount;
		Date date = new Date();
		ArrayList<Account> myAccount = new ArrayList<Account>();

		System.out.println("Welcome to Evil Corp Savings and Loan");

		System.out.println("Please create the user account(s)");

		// Create Accounts
		accountNum = Validator.getString(keyboard,
				"Enter an account # or -1 to stop entering accounts : ");

		while (!accountNum.equals("-1")) {

			accountName = Validator.getString(keyboard,
					"Enter the name for acct #" + accountNum);
			balance = Validator.getDouble(keyboard,
					"Enter the balance for acct #" + accountNum);

			Account tempAccount = new Account(accountNum, accountName, balance);
			myAccount.add(tempAccount);
			System.out.println("\n\n");
			accountNum = Validator.getString(keyboard,
					"Enter an account # or -1 to stop entering accounts : ");

		}

		System.out.println();
		// Create Transactions
		type = Validator
				.getString(
						keyboard,
						"Enter a transaction type (Check, Debit card, Deposit or Withdrawal) or -1 to finish : ")
				.toLowerCase();

		while (!type.equals("-1")) {
			while (!Validator.validateTransactionType(type)) {
				System.out.println("Enter a valid transaction type");
				type = Validator
						.getString(
								keyboard,
								"Enter a transaction type (Check, Debit card, Deposit or Withdrawal) or -1 to finish : ")
						.toLowerCase();

			}

			accountNum = Validator.getString(keyboard, "Enter an account # ");
			amount = Validator.getDouble(keyboard,
					"Enter the amount of the check: ");
			date = Validator.getDate(keyboard, "Enter the date of the check:");

			Transcation tempTranscation = new Transcation(type, amount, date);

			for (int i = 0; i < myAccount.size(); i++) {
				if (myAccount.get(i).getAccountNum().equals(accountNum)) {
					myAccount.get(i).addTranscation(tempTranscation);
				}

			}
			System.out.println("\n\n");
			type = Validator
					.getString(
							keyboard,
							"Enter a transaction type (Check, Debit card, Deposit or Withdrawal) or -1 to finish : ")
					.toLowerCase();

		}
		// System.out.println(myAccount.get(0).calculate());
		for (int i = 0; i < myAccount.size(); i++) {
			System.out.println("\n" + myAccount.get(i).getAccountTransaction());
			System.out.print("The new balance is: " +myAccount.get(i).calculateNewBalance());
			//System.out.println(myAccount.get(i).calculateNewBalance());
			//System.out.println("\n");
		}
	}

}
