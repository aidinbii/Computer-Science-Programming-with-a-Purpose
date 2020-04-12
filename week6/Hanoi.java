public class Hanoi {

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, String from, String temp, String to) {
        if (n == 0)
            return;
        hanoi(n - 1, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoi(n, "A", "B", "C");
    }
}
