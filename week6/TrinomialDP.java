public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n)
            return 0;
        else {
            long[][] t = new long[n + 1][2 * n + 3];
            int m = t[0].length;
            t[0][m / 2] = 1;
            for (int i = 1; i <= n; i++)
                for (int j = -i; j <= i; j++)
                    t[i][m / 2 + j] = t[i - 1][m / 2 + j - 1] +
                        t[i - 1][m / 2 + j] + t[i - 1][m / 2 + j + 1];
            return t[n][m / 2 + k];
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.print(trinomial(n, k));
    }
}
