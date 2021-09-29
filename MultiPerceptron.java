public class MultiPerceptron {

    private final int m; //number of classes
    private final int n; //length of input feature vector
    private final Perceptron[] objects; //contains perceptrons in array


    /**
     * Creates a multi-perceptron object with m classes and n inputs.
     *
     * @param classes number of classes
     * @param length  number of inputs
     */
    public MultiPerceptron(int classes, int length) {
        m = classes;
        n = length;
        objects = new Perceptron[m];
        for (int i = 0; i < m; i++) {
            objects[i] = new Perceptron(n);
        }
    }


    /**
     * gives the number of classes m
     *
     * @return Returns the number of classes m.
     */
    public int numberOfClasses() {
        return m;
    }

    /**
     * gives the number of inputs n (length of the feature vector)
     *
     * @return Returns the number of inputs n (length of the feature vector)
     */
    public int numberOfInputs() {
        return objects[0].numberOfInputs(); //all perceptrons have same length
    }

    // Returns the predicted label (between 0 and m-1) for the given input.
    public int predictMulti(double[] x) {
        double[] sums = new double[objects.length];
        int largest = 0;
        for (int i = 0; i < objects.length; i++) {
            sums[i] = objects[i].weightedSum(x);
            if (sums[i] > sums[largest]) {
                largest = i;
            }
        }
        return largest;
    }


    /**
     * Trains this multi-perceptron on the labeled (between 0 and m-1) input.
     *
     * @param x     input vector array
     * @param label the image that it wants to train perceptron with
     */
    public void trainMulti(double[] x, int label) {
        for (int i = 0; i < objects.length; i++) {
            if (label == i) {
                objects[i].train(x, +1); //trained for label
            }
            else objects[i].train(x, -1); //all other objects trained against
        }
    }


    /**
     * creates a string representation of this MultiPerceptron
     *
     * @return a string representation of this MultiPerceptron
     */
    public String toString() {
        String vector = new String("(" + objects[0]);
        for (int i = 1; i < objects.length; i++) {
            vector += ", " + objects[i];
        }
        vector += ")";
        return vector;
    }


    /**
     * Tests this class by directly calling instance methods
     *
     * @param args Command-line args (left blank)
     */
    public static void main(String[] args) {
        int m = 2;
        int n = 3;

        double[] training1 = { 5.0, -4.0, 3.0 };  // class 1
        double[] training2 = { 2.0, 3.0, -2.0 };  // class 0
        double[] training3 = { 4.0, 3.0, 2.0 };  // class 1
        double[] training4 = { -6.0, -5.0, 7.0 };  // class 0


        MultiPerceptron perceptron = new MultiPerceptron(m, n);
        StdOut.println(perceptron);
        perceptron.trainMulti(training1, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training2, 0);
        StdOut.println(perceptron);
        perceptron.trainMulti(training3, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training4, 0);
        StdOut.println(perceptron);

        StdOut.println(perceptron.numberOfClasses());
        StdOut.println(perceptron.numberOfInputs());
        StdOut.println(perceptron.predictMulti(training1));
        StdOut.println(perceptron.toString());
    }

}
