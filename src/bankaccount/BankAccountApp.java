package bankaccount;

import java.util.LinkedList;
import java.util.List;

/**
 * The BankAccountApp class is the main class of the application. It reads customer information from a CSV file
 * and creates corresponding bank accounts.
 */
public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // File path for the CSV file containing new customer information
        String file = "D:\\onedrive\\OneDrive - Algonquin College\\AC\\Level2\\Project\\BankAccountApp\\src\\utilities\\001 NewBankAccounts.csv";

        // Read customer data from CSV file and create accounts
        List<String[]> newCustomers = utilities.CSV.read(file);
        for (String[] customer : newCustomers) {
            String name = customer[0];
            String sSn = customer[1];
            String accountType = customer[2];
            double initDeposit = Double.parseDouble(customer[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSn, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSn, initDeposit));
            } else {
                System.out.println("Invalid account type!");
            }
        }

        // Display account information for each created account
        for (Account acc : accounts) {
            System.out.println("\n*******************");
            acc.showInfo();
        }

        // Launch the GUI
        BankAccountGUI gui = new BankAccountGUI(accounts);
        gui.show();

        
        
    }
}
