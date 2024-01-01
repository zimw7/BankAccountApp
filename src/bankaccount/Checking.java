package bankaccount;

/**
 * The Checking class represents a checking account. It extends the Account class and includes specific properties
 * and methods related to checking accounts.
 */
public class Checking extends Account {

    private int debitCardNumber;
    private int debitCardPIN;

    /**
     * Constructor for the Checking account class.
     * @param name The name of the account holder.
     * @param sSn The Social Security Number of the account holder.
     * @param initDeposit The initial deposit amount for the account.
     */
    public Checking(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    /**
     * Sets the interest rate for the checking account.
     */
    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    /**
     * Sets up a debit card with a randomly generated card number and PIN for the checking account.
     */
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    /**
     * Displays information specific to the Checking account along with the general account information.
     */
    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking Account");
        super.showInfo();
        System.out.println(
                "* Your Checking Account Features:" +
                "\n- Debit Card Number: " + debitCardNumber +
                "\n- Debit Card PIN: " + debitCardPIN
        );
    }
    
    /**
     * Provides a string representation of the Checking account including specific account features.
     * @return A formatted string containing account details and checking account features.
     */
    @Override
    public String toString() {
        return "ACCOUNT TYPE: Checking Account\n" + super.toString() +
               "\n* Your Checking Account Features:" +
               "\n- Debit Card Number: " + debitCardNumber +
               "\n- Debit Card PIN: " + debitCardPIN;
    }

}
