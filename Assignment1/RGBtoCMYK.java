public class RGBtoCMYK {
    public static void main(String[] args) {
        //define variables
        double red = Integer.parseInt(args[0]);
        double green = Integer.parseInt(args[1]);
        double blue = Integer.parseInt(args[2]);

        //compares two values, outputs largest, then compares the remaining two
        double white = Math.max(Math.max(red / 255, green / 255), blue / 255);

        //color calculations
        double cyan = (white - red / 255) / white;
        double magenta = (white - green / 255) / white;
        double yellow = (white - blue / 255) / white;
        double black = 1 - white;

        //prints out results
        System.out.println("red             = " + (red));
        System.out.println("green           = " + (green));
        System.out.println("blue            = " + (blue));
        System.out.println("cyan            = " + cyan);
        System.out.println("magenta         = " + magenta);
        System.out.println("yellow          = " + yellow);
        System.out.println("black           = " + black);
    }
}
