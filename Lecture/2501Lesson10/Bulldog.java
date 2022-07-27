public class Bulldog extends Dog
{
    public Bulldog(final int birthYear)
    {
        super(birthYear);
    }


    @Override
    public final void move()
    {
        System.out.println("walk");
    }
}
