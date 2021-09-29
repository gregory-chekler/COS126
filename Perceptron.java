public class Perceptron {

    private final int n; //integer

    private final float[] weights; //contains weights of input vectors

    /**
     * Creates a perceptron with n inputs.
     *
     * @param integer number of inputs
     */
    public Perceptron(int integer) {
        n = integer;
        weights = new float[n];
        for (int i = 0; i < n; i++) {
            weights[i] = 0;
        }
    }

    /**
     * Counts number of inputs n
     *
     * @return number of inputs
     */
    public int numberOfInputs() {
        return n;
    }

    /**
     * sums the weight vector and input vector in regards to their placements
     * in their respective arrays (x1 goes with w1)
     *
     * @param x input vector array
     * @return the weighted sum of the weight vector and input vector
     */
    public double weightedSum(double[] x) {
        float sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += weights[i] * x[i]; //S = x1 * w1 + x2 * w2 + ...
        }
        return sum;
    }


    /**
     * Predicts the label (+1 or -1) of input vector
     *
     * @param x input vector array
     * @return either 1 or -1
     */
    public int predict(double[] x) {
        if (weightedSum(x) > 0) return 1;
        else return -1;
    }

    /**
     * Trains this perceptron on the labeled (+1 or -1) input x
     *
     * @param x     input vector array
     * @param label either 1 or -1 which trains perceptron
     */
    public void train(double[] x, int label) {
        int prediction = predict(x);

        //false neg
        if ((label == 1) && (prediction == -1)) {
            for (int i = 0; i < x.length; i++) {
                weights[i] += x[i]; // wj'=wj+ xj
            }
        }
        //false pos
        if ((label == -1) && (prediction == 1)) {
            for (int i = 0; i < x.length; i++) {
                weights[i] -= x[i]; // wj'=wj-xj
            }
        }
    }

    /**
     * creates a string representation of this perceptron
     *
     * @return a string representation of this perceptron
     */
    public String toString() {
        String vector = new String("(" + weights[0]);
        for (int i = 1; i < weights.length; i++) {
            vector += ", " + Float.toString(weights[i]);
        }
        vector += ")";
        return vector;
    }

    /**
     * Tests this class by directly calling instance methods
     *
     * @param args Command-Line arguments (left blank)
     */
    public static void main(String[] args) {
        int n = 3;

        double[] training1 = { 5.0, -4.0, 3.0 };  // yes
        double[] training2 = { 2.0, 3.0, -2.0 };  // no
        double[] training3 = { 4.0, 3.0, 2.0 };  // yes
        double[] training4 = { -6.0, -5.0, 7.0 };  // no

        StdOut.println();
        Perceptron perceptron = new Perceptron(n);
        StdOut.println(perceptron);
        perceptron.train(training1, +1);
        StdOut.println(perceptron);
        perceptron.train(training2, -1);
        StdOut.println(perceptron);
        perceptron.train(training3, +1);
        StdOut.println(perceptron);
        perceptron.train(training4, -1);
        StdOut.println(perceptron);

        StdOut.println(perceptron.numberOfInputs());
        StdOut.println(perceptron.weightedSum(training1));
        StdOut.println(perceptron.predict(training1));
        StdOut.println(perceptron.toString());
    }
}
