public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] b = new int[n];
        b[0] = 0;
        for (int i = 1; i < n; i++)
            {
            if (i % 2 != 0)
                b[i] = 1 - b[i - 1]; 
            else
                b[i] = b[i/2];
            }
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    {
                        if (b[i] == b[j])
                            System.out.print("+  ");
                        else 
                            System.out.print("-  ");
                    }
                System.out.print("\n");
            }
    }
}
