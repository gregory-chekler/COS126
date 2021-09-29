import java.awt.Color;

public class ImageClassifier {

    /**
     * Creates and returns a feature vector (1D array) from the given picture
     *
     * @param picture an image that contains RGB values
     * @return 1D array of vectors that represent light and dark parts of image
     */
    // Creates a feature vector (1D array) from the given picture.
    public static double[] extractFeatures(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        double[] values = new double[width * height];//width * height amount of vectors in the array

        int i = 0; //used to a
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color color = picture.get(col, row); //gets color of pixel in picture
                int gray = color.getRed();//since images are grayscale, can get R,G, or B (all are equal).
                values[i] = gray; //sets value of R, G, and B t
                i++;
            }
        }
        return values;
    }

    /**
     * takes data from training file, trains a perceptron to identify certain types of images,
     * then tests the efficacy of the perceptron using a testing file and prints out an error rate
     *
     * @param args Command-line arguments for training and testing data
     */
    public static void main(String[] args) {
        //sets up values for training the perceptron
        In training = new In(args[0]);
        int m = training.readInt();
        int width = training.readInt();
        int height = training.readInt();

        MultiPerceptron object = new MultiPerceptron(m, width*height); //creates actual perceptron

        //StdOut.println(m);
        //StdOut.println(width + " " + height);

        //trains perceptron object to recognize certain images,
        // displays those images (currently commented out), and prints filename and what image represents
        while (!training.isEmpty()) {
            String filename = training.readString();
            int label = training.readInt();

            Picture picture = new Picture(filename);
            double[] x = extractFeatures(picture); //puts image into 1D array vectors representing RGB vals

            object.trainMulti(x, label); //trains perceptron based on array, and what image the array should represent

            //picture.show();

            //StdOut.println(filename + " " + label);
        }

        //sets up values for testing the perceptron
        In testing = new In(args[1]);
        int m2 = testing.readInt();
        int width2 = testing.readInt();
        int height2 = testing.readInt();
        //StdOut.println(m2);
        //StdOut.println(width2 + " " + height2);

        // errors and totals used to give error rate at end. Float used for division at end of program
        float errors = 0;
        int total = 0;

        //tests perceptron object based on training by comparing
        //prediction to the actual number; displays error rate
        while (!testing.isEmpty()) {
            String filename = testing.readString();
            int label = testing.readInt();

            Picture picture = new Picture(filename);

            double[] x = extractFeatures(picture); //puts image into 1 array vectors representing RGB vals

            int prediction = object.predictMulti(x); //will predict the label based on fed 1D array vectors

            if (prediction != label) {
                errors++;
            }
            total++;

            //picture.show();

            StdOut.println(filename);
        }
        float errorRate = (errors/total);
        StdOut.println("test error rate = " + errorRate);

    }

}
