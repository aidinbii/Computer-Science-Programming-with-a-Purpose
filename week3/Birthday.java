public class Birthday{

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n+2];
        double fraction = 0;
        int i = 1;
        while (fraction < 0.5){
            double sum = 0;
            System.out.print(i + "\t");

            for (int t = 0; t < trials; t++) {
                //  hasBirthday[d] = true if someone born on day d; false otherwise
                boolean[] hasBirthday = new boolean[n];
                int people = 0;
                while (true){
                    people++; // one more person enters the room
                    int d = (int) (Math.random() * n);
                    if (hasBirthday[d]){
                        if (people == i) // exactly i people enter the room,
                            count[i-1] += 1;
                        break; // found two people with the same birthday
                    }
                    hasBirthday[d] = true; // update array
                }
            }
            for (int l = 0; l < count.length; l++)
                sum += count[l];
            fraction = sum / trials;
            System.out.print(count[i-1]+ "\t");
            System.out.print(fraction);
            System.out.print("\n");
            i++;
        }
    }
}
