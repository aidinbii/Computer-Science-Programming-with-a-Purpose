public class RightTriangle{

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean arePositive;
        boolean areTriangle;
        arePositive = (a > 0 && b > 0 && c > 0);
        areTriangle = (a*a + b*b == c*c) || (a*a + c*c == b*b) || (b*b + c*c == a*a);
        System.out.println(arePositive && areTriangle);
    }

}
