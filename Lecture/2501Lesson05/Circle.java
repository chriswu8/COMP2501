public class Circle
{
    private static final double PI = 3.14159;
    private String color;

    public double getPi()
    {
        return PI;
    }

    public static void setPi(final double newPiValue)
    {
        //pi = newPiValue;
    }

    public static double getArea(final int radius)
    {
        return PI * Math.pow(radius, 2);
    }
}
