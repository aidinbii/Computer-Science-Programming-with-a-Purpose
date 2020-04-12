public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] r = new double[a.length];
        for (int i=0; i < a.length; i++)
            r[i] = alpha * a[i];
        return r;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] r = new double[a.length];
        for (int i = 0; i < a.length; i++)
            r[i] = a[a.length - i - 1];
        return r;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i];

        int j = 0;
        for (int i = a.length; i < c.length; i++) {
            c[i] = b[j];
            j++;
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        double[] s;
        if (a.length > b.length) {
            double[] p = new double[Math.abs(a.length - b.length)];
            c = merge(b, p);
            s = new double[c.length];
            for (int i = 0; i < c.length; i++)
                s[i] = a[i] + c[i];
            return s;
        }
        else if (a.length < b.length) {
            double[] p = new double[Math.abs(a.length - b.length)];
            c = merge(a, p);
            s = new double[c.length];
            for (int i = 0; i < c.length; i++)
                s[i] = b[i] + c[i];
            return s;
        }
        else {
            s = new double[a.length];
            for (int i = 0; i < a.length; i++)
                s[i] = a[i] + b[i];
            return s;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = a.length;
        int m = (int) Math.floor(n / alpha);
        double[] r = new double[m];
        for (int i=0; i < r.length; i++)
            r[i] = a[(int) Math.floor(i * alpha)];
        return r;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] a = StdAudio.read("beatbox.wav");
        double[] b = StdAudio.read("exposure.wav");
        double[] c = StdAudio.read("chimes.wav");
        // double[] d = StdAudio.read("dialup.wav");
        // double[] e = StdAudio.read("singer.wav");
        for (int i = 0; i <= 4; i++) {
            a = amplify(a, 2);
            a = reverse(a);
            a = merge(a, b);
            a = mix(a, c);
            a = changeSpeed(a, 2);
            a = amplify(a, 1/2);
            StdAudio.play(a);
        }
    }
}
