import java.awt.Color;

public class KernelFilter {

    // truncate color component to be between 0 and 255
    private static int truncate(int a)
    {
        if      (a <   0) return 0;
        else if (a > 255) return 255;
        else              return a;
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights)
    {
        int width = picture.width();
        int height = picture.height();       
        Picture filteredPicture = new Picture(width, height); // create a blank w-by-h picture

        int d = weights.length / 2; // range of shift in the kernel
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                {
                    // apply filter and account periodic boundary conditions
                    int r = 0, g = 0, b = 0;
                    for (int i = -d; i <= d; i++) 
                        for (int j = -d; j <= d; j++)
                            {
                                r += (int)Math.round((double)(picture.get((width + x + j) % width, (height + y + i) % height).getRed()) * (weights[d + i][d + j]));
                                g += (int)Math.round((double)(picture.get((width + x + j) % width, (height + y + i) % height).getGreen()) * (weights[d + i][d + j]));
                                b += (int)Math.round((double)(picture.get((width + x + j) % width, (height + y + i) % height).getBlue()) * (weights[d + i][d + j]));
                            }

                    Color cNew = new Color(truncate(r), truncate(g), truncate(b));
                    filteredPicture.set(x, y, cNew);
                }
        return filteredPicture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture)
    {
        double[][] filter = {
            {(double) 1/16,  (double)2/16,  (double)1/16 },
            { (double)2/16,  (double)4/16,  (double)2/16 },
            { (double)1/16,  (double)2/16,  (double)1/16 }
        };
        Picture newPicture = kernel(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture)
    {
        double[][] filter = {
            { 0,  -1,  0 },
            { -1,  5,  -1 },
            { 0,  -1,  0 }
        };
        Picture newPicture = kernel(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture)
    {
        double[][] filter = {
            { -1,  -1,  -1 },
            { -1,  8,  -1 },
            { -1,  -1,  -1 }
        };

        Picture newPicture = kernel(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture)
    {
        double[][] filter = {
            { -2,  -1,  0 },
            { -1,  1,  1 },
            { 0,  1,  2 }
        };    
        Picture newPicture = kernel(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture)
    {
        double[][] filter = {
            {(double) 1/9,  0,  0, 0,0,  0, 0,0,  0 },
            { 0,  (double) 1/9,  0, 0,0,  0, 0,0,  0 },
            {0,  0,  (double) 1/9, 0,0,  0, 0,0,  0 },
            {0,  0,  0, (double) 1/9,0,  0, 0,0,  0 },
            {0,  0,  0, 0,(double) 1/9,  0, 0,0,  0 },
            {0,  0,  0, 0,0,  (double) 1/9, 0,0,  0 },
            {0,  0,  0, 0,0,  0, (double) 1/9,0,  0 },
            {0,  0,  0, 0,0,  0, 0,(double) 1/9,  0 },
            {0,  0,  0, 0,0,  0, 0,0,  (double) 1/9 },
        };    
        Picture newPicture = kernel(picture, filter);
        return newPicture;
    }

// Test client (ungraded).
    public static void main(String[] args)
    {
        Picture picture = new Picture(args[0]);
        Picture newPicture = gaussian(picture);
        newPicture.show();
    }

}
