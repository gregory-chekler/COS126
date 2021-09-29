/*******************************************************************************
 *
 *  This is a template file for RingBuffer.java. It lists the constructors
 *  and methods you need to implement, along with descriptions of what they're
 *  supposed to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
    private double[] rb;   // items in the buffer
    private int first;     // index for the next dequeue or peek
    private int last;      // index for the next enqueue
    private int size;      // number of items in the buffer


    /**
     * creates an empty ring buffer with the specified capacity
     *
     * @param capacity amount of space in the array
     */
    public RingBuffer(int capacity) {
        rb = new double[capacity];
        first = 0;
        last = 0;
        size = 0;
    }


    /**
     * gives the capacity of this ring buffer
     *
     * @return the capacity of this ring buffer
     */
    public int capacity() {
        return rb.length;
    }


    /**
     * gives number of items currently in this ring buffer
     *
     * @return number of items currently in this ring buffer
     */
    public int size() {
        return size;
    }

    /**
     * checks if the ring buffer is empty/has size of zero
     *
     * @return boolean
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        else return false;
    }

    /**
     * check if ring buffer is full (size equals capacity)
     *
     * @return boolean
     */
    public boolean isFull() {
        if (size() == rb.length) {
            return true;
        }
        else return false;
    }


    /**
     * adds item x to the end of this ring buffer
     *
     * @param x double value
     */
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("The RingBuffer is already full");
        }
        rb[last] = x;
        last = (last + 1) % rb.length; //increments by 1 or sets to 0
        size += 1;
    }


    /**
     * deletes and returns the item at the front of this ring buffer
     *
     * @return the deleted item
     */
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The RingBuffer is already empty");
        }
        double value = rb[first];
        first = (first + 1) % rb.length; //increments by 1 or sets to 0
        size -= 1;
        return value;
    }


    /**
     * checks what item at the front of this ring buffer
     *
     * @return the item at the front of this ring buffer
     */
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("The RingBuffer is empty");
        }
        return rb[first];
    }

    /**
     * tests and calls every instance method in this class
     *
     * @param args Command-line args (left blank)
     */
    public static void main(String[] args) {
        RingBuffer r = new RingBuffer(4);
        StdOut.println(r.capacity());
        r.enqueue(.7);
        r.enqueue(.5);
        r.enqueue(.2);
        StdOut.println(r.peek());
        r.enqueue(.6);
        StdOut.println(r.isFull());
        StdOut.println(r.size());
        double value = r.dequeue();
        StdOut.println(value);
        r.dequeue();
        r.dequeue();
        r.dequeue();
        StdOut.println(r.isEmpty());
    }

}
