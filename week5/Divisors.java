public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int c = 0;
        while (b != 0) {
            c = a;
            a = b;
            b = c % b;
        }
        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        else
            return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1)
            return true;
        else
            return false;
    }
        
    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n > 0) {
            int t = 0;
            for (int i = 1; i <= n; i++)
                t += areRelativelyPrime(n, i) ? 1 : 0;
            return t;
        }
        else
            return 0;
    }
        
    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
        public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd(" + a + ", " + b + ")" + " = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ")" + " = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ")" + " = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ")" + " = " + totient(a));
        System.out.println("totient(" + b + ")" + " = " + totient(b));
    }
}
