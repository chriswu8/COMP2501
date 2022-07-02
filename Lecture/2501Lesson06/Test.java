public class Test
{

    public static void main(final String[] args)
    {
        String s = "hello";
        System.out.println(Integer.toHexString(s.hashCode()));
        s = "world";
        System.out.println(Integer.toHexString(s.hashCode()));

        char initial = 'j';
        char something = 'b';

        String a = "zbcit";
        String b = "zbcit";
        System.out.println(a.compareTo(b)); // negative #: a is smaller


    }
}
