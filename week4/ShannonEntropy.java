public class ShannonEntropy {
    
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] x = new int[m+1]; //frequencies of input integers
        double[] p = new double[m+1]; //probabilites
        int[] inputStr = StdIn.readAllInts();
        //StdOut.println(inputStr.length);
        int i = 0;
        while (i < inputStr.length) {
            int value = inputStr[i];
            x[value]++;
            i++;
        }

        double sum = 0;
        for (int j = 1; j < x.length; j++)
            sum += x[j];
        for (int k = 1; k < x.length; k++)
            p[k] = (double) x[k] / sum;

        double entropy = 0;
        for (int k = 1; k < x.length; k++)
            if (p[k] > 0)
                entropy += -(p[k] * Math.log(p[k]) / Math.log(2));
        StdOut.printf("%.4f", entropy);
    }
}
