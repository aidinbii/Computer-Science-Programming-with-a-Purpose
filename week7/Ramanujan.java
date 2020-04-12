public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n)
    {
        long a = 0;
        long b = 0;
        long d = 0;
        long z = (long)Math.cbrt(n);
        for (long i = 1; i < z; i++)
            {
                b = (long)Math.cbrt(n - i * i * i);
                if ((i*i*i + b*b*b) == n && i != b)
                    {
                        a = i;
                        // System.out.println("a= " + a);
                        break;
                    }
            }
        for (long j = a + 1; j < z; j++)
            {
                d = (long)Math.cbrt(n - j * j * j);
                if ((j*j*j + d*d*d) == n && j != b && j != d)
                    return true;
            }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args)
    {
        long n = Long.parseLong(args[0]);
        System.out.print(isRamanujan(n));
    }
}
