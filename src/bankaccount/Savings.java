package bankaccount;

/**
 * The Savings class represents a savings account. It extends the Account class and includes specific properties
 * and methods related to savings accounts.
 */
public class Savings extends Account {

    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    /**
     * Constructor for the Savings account class.
     * @param name The name of the account holder.
     * @param sSn The Social Security Number of the account holder.
     * @param initDeposit The initial deposit amount for the account.
     */
    public Savings(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    /**
     * Sets the interest rate for the savings account.
     */
    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    /**
     * Sets up a safety deposit box with a randomly generated ID and key for the savings account.
     */
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    /**
     * Displays information specific to the Savings account along with the general account information.
     */
    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings Account");
        super.showInfo();
        System.out.println(
                "  YOUR SAVINGS ACCOUNT FEATURES: " +
                "\n* Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n* Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
    
    /**
     * Provides a string representation of the Savings account including specific account features.
     * @return A formatted string containing account details and savings account features.
     */
    @Override
    public String toString() {
        return "ACCOUNT TYPE: Savings Account\n" + super.toString() +
               "\n  YOUR SAVINGS ACCOUNT FEATURES: " +
               "\n* Safety Deposit Box ID: " + safetyDepositBoxID +
               "\n* Safety Deposit Box Key: " + safetyDepositBoxKey;
    }

}
