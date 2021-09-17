public class Transform2D {

    /**
     * Returns a new array object that is an exact copy of the given array.
     *
     * @param array x or y coords that make up certain value
     * @return copy of the original array
     */
    public static double[] copy(double[] array) {
        double[] newArray = new double[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }


    /**
     * Scales the polygon by a certain factor
     *
     * @param x     x-coordinate array
     * @param y     y-coordinate array
     * @param alpha the factor by which the array will be scaled
     */
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
    }

    /**
     * Translates the polygon a certain amount in x and y direction
     *
     * @param x  x-coordinate array
     * @param y  y-coordinate array
     * @param dx amount translates in x direction
     * @param dy amount translates in y direction
     */
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }

    /**
     * Rotates the polygon (in degrees) counterclockwise, about the origin.
     *
     * @param x     x-coordinate array
     * @param y     y-coordinate array
     * @param theta the angle (in degrees) that polygon will be rotated
     */
    public static void rotate(double[] x, double[] y, double theta) {
        theta = Math.toRadians(theta);
        double radians = 0; //the new theta after "rotated"

        for (int i = 0; i < x.length; i++) {
            double r = Math.sqrt(Math.pow(x[i], 2) + Math.pow(y[i], 2));
            if (r != 0) { //makes sure not dividing by 0
                radians = Math.asin(y[i] / r) + theta;// opposite / hypotenuse
            }
            x[i] = r * Math.cos(radians);
            y[i] = r * Math.sin(radians);
        }
    }


    /**
     * Tests each of the API methods by directly calling them
     *
     * @param args Command-line arguments (left blank)
     */
    public static void main(String[] args) {
        // Set the x- and y-scale
        StdDraw.setScale(-10.0, 10.0);

        // Create original polygon
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        // Copy original polygon
        double[] cx = copy(x);
        double[] cy = copy(y);

        // Rotate, translate, and scale the copy
        rotate(cx, cy, -45.0);
        translate(cx, cy, 1.0, 2.0);
        scale(cx, cy, 2.0);

        // Draw the copy in blue
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(cx, cy);

        // Draw the original polygon in red
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
    }
}
