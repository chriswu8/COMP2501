package ca.bcit.comp2501.lab2;

/**
 * @author Chris Wu and Elijah Marquez
 * @version 2.0
 */

class BankAccount {

    private final String accNumber;
    private double balanceCad;
    private final String memberLastName;

    /**
     * @param balanceCdn     is the balance in Canadian dollars
     * @param accountNumber  is the account number
     * @param memberLastName is the member's last name
     */
    BankAccount(final double balanceCdn, final String accountNumber, final String memberLastName) {
        this.accNumber = accountNumber;
        this.balanceCad = balanceCdn;
        this.memberLastName = memberLastName;
    }

    /**
     * @param amountCdn: the amount of Canadian dollars to withdraw from this BankAccount
     */
    public void withdraw(final double amountCdn) {
        this.balanceCad -= amountCdn;
    }

    /**
     * @param amountCdn: the amount of Canadian dollars to deposit into this BankAccount
     */
    public void deposit(final double amountCdn) {
        this.balanceCad += amountCdn;
    }

    /**
     * @param amountCdn:        the amount of Canadian dollars to withdraw from this BankAccount
     *                          and deposit into the recipientAccount BankAccount
     * @param recipientAccount: the other BankAccount that is depositing amountCdn dollars
     */
    public void transfer(final double amountCdn, final BankAccount recipientAccount) {
        recipientAccount.deposit(amountCdn);
        this.withdraw(amountCdn);
    }

    /**
     * @return the current balance (in CAD) of this BankAccount
     */
    public double getBalanceCad() {
        return balanceCad;
    }

    /**
     * @param
     * @return the accNumber (account #) of this BankAcocunt
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * @return this BankAccount member's last name
     */
    public String getMemberLastName() {
        return memberLastName;
    }

}