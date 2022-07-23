import java.util.ArrayList;
import java.util.List;

class Mammal {
    private double weightKg;
    Mammal(final double kg) {
        super();
        this.weightKg = kg;
    }
    Mammal(final String s) {
        // super();
    }
    public void move()
    {
        System.out.println("i am moving");
    }
}
class Dog extends Mammal {
    Dog(){
        super(10.2);
        System.out.println("i'm a dog!");
    }
    @Override
    public void move()
    {
        System.out.println("i am a dog and i am running");
    }

    public void bark()
    {
        System.out.println("woof woof");
    }
}
class Dolphin extends Mammal {
    Dolphin(){
        super("");
    }
    @Override
    public void move()
    {
        System.out.println("i swim");
    }
}
class Pitbull extends Dog {
    Pitbull(){
        // super();
        System.out.println("i'm a pitbull");
    }
    @Override
    public void move()
    {
        System.out.println("i run like a pitbull");
    }
}
class Main {
    public static void main(final String[] args) {

        Mammal m1 = new Mammal(1.0);
        Mammal m2 = new Dog();

        Dog d1 = (Dog)m1;

















        Dog     dog = new Dog();
        Dolphin d   = new Dolphin();
        Pitbull p   = new Pitbull();
        Mammal  m   = new Mammal("jason was here");

        List<Mammal> zoo;
        zoo = new ArrayList<>();
        zoo.add(dog);
        zoo.add(d);
        zoo.add(p);
        zoo.add(m);

        for(Mammal mam: zoo)
        {
            mam.move();
        }


    }
}
