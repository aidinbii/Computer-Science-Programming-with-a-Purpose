public class DiscreteDistribution {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int Si = 0;
        int[] S = new int[n+1];
        S[0] = 0;
        for (int i = 1; i <= n; i++)
            {
                Si += Integer.parseInt(args[i]);
                S[i] = Si;
            }
        for (int j = 1; j <= m; j++)
            {
                double r = Math.random() * S[n];
                for (int i = 0; i < n; i++)
                    if (S[i] <= r && r < S[i+1])
                        System.out.print(i+1 + " ");
            }
    }
}
