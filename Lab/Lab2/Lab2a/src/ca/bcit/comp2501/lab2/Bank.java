package ca.bcit.comp2501.lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Chris Wu and Elijah Marquez
 * @version 1.0
 */

public class Bank {
    private final String name;

    private final Map<String, BankAccount> accounts;

    /**
     * The constructor
     *
     * @param bankName is the name of the bank
     */
    Bank(final String bankName) {
        name = bankName;
        accounts = new HashMap<>();
    }

    /**
     * @param account is the bank account
     */
    public void addAccount(final BankAccount account) {
        accounts.put(account.getAccNumber(), account);

        Set<String> accountNumber;
        accountNumber = accounts.keySet();
    }

    /**
     * @param accountNumber is the bank account number
     */
    public void removeAccount(final String accountNumber) {
        accounts.remove(accountNumber);
    }

    /**
     * @return the number of accounts
     */
    public int getNumberOfAccounts() {
        return accounts.size();
    }




}
