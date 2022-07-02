class BankAccount
{
    private int pin;
    private double balanceCad;
    private final String accountNumber;

    BankAccount(final int pin, final double balanceCad, final String accountNumber)
    {
        this.pin = pin;
        this.balanceCad = balanceCad;
        this.accountNumber = accountNumber;
    }


    BankAccount(final int pin, final double balanceCad, final String accountNumber, final boolean inGoodStanding)
    {
    }

    BankAccount(final int pin, final double balanceCad)
    {
        this.pin = pin;
        this.balanceCad = balanceCad;
        this.accountNumber = "abc123";
    }

    BankAccount()
    {}

    BankAccount(final int pin)
    {

    }

    BankAccount(final boolean x)
    {

    }

    BankAccount(final double balanceCad, final String accountNumber)
    {
        this.pin = 0000;
        this.balanceCad = balanceCad;
        this.accountNumber = accountNumber;
    }

    void withdraw(final int amountCad){}
    void withdraw(final double amountCad){}
    void withdraw(final int amountCad, final boolean overdraftOk){}
    void withdraw(final int a, final boolean b, final double c){}
    void withdraw(final int amountCad, final int pin){}
    void withdraw(final int amountCad, final int pin, final String authorizationCode){}
    void withdraw(final int amountCad, final int pin, final String authorizationCode, final boolean approved){}




    public static void main(final String[] args)
    {
        BankAccount b = new BankAccount(1234, 500.0, "paoisdfuioyfasd", true);
        BankAccount b2 = new BankAccount();

        b.withdraw(51, 5151, "xyz515", false);
    }
}
