public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a)
    {
        int maxsize = 0;
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++)
                if (a[i-1][j-1] != 0)
                    {
                        dp[i][j] = 1 +
                            Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                                     dp[i - 1][j - 1]);
                        maxsize = Math.max(maxsize, dp[i][j]);
                    }
        return maxsize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        int[] inputStr = StdIn.readAllInts();
        int[][] a = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                {
                    a[i][j] = inputStr[k];
                    k++;
                }
        StdOut.print(size(a));
    }
}
