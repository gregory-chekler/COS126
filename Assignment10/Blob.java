public class Blob {

    private int mass; // mass of blob
    private double cx;   // x coord of center of mass
    private double cy;   // y coord of center of mass


    /**
     * creates an empty blob
     */
    public Blob() {
        mass = 0;
        cx = 0;
        cy = 0;
    }

    /**
     * adds pixel with x-y coords to this blob
     *
     * @param x x-coordinate of pixel
     * @param y y-coord of pixel
     */
    public void add(int x, int y) {
        mass += 1;
        cx = cx + (x - cx) / mass; // gives new center of x coords
        cy = cy + (y - cy) / mass; // gives new center of y coords
    }


    /**
     * number of pixels added to this blob
     *
     * @return mass
     */
    public int mass() {
        return mass;
    }

    /**
     * Euclidean distance between the center of masses of the two blobs
     *
     * @param that another Blob
     * @return center of mass distance between this blob and the other blob
     */
    public double distanceTo(Blob that) {
        double px = that.cx; // CoM x-coord of that blob
        double py = that.cy; //CoM y-coord of that blob
        return Math.sqrt(Math.pow(px - cx, 2) + Math.pow(py - cy, 2));//distance
    }

    /**
     * string representation of this blob (see below)
     *
     * @return CoM coords as well as mass
     */
    public String toString() {
        return String.format("%2d (%8.4f, %8.4f)", mass, cx, cy);
    }


    /**
     * Tests this class by directly calling all instance methods
     *
     * @param args Command-line args (left blank)
     */
    public static void main(String[] args) {
        Blob b1 = new Blob();
        Blob b2 = new Blob();

        b1.add(0, 4);
        StdOut.println(b1.toString());
        b1.add(2, 4);
        StdOut.println(b1.toString());
        b1.add(4, 4);
        StdOut.println(b1.toString());

        b2.add(4, 4);
        StdOut.println(b2.toString());

        StdOut.println(b1.mass());
        StdOut.println(b1.distanceTo(b2));
    }
}
