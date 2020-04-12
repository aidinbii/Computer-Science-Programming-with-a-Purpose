public class RevesPuzzle {

    // algorithm for the 3-pole Hanoi problem
    private static void hanoiPole3(int n, int k, String from, String temp, String to) {
        if (n == 0) 
            return;

        hanoiPole3(n - 1, k, from, to, temp);
        System.out.println("Move disc " + (n+k)+ " from " + from + " to " + to);
        hanoiPole3(n - 1, k, temp, from, to);
    }

    // move n smallest discs from one pole to another, using the 4 poles
    private static void hanoi(int n, String from, String temp1,
                              String temp2, String to) {
        if (n == 0)
            return;
        // if (n == 1) {
        //     System.out.println("Move disc " + n + " from " + from + " to " + to);
        //     return;
        // }
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        //System.out.println(k);
        hanoi(k, from, to, temp2, temp1);
        //System.out.println("Move disc " + k + " from " + from + " to " + to);
        hanoiPole3(n-k, k, from, temp2, to);
        hanoi(k, temp1, from, temp2, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoi(n, "A", "B", "C", "D");
    }
}
