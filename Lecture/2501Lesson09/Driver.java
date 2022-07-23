import java.util.ArrayList;
import java.util.List;

public class Driver
{
    public static void main(final String[] args)
    {
        Mammal m = new Dog();
        Vehicle v = new Sailboat(500.0, 2022, 4);

        System.out.println(v);


        v = new Car(1500, 2000, true);



        m = new Dolphin();


        List<Mammal> mammals;
        mammals = new ArrayList<>();
        mammals.add(new Dog());
        mammals.add(new Pitbull());
        mammals.add(new Dolphin());

        for(Mammal mammal: mammals)
        {
            if(mammal instanceof Dog)
            {
                Dog myDog = (Dog)mammal;
                myDog.bark();
            }
        }



    }
}
