import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(final String[] args)
    {
        List<Mammal> animals;
        animals = new ArrayList<>();

        animals.add(new Dog(2013));
        animals.add(new Bat(2020));
        animals.add(new Dolphin(1999));

        for(Mammal m: animals)
        {
            m.speak();
        }
    }
}
