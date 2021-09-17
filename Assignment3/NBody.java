public class NBody {

    /**
     * simulates a universe of a number of planets that move depending on the
     * gravitational forces that other planets apply
     *
     * @param "args" Command-line arguments for tau and dt
     */
    public static void main(String[] args) {

        double tau = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        // reads first two lines of txt file info
        int n = StdIn.readInt();
        double radius = StdIn.readDouble();

        // defines arrays used later on for simulation
        double[] px = new double[n + 1]; // x position
        double[] py = new double[n + 1];
        double[] vx = new double[n + 1]; // velocity in x direction
        double[] vy = new double[n + 1];
        double[] mass = new double[n + 1];
        String[] image = new String[n + 1];
        double[] fx = new double[n + 1]; // force in x direction
        double[] fy = new double[n + 1];


        // reads rest of txt file info
        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }

        // Initializes standard drawing.
        StdDraw.setXscale(-1 * radius, radius);
        StdDraw.setYscale(-1 * radius, radius);
        StdDraw.enableDoubleBuffering(); // makes simulation smoother

        StdAudio.play("2001.wav");

        // used to make computations easier to follow
        double f = 0; // force of gravity
        double r = 0; // distance btwn planets

        // x and y accelerations
        double[] ay = new double[n + 1];
        double[] ax = new double[n + 1];

        double GRAVITATIONAL_CONSTANT = 6.67e-11;

        StdDraw.picture(0.0, 0.0, "starfield.jpg");
        StdDraw.show();
        for (double t = 0; t < tau; t += dt) {
            StdDraw.picture(0.0, 0.0, "starfield.jpg");

            for (int i = 0; i < n; i++) { // iterates through each planet
                // resets forces sum for each planet after each change in time
                fx[i] = 0;
                fy[i] = 0;

                for (int z = 0; z < n; z++) { // iterates through planet's pairs

                    // makes sure that not calculating planets forces on itself
                    if (i != z) {
                        r = Math.sqrt(Math.pow((px[i] - px[z]), 2)
                                              + Math.pow((py[i] - py[z]), 2));
                        f = (GRAVITATIONAL_CONSTANT * mass[i] * mass[z])
                                / Math.pow(r, 2);
                        fx[i] += (f * (px[z] - px[i])) / r; // sums forces
                        fy[i] += (f * (py[z] - py[i])) / r;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                ax[i] = fx[i] / mass[i];
                ay[i] = fy[i] / mass[i];
                vx[i] = vx[i] + ax[i] * dt;
                vy[i] = vy[i] + ay[i] * dt;
                px[i] = px[i] + vx[i] * dt;
                py[i] = py[i] + vy[i] * dt;

            }
            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }

        // for testing/grading
        //
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }
    }
}
