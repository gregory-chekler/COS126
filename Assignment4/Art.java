public class Art {

    /**
     * Draws a line with the upper vertex being a certain length higher than
     * the bottom vertex as well as being rotated a certain amount
     *
     * @param x      x-coordinate array of line
     * @param y      y-coordinate array of line
     * @param length length of line
     * @param theta  degrees line will be rotated around origin by
     */
    private static void line(double x, double y, double length, double theta) {
        double[] xCoords = new double[2];
        double[] yCoords = new double[2];

        //creates line coordinates
        xCoords[0] = x;
        xCoords[1] = x;
        yCoords[0] = y;
        yCoords[1] = y + length;

        //sets values line needs to be translated by before being rotated
        double xPos = xCoords[0];
        double yPos = yCoords[0];

        //rotates line about origin
        Transform2D.translate(xCoords, yCoords, -xPos, -yPos);
        Transform2D.rotate(xCoords, yCoords, theta);
        Transform2D.translate(xCoords, yCoords, xPos, yPos);

        StdDraw.line(xCoords[0], yCoords[0], xCoords[1], yCoords[1]);
    }


    /**
     * Draws an upside down pascal triangle of order <code>n</code> consisting
     * of lines that denote the value for each place in the triangle
     *
     * @param n      order of pascal triangle
     * @param x      x-coordinate array of line
     * @param y      y-coordinate array of line
     * @param length length of the line
     * @param theta  # of degrees that the line is rotated by in +/- direction
     */
    private static void pascal(int n, double x, double y, double length,
                               double theta) {
        if (n == 0) return;
        line(x, y, length, theta);
        length /= 1.15;

        /* *7 and -theta for scale/so tally marks do not overlap + more visible

        two pascal recursive functions mimic nCk by creating tally marks
         */
        pascal(n - 1, x + length * 7, y + length * 7, length, +theta);
        pascal(n - 1, x, y + length * 7, length, -theta);
    }


    /**
     * Takes in an argument that determines the n in nCk and then runs the
     * recursive function that create a pascal triangle
     *
     * @param args Command-line argument for n
     */
    public static void main(String[] args) {
        StdDraw.setScale(0, 5);
        int n = Integer.parseInt(args[0]);
        pascal(n, .07, 0, .2, n * 3);
    }
}
