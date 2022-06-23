public class Main
{
    public static void main(final String[] args)
    {
        for(String arg: args)
        {
            System.out.println(arg);
        }

        String s1 = "hello";
        System.out.println(Integer.toHexString(s1.hashCode()));

        s1 = "world";
        System.out.println(Integer.toHexString(s1.hashCode()));

        String s;
        s = "" + 55;
        s = "75";
        System.out.println(s.length());
    }
}
