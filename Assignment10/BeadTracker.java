public class BeadTracker {
    /**
     * Tracks distances beads travel from one frame to the next
     *
     * @param args Command-line args: min, tau, delta, sequence of filenames
     */
    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        String[] images = new String[args.length - 3];

        // puts images in an array
        for (int i = 3; i < args.length; i++) {
            images[i - 3] = args[i];
        }

        Picture picture = new Picture(images[0]);
        BeadFinder b1 = new BeadFinder(picture, tau);
        Blob[] time = b1.getBeads(min);

        Picture picture2 = new Picture(images[1]);
        BeadFinder b2 = new BeadFinder(picture2, tau);
        Blob[] timeDelta = b2.getBeads(min);

        // determines distances
        for (int t = 0; t < images.length - 1; t++) {
            if (t != 0) {
                // beads of time t
                time = timeDelta;

                // image of time t + 1
                picture2 = new Picture(images[t + 1]);
                b2 = new BeadFinder(picture2, tau);
                timeDelta = b2.getBeads(min);
            }

            double val;
            for (int i = 0; i < timeDelta.length; i++) { // checks each t + 1
                double distance = delta + 1; // more val could ever be
                for (int x = 0; x < time.length; x++) { // checks t + 1 against all t
                    val = timeDelta[i].distanceTo(time[x]);
                    if (val <= delta && val < distance) {
                        distance = val;
                    }
                }
                // if distance too large, journey ended or begun
                if (distance <= delta) {
                    StdOut.printf("%.4f\n", distance);
                }
            }
        }
        StdOut.println(timer.elapsedTime() + " seconds");
    }
}
