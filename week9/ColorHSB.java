public class ColorHSB {

    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b)
    {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        else
            {
                hue = h;
                saturation = s;
                brightness = b;        
            }
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString()
    { return "(" + hue + ", " + saturation + ", " + brightness + ")";  }

    // Is this color a shade of gray?
    public boolean isGrayscale()
    { return (saturation == 0 || brightness == 0);  }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that)
    {
        if (that == null)
            throw new IllegalArgumentException("the hue must be between 0 and 359");

        return Math.min((this.hue - that.hue) * (this.hue - that.hue), (360 - Math.abs(this.hue - that.hue)) * (360 - Math.abs(this.hue - that.hue))) +
            (this.saturation - that.saturation) * (this.saturation - that.saturation) + (this.brightness - that.brightness) * (this.brightness - that.brightness);
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB a = new ColorHSB(h, s, b);

        Integer myInf = Integer.MAX_VALUE;
        ColorHSB closestColor = a;
        String nameClosestColor = "";
        int closest = myInf;
        int d1 = 0;
        int d2 = 0;
        while (!StdIn.isEmpty())
            {
                String c = StdIn.readString(); 
                int m =  StdIn.readInt();
                int n =  StdIn.readInt();
                int p =  StdIn.readInt();
                ColorHSB z = new ColorHSB(m, n, p);
                d1 = a.distanceSquaredTo(z);
                d2 = closest;
                closest = Math.min(d2, d1);
                if (closest == d1)
                    {
                        nameClosestColor = c;
                        closestColor = z;
                    }
            }
        StdOut.println(nameClosestColor + " " + closestColor);

    }
}
