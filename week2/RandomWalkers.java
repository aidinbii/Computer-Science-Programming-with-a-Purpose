public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double steps = 0;
        int x;
        int y;
        for (int t = 1; t <= trials; t++)
            {
                x = 0;
                y = 0;
                int steps_t = 0;
                while (Math.abs(x) + Math.abs(y) != r)
                    {
                    steps_t += 1;
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
                steps += steps_t;
            }
        double average_steps = steps / trials;
        System.out.println("average number of steps = " + average_steps);
    }
}
