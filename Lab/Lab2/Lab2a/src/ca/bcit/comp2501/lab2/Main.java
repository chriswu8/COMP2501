package ca.bcit.comp2501.lab2;

/**
 * @author Chris Wu, Elijah Marquez and Se Hwan Lee
 * @version 1.0
 */

public class Main {

    /**
     * The entry point of the program
     */
    public static void main(String[] args) {

        Bank bank = new Bank("Bank of Kanada");

        BankAccount account1 = new BankAccount(100.0, "abc111", "woods");
        BankAccount account2 = new BankAccount(200.0, "def222", "gates");
        BankAccount account3 = new BankAccount(300.0, "ghi333", "bezos");
        BankAccount account4 = new BankAccount(400.0, "jkl444", "zuckerberg");

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);

        bank.depositTo(22.22, "def222");

        account1.transfer(5.00, account3);

        bank.printAllCustomerData();
    }
}
