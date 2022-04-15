import java.awt.Color;

public class BeadFinder {

    private Boolean[][] pixels; // marks visited pixels
    private Stack<Blob> blobs; // contains all found blobs
    private Picture image; // Picture being used
    private double Tau;

    /**
     * Does depth-first search on all pixels and sees if they have enough
     * luminance. If so, it adds them to a blob.
     *
     * @param blob the item the pixel belongs to
     * @param col  the x coord
     * @param row  the y coord
     */
    private void dfs(Blob blob, int col, int row) {

        // Check if the current col or row is out of bounds
        if (col < 0 || col >= pixels.length || row < 0
                || row >= pixels[0].length || pixels[col][row] == true) {
            return;
        }

        Color color = image.get(col, row);

        // checks if pixel is below tau value
        if ((Luminance.intensity(color) < Tau)) {
            pixels[col][row] = true;
            return;
        }

        pixels[col][row] = true; // marks as visited
        blob.add(col, row); // adds pixel to blob

        //checks all 4 near pixels
        dfs(blob, col, row - 1);
        dfs(blob, col - 1, row);
        dfs(blob, col + 1, row);
        dfs(blob, col, row + 1);
    }

    /**
     * finds all blobs in the specified picture using luminance threshold tau
     *
     * @param picture the image being analyzed
     * @param tau     value that luminance of pixel has to be above
     */
    public BeadFinder(Picture picture, double tau) {
        image = picture;
        blobs = new Stack<>();
        Tau = tau;
        int Width = picture.width();
        int Height = picture.height();


        pixels = new Boolean[Width][Height];

        // marks all pixels as not visited
        for (int row = 0; row < Height; row++) {
            for (int col = 0; col < Width; col++) {
                pixels[col][row] = false;
            }
        }

        // goes through ever pixel and checks if qualified to be in blob
        for (int row = 0; row < Height; row++) {
            for (int col = 0; col < Width; col++) {
                Color color = image.get(col, row);
                Blob b = new Blob(); // sets up new blob anytime dfs finishes
                // makes sure pixel has not been visited and has high enough tau
                if (Luminance.intensity(color) >= Tau && pixels[col][row] == false) {
                    blobs.push(b); // adds blob since pixel is qualified
                    dfs(blobs.peek(), col, row);
                }
            }
        }
    }

    /**
     * returns all beads (blobs with >= min pixels)
     *
     * @param min the minimum mass of the blob
     * @return an array of the blobs
     */
    public Blob[] getBeads(int min) {
        Stack<Blob> blobStack = new Stack<>();
        int size = blobs.size();
        for (int i = 0; i < size; i++) {
            Blob blob = blobs.pop(); // returns blob on top of stack
            if (blob.mass() >= min) {
                blobStack.push(blob);
            }
        }
        Blob[] Array = new Blob[blobStack.size()]; // creates array from stack size
        for (int i = 0; i < Array.length; i++) {
            Array[i] = blobStack.pop();
        }
        return Array;
    }


    /**
     * Test client analyzes an image and finds all beads, then prints them out
     *
     * @param args Command-line args represent min, tau, and image
     */
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        float tau = Float.parseFloat(args[1]);
        String filename = args[2];
        Picture picture = new Picture(filename);
        BeadFinder b = new BeadFinder(picture, tau);
        Blob[] array = b.getBeads(min);

        //returns all beads in array
        for (int i = 0; i < array.length; i++) {
            StdOut.println(array[i].toString());
        }
    }
}

