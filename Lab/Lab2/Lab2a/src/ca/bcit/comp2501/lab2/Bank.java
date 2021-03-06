package ca.bcit.comp2501.lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Chris Wu, Elijah Marquez and Se Hwan Lee
 * @version 1.0
 */
public class Bank
{
    private final String                   name;
    private final Map<String, BankAccount> accounts;
    private double                         totalCdn;
    private final Set<String>              keys;

    /**
     * The constructor
     *
     * @param bankName is the name of the bank
     */
    Bank(final String bankName)
    {
        name     = bankName;
        accounts = new HashMap<>();
        keys     = accounts.keySet();
    }

    /**
     * @param account is the bank account
     */
    public void addAccount(final BankAccount account)
    {
        accounts.put(account.getAccNumber(), account);
    }

    /**
     * @param accountNumber is the bank account number
     */
    public void removeAccount(final String accountNumber)
    {
        accounts.remove(accountNumber);
    }

    /**
     * @return the number of accounts
     */
    public int getNumberOfAccounts()
    {
        return accounts.size();
    }

    /**
     * @return totalCdn is the total balance of all the accounts
     */
    public double getTotalAccountBalance()
    {
        for (String key : keys)
        {
            totalCdn += accounts.get(key).getBalanceCad();
        }
        return totalCdn;
    }

    /**
     * @param amountCdn  is the amount of Canadian dollars to be deposited
     * @param key is the account number that specifies the bank account that is to receive the deposit
     */
    public void depositTo(double amountCdn,
                          String key)
    {
        accounts.get(key).deposit(amountCdn);
    }

    /**
     * Prints all customer data and total balance in all accounts
     */
    public void printAllCustomerData()
    {

        for (String key : keys)
        {
            double balance;
            balance              = accounts.get(key).getBalanceCad();
            String BalanceString = String.format("%.02f", balance);

            System.out.println("Customer "
                    + accounts.get(key).getMemberLastName()
                    + " has $"
                    + BalanceString
                    + " in account #"
                    + accounts.get(key).getAccNumber());
        }

        double          TotalBalance;
        TotalBalance  = getTotalAccountBalance();
        String          BalanceString;
        BalanceString = String.format("%.02f", TotalBalance);

        System.out.println("Total bank balance in all accounts for "
                + name
                + " is "
                + BalanceString);
    }
}
