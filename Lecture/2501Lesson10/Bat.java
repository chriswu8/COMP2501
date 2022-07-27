public class Bat extends Mammal
{
    public Bat(final int birthYear)
    {
        super(birthYear);
    }

    @Override
    public void speak()
    {
        super.speak();
        System.out.println("speak like a bat");
    }

    @Override
    public final void move()
    {
        System.out.println("flying");
    }
}
