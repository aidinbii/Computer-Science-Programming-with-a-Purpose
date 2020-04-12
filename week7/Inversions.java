public class Inversions {
    
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long numberInversions = 0;
        for (int i = 0; i < a.length; i++) 
            for (int j = 0; j < a.length; j++) 
                if (i < j && a[i] > a[j])
                    numberInversions++;
        return numberInversions;
    }
    
    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        // Array with length 0
        if (n == 0)
            return a;

        if (k == 0) {
            for (int j = 0; j < n; j++)
                a[j] = j;
            return a;
        }

        int m = 0;
        int t = 0;
        // Use a greedy approach. If k≥n−1, put element n−1 first in the permutation, so that it is inverted with n−1 elements; otherwise put it last in the permutation, so that it is inverted with 0 elements.
        // long c = count(a);
        long c = 0; //don't need to calculate count(a). It takes n^2 time.
        for (int i = n - 1; i >= 0; i--) {
            if (c == k && k != 0) {
                m = i + 1; // position at which count(a) = k
                // System.out.print("m = " + m + " ");
                break;
            }
            if (k >= i && c <= k - i) {
                a[t] = i;
                t++;
                c = c + i;
            }
            else
                a[i + t] = i;
        }

        if (n > k)
            for (int j = 1; j <= m; j++)
                a[j] = j - 1;

        // case when n <= k
        else {
            // Finding the position q at which first 0 appears
            int q = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    q = i;
                    break;
                }
            }
            // From the first 0 increasing each following element by 1 until m
            int j = 1;
            while (j < m) {
                a[q+j] = j;
                j++;
            }
        }
        return a;
    }
    
    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] seq = generate(n, k);
        for (int i = 0; i < seq.length; i++)
            System.out.print(seq[i] + " ");
    }
}
