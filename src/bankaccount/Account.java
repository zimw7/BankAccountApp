package bankaccount;

/**
 * The Account class is an abstract class that provides a blueprint for bank account types. 
 * It contains common properties and methods used by all accounts.
 */
public abstract class Account implements IBaseRate {

    private String name;
    private String sSn;
    private double balance;
    protected double rate;
    protected String accountNumber;
    private static int index = 10000;

    /**
     * Account constructor to initialize the account with the customer's name, Social Security Number (SSN), and initial deposit.
     * @param name The name of the account holder.
     * @param sSn The Social Security Number of the account holder.
     * @param initDeposit The initial deposit amount.
     */
    public Account(String name, String sSn, double initDeposit) {
        this.name = name;
        this.sSn = sSn;
        this.balance = this.balance + initDeposit;

        // Increment the index for unique account number and set account number
        index++;
        this.accountNumber = setAccountNumber();

        // Set the interest rate for the account
        setRate();
    }

    // Abstract method to set the interest rate, to be implemented in subclasses
    public abstract void setRate();

    // Generate a unique account number based on SSN, index, and a random number
    private String setAccountNumber() {
        String lastTwoDigitsOfSSN = sSn.substring(sSn.length() - 2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoDigitsOfSSN + uniqueID + randomNumber;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing $" + amount + ".");
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount + ".");
    }

    // Method to print the current balance
    public void printBalance() {
        System.out.println("The balance of the account is: " + balance);
    }

    // Method to transfer money from this account to another place
    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
    }

    // Method to calculate compounded interest and add it to the account balance
    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
    }

    // Method to display account information
    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
        );
    }
    
    
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
               "\nOwner: " + name +
               "\nBalance: $" + balance +
               "\nInterest Rate: " + rate + "%";
    }

    
}

