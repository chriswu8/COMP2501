package ca.bcit.comp2501.lab1;

/**
 * @author Chris Wu and Mika Campbell Nishimura
 * @version 1.0
 */
public class Main {
    /**
     * this is the entry point of the program
     */
    public static void main(final String[] args) {
        BankAccount b1 = new BankAccount(100.00, "abc123", "gates");
        BankAccount b2 = new BankAccount(500.00, "xyz789", "woods");

        System.out.println(b1.getBalanceCad());
        b1.withdraw(5.00);
        System.out.println(b1.getAccNumber());
        System.out.println(b1.getBalanceCad());

        System.out.println("---");

        System.out.println(b2.getBalanceCad());
        b2.deposit(23.00);
        System.out.println(b2.getMemberLastName());
        System.out.println(b2.getBalanceCad());

        System.out.println("---");

        b1.transfer(50.00, b2);
        System.out.println(b1.getBalanceCad());
        System.out.println(b2.getBalanceCad());
    }
}
