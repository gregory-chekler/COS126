/*******************************************************************************
 *
 *  This is a template file for GuitarString.java. It lists the constructors
 *  and methods you need, along with descriptions of what they're supposed
 *  to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class GuitarString {

    private final int n; // capacity
    private final RingBuffer r; // ringbuffer in GuitarString(double frequency)

    private final int SAMPLING_RATE = 44100; // sampling rate of guitar string
    private final double DECAY_FACTOR = .996; // decay factor for KS algo

    /**
     * creates a guitar string of the specified frequency,
     * using sampling rate of 44,100
     *
     * @param frequency desired fundamental frequency
     */
    public GuitarString(double frequency) {
        n = (int) Math.ceil(SAMPLING_RATE / (frequency)); // capacity
        r = new RingBuffer(n);
        for (int i = 0; i < n; i++) {
            r.enqueue(0);
        }
    }


    /**
     * creates a guitar string whose size and initial values are given by
     * the specified array (used to facilitate testing/debugging in assignment)
     *
     * @param init an array that contains number values
     */
    public GuitarString(double[] init) {
        n = init.length;
        r = new RingBuffer(n);
        for (int i = 0; i < n; i++) {
            r.enqueue(init[i]);
        }
    }


    /**
     * returns the number of samples in the ring buffer
     *
     * @return number of samples in the ring buffer
     */
    public int length() {
        return r.size();
    }


    // plucks the guitar string (by replacing the buffer with white noise)

    /**
     * plucks the guitar string (by replacing the buffer with white noise)
     */
    public void pluck() {
        for (int i = 0; i < n; i++) {
            r.dequeue(); // gets rid of oldest value
            r.enqueue(StdRandom.uniform(-0.5, 0.5)); // adds new value to buffer
        }
    }


    /**
     * advances the Karplus-Strong simulation one time step
     */
    public void tic() {
        double val = r.dequeue(); // deletes oldest value

        // Ring Buffer feedback mechanism and averages deleted and oldest val
        val = (val + r.peek()) * .5 * DECAY_FACTOR;
        r.enqueue(val); // adds new value to the buffer
    }


    /**
     * gives the current sample
     *
     * @return the current sample
     */
    public double sample() {
        return r.peek();
    }


    // tests and calls every constructor and instance method in this class

    /**
     * tests and calls every constructor and instance method in this class
     *
     * @param args Command-line args (left blank)
     */
    public static void main(String[] args) {
        double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
        GuitarString testString = new GuitarString(samples);

        int m = 25; // number of tics
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();
        }

        StdOut.println(testString.sample());
        StdOut.println(testString.length());
        testString.pluck();
        StdOut.println(testString.sample());
        StdOut.println(testString.length());

    }

}
