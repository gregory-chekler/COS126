public class Tour {

    private Node first; // first node of the circular linked list

    // Big number  used in heuristics (used the biggest num that would fit)
    private Double BIGGEST_NUMBER = 99999999999999999999999999999999999999999.9;

    /**
     * creates a node with coordinates and points to next node
     */
    private class Node {
        private Point p;
        private Node next;
    }


    /**
     * Creates an empty tour
     */
    public Tour() {
        first = new Node();
    }


    /**
     * Creates the 4-point tour a->b->c->d->a (for debugging)
     *
     * @param a a Point with x-y coordinates
     * @param b a Point with x-y coordinates
     * @param c a Point with x-y coordinates
     * @param d a Point with x-y coordinates
     */
    public Tour(Point a, Point b, Point c, Point d) {

        Node D = new Node();
        D.p = d;
        D.next = null;

        Node C = new Node();
        C.p = c;
        C.next = D;

        Node B = new Node();
        B.p = b;
        B.next = C;

        Node A = new Node();
        A.p = a;
        A.next = B;

        D.next = A; // makes list loop around

        first = A; // sets A as the first point
    }


    /**
     * Returns the number of points in this tour
     *
     * @return number of points in this tour
     */
    public int size() {
        if (first.p == null) { // if no points so far/this is first point
            return 0;
        }

        int size = 0;
        Node current = first;
        do {
            size++;
            current = current.next;
        } while (current != first);
        return size;
    }
    
    /**
     * Returns the length of this tour.
     *
     * @return length of this tour
     */
    public double length() {
        if (first.p == null) {
            return 0;
        }
        double length = 0;
        Node current = first;
        do {
            length += current.p.distanceTo(current.next.p); // dist to next pt.
            current = current.next;
        } while (current != first);
        return length;
    }


    /**
     * Returns a string representation of this tour
     *
     * @return
     */
    public String toString() {
        if (first.p == null) {
            return " ";
        }
        String string = "";
        Node current = first;
        do {
            string += current.p.toString() + "\n"; // adds point to string
            current = current.next;
        } while (current != first);
        return string;
    }


    /**
     * Draws this tour to standard drawing
     */
    public void draw() {
        Node current = first;
        do {
            if (current.p == null) {
                break;
            }
            current.p.drawTo(current.next.p);
            current = current.next;
        } while (current != first);
    }

    /**
     * Inserts a point using the nearest neighbor heuristic
     *
     * @param p the new x-y coordinate point
     */
    public void insertNearest(Point p) {
        Node x = new Node();
        x.p = p;

        if (first.p == null) {
            x.next = x; // points node to itself
            first = x; // sets node as first node
        }
        else {
            Node current = first;
            Node old; //placeholder pt. used to rearrange path after inserted pt.
            Node refer = new Node(); // reference node
            double distance;

            // used so distance always less than nearest in the beginning
            double nearest = BIGGEST_NUMBER; // the closest neighbor distance
            do {
                distance = current.p.distanceTo(x.p); // distance to new point
                if (distance < nearest) {
                    nearest = distance; // sets new distance as nearest
                    refer = current;
                }
                current = current.next;
            } while (current != first);
            old = refer.next; // saves original point pt after current
            refer.next = x; // sets inserted pt after current
            x.next = old; // makes orig pt after inserted pt
        }
    }


    /**
     * Inserts a point using the smallest increase heuristic
     *
     * @param p the new x-y coordinate point
     */
    public void insertSmallest(Point p) {
        Node x = new Node();
        x.p = p;
        if (first.p == null) {
            x.next = x;
            first = x;
        }
        else {
            Node current = first;
            Node refer = new Node(); // reference node
            double shortest = BIGGEST_NUMBER; // the smallest change in dist
            Node old; //placeholder pt. used to rearrange path after inserted pt.
            double delta; // finds out smallest change in distance
            do {
                delta = current.p.distanceTo(x.p); // distance to new point
                delta += x.p.distanceTo(current.next.p); //dist to next pt
                delta -= current.p.distanceTo(current.next.p); // old dist
                if (delta < shortest) {
                    shortest = delta;
                    refer = current;
                }
                current = current.next;
            } while (current != first);
            old = refer.next;
            refer.next = x;
            x.next = old;
        }
    }


    /**
     * Tests this class by calling all constructors and instance methods
     *
     * @param args Command-line args (left blank)
     */
    public static void main(String[] args) {

        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // create the tour a -> b -> c -> d -> a

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);
        Tour squareTour = new Tour(a, b, c, d);

        int size = squareTour.size();
        StdOut.println("# of points = " + size);

        double length = squareTour.length();
        StdOut.println("Tour length = " + length);

        StdOut.println(squareTour.toString());

        Point e = new Point(5.0, 6.0);
        Point f = new Point(2.0, 5.0);

        squareTour.insertNearest(e);
        StdOut.println(squareTour.length());
        StdOut.println(squareTour.size());
        StdOut.println(squareTour.toString());
        //squareTour.draw();


        squareTour.insertNearest(f);
        StdOut.println(squareTour.length());
        StdOut.println(squareTour.size());
        StdOut.println(squareTour.toString());
        squareTour.draw();
    }
}
