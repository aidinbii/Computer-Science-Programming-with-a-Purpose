public class RandomWalker {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int x = 0;
        int y = 0;
        while (Math.abs(x) + Math.abs(y) != r)
            {
                System.out.println("(" + x +", " + y + ")");
                steps += 1;
                double dice = Math.random();
                if (dice <= 0.25)
                    x += 1;
                else if (dice <= 0.5)
                    y += 1;
                else if (dice <= 0.75)
                    x -= 1;
                else if (dice <= 1.0)
                    y -= 1;
            }

        System.out.println("(" + x +", " + y + ")");
        System.out.println("steps = " + steps);
    }
}
