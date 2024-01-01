package bankaccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * BankAccountGUI provides a graphical user interface for users to view bank account details.
 */
public class BankAccountGUI {

    private JFrame frame;
    private JTextField accountNumberField;
    private JTextArea accountInfoArea;
    private List<Account> accounts;

    /**
     * Constructor initializes the GUI and sets up the event handling.
     * @param accounts A list of Account objects to be searched.
     */
    public BankAccountGUI(List<Account> accounts) {
        this.accounts = accounts;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblEnterAccountNumber = new JLabel("Enter Account Number:");
        lblEnterAccountNumber.setBounds(10, 11, 200, 14);

        accountNumberField = new JTextField();
        accountNumberField.setBounds(220, 8, 200, 20);
        accountNumberField.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(150, 40, 89, 23);

        accountInfoArea = new JTextArea();
        accountInfoArea.setBounds(10, 74, 414, 176);

        // Set the layout and add components
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblEnterAccountNumber);
        frame.getContentPane().add(accountNumberField);
        frame.getContentPane().add(btnSearch);
        frame.getContentPane().add(accountInfoArea);

        // Add action listener to the button
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                displayAccountInfo(accountNumber);
            }
        });
    }

    /**
     * Display the account information corresponding to the entered account number.
     * @param accountNumber The account number entered by the user.
     */
    private void displayAccountInfo(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                accountInfoArea.setText(acc.toString());
                return;
            }
        }
        accountInfoArea.setText("Account not found.");
    }

    /**
     * Make the GUI visible.
     */
    public void show() {
        frame.setVisible(true);
    }
}
