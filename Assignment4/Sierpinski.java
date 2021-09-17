public class Sierpinski {

    /**
     * Height of an equilateral triangle with specified side length
     *
     * @param length current size of a side
     * @return height of triangle
     */
    public static double height(double length) {
        double height = length * Math.sqrt(3.0) / 2;
        return height;
    }

    // Draws a filled equilateral triangle with the specified side length
    // whose bottom vertex is (x, y).

    /**
     * Draws a filled equilateral triangle with the specified side length
     *
     * @param x      x-coordinate array of triangle
     * @param y      y-coordinate array of triangle
     * @param length current size of a side
     */
    public static void filledTriangle(double x, double y, double length) {
        double[] xCoords = new double[3];
        double[] yCoords = new double[3];

        double height = height(length);

        // 0: bottom; 1: top left; 2: top right
        xCoords[0] = x;
        yCoords[0] = y;
        xCoords[1] = x - length / 2;
        yCoords[1] = y + height;
        xCoords[2] = x + length / 2;
        yCoords[2] = y + height;

        StdDraw.filledPolygon(xCoords, yCoords);
    }

    /**
     * Draws a Sierpinski triangle of order <code>n</code>, such that the
     * largest filled triangle has a specified side length and bottom vertex
     * (<code>x</code>,<code>y</code>)
     *
     * @param n      order of triangle that dictates size of triangles
     * @param x      x-coordinate array of triangle
     * @param y      y-coordinate array of triangle
     * @param length length of a triangle's side
     */
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        length /= 2;
        double height = height(length);

        //draws three smaller triangles
        sierpinski(n - 1, x + length, y, length); //right
        sierpinski(n - 1, x - length, y, length); //left
        sierpinski(n - 1, x, y + 2 * height, length); //top
    }

    /**
     * Draws a triangle and then runs a recursive function to create a
     * sierpinski triangle of a certain order
     *
     * @param args Command-line arguments for order n of sierpinski function
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        //draws triangular border
        double[] x = { 0, .5, 1 };
        double[] y = { 0, height(1), 0 };
        StdDraw.polygon(x, y);

        sierpinski(n, .5, 0, .5);
    }
}
