public class Dog extends Mammal
{
    public Dog(final int birthYear)
    {
        super(birthYear);
    }

    @Override
    public final void speak()
    {
        System.out.println("woof");
    }

    @Override
    public void move()
    {
        System.out.println("run");
    }
}
